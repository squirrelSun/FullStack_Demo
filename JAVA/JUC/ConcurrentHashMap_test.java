package JAVA.JUC;

/*
 * HashMap：线程不安全，效率高
 * Hashtable：线程安全，效率极低（整个哈希表均会被锁）
 * 
 * ConcurrentHashMap
 * 	采用“锁分段”机制， 默认存在16个段，每一个段采用CAS算法，确保线程的安全性
 * */

/*
 * 模拟 CAS 算法
 */
public class ConcurrentHashMap_test {

	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int expectedValue = cas.get();
					boolean b = cas.compareAndSet(expectedValue, (int)(Math.random() * 101));
					System.out.println(b);
				}
			}).start();
		}
		
	}
	
}

class CompareAndSwap{
	private int value;
	
	//获取内存值
	public synchronized int get(){
		return value;
	}
	
	//比较
	public synchronized int compareAndSwap(int expectedValue, int newValue){
		int oldValue = value;
		
		if(oldValue == expectedValue){
			this.value = newValue;
		}
		
		return oldValue;
	}
	
	//设置
	public synchronized boolean compareAndSet(int expectedValue, int newValue){
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}
