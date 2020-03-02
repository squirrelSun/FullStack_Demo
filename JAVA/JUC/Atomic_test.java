package JAVA.JUC;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 变量的原子性（类似于事务的原子性）
 * 	i++
 * 
 * 原子变量
 * 	1.具有volatile的内存可见性特点
 * 	2.CAS算法（硬件对于并发操作共享数据的支持）保证数据的原子性
 * 			当且仅当	内存值 == 预估值  时，	预估值 = 更新值 	，否则将不做任何操作，但不会放弃cup使用权，立即重试
 * 			向从内存读取内存值，在进行修改操作时，再次读取内存值记为预估值，两次相同进行修改替换
 * */

public class Atomic_test {

	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		
		for (int i = 0; i < 10; i++) {
			new Thread(ad).start();
		}
	}
	
}

class AtomicDemo implements Runnable{
	
//	private volatile int serialNumber = 0;
	
	private AtomicInteger serialNumber = new AtomicInteger();

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		
		System.out.println(getSerialNumber());
	}
	/*
	 * getAndIncrement()	i++
	 * getAndDecrement()	i--
	 * incrementAndGet()	++i
	 * decrementAndGet()	--i
	 */
	public int getSerialNumber(){
		return serialNumber.getAndIncrement();
	}

}
