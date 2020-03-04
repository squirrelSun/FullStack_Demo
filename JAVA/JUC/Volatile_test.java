package JAVA.JUC;

/*
 * 内存可见性：多个线程操作共享数据时，彼此不可见
 * 
 * Volatile：当多个线程操作共享数据时，可以保证内存中的数据是可见的
 * 		相较于synchronized是一种较轻量级的同步策略
 * 1.不具备互斥性
 * 2.不能保证变量的原子性
 * */

public class Volatile_test {
	
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		
		while(true){
			if(td.isFlag()){
				System.out.println("------------------");
				break;
			}
		}
		
	}

}

class ThreadDemo implements Runnable {

	private volatile boolean flag = false;

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		flag = true;
		
		System.out.println("flag=" + isFlag());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
