package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 多线程的创建
 * 	方法一：创建继承于Thread的子类，重写run()方法，创建子类对象，调用start方法。(非匿名子类_线程一\匿名子类_线程二)
 * 	方法二：创建实现Runnable接口的类，实现类重写run()方法，创建实现类对象，此对象作为参数传递给Thread类的构造器，创建对象，调用start方法。
 * 	方法三：创建实现Callable接口的类，实现类重写call()方法写入执行的操作，创建实现类对象，此对象作为参数传递给Thread类的构造器，创建对象，调用start方法。（get()获取call()方法的返回值）
 * 	方法四：线程池
 * 	优先使用线程池。接口避免了单继承，容易处理多个线程共享数据
 * 
 * 线程的状态：
 * 		新建：声明并创建
 *		就绪：被start()后，等待进入CPU时间片，具备运行条件，但是未分配有CPU资源
 *		运行：获得CPU运行资源
 *		阻塞：人为挂起操作等，让出CPU并临时终止自己的操作和功能
 *		死亡：完成全部工作或提前强制性终止或出现异常导致结束
 * 
 * 线程优先级：
 * 	优先级抢占模式（高优先级大概率被CPU执行）
 * 		默认（NORM_PRIORIT）为5，最大（MAX_PRIORITY）为10，最小为（MIN_PRIORITY）1
 * 		getPriorit()获取优先级
 * 		setPriorit(int p)设置优先级
 * 
 * 通过同步机制，解决线程安全问题（操作同步代码时，只有一个线程参与，其他线程等待，类似于单线程的过程）
 * 	方式一：同步代码块
 * 		synchronized(同步监视器){
 * 			//操作同步代码(操作共享数据)
 * 		}
 * 		同步监视器（锁）：任何一个类的对象，都可以充当，需要同步的线程公用一个锁（用当前类  this.class）
 * 	方式二：同步方法（操作共享数据的代码完整的声明在一个方法中）
 * 		private synchronized void ***(){
 * 			//操作同步代码(操作共享数据)
 * 		}
 * 		同步监视器不需要显式声明
 * 	方式三：Lock锁（实现Runnable接口时）
 *	 		class *** implements Runnable{
 *				private ReentrantLock lock = new ReentrantLock();
 *				public void run() {
 *					try {
 *						//操作同步代码(操作共享数据)
 *						lock.lock();
 *					}finally {
 *						lock.unlock();
 *					}
 *				}
 *	 		}
 * 	死锁：不同的线程，没有异常和提示，全部处于阻塞状态，等待对方放弃自己需要的同步资源
 * 	
 * 常用方法：
 * 		void start()启动当前线程并调用当前线程的run()方法
 * 		run()重写Thread类中的此方法，创建线程要执行的操作声明在此方法中
 * 		String currentThread()返回当前线程对象
 * 		void setName(String name)设置线程名称
 * 		static Thread getName()返回线程名称
 * 		static void yield()线程让步(释放当前CPU的使用权)
 * 		join()在线程a中调用线程b的join()方法，线程a进入阻塞状态，直到线程b完全执行完线程a结束阻塞状态
 * 		static void sleep(long millies)当前线程阻塞millies毫秒，持有安全锁
 * 		stop()强制线程生命周期结束(已过时)
 * 		boolean isAlive()判断线程是否还存活
 * 		wait()当前线程进入阻塞状态，释放安全锁
 * 		notify()/notifyAll()唤醒被wait()的一个（全部）线程
 * */

public class MyThread extends Thread{
	
	public static void main(String[] args) {
		//线程一
		MyThread1 my1 = new MyThread1();
		my1.start();		
		
		//线程二
		new Thread() {
			public void run() {
				for (int i = 0 ; i <= 100 ; i++) {
					if (i % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
		
		//线程三
		MyThread2 my2 = new MyThread2();
		Thread t1 = new Thread(my2);
		t1.start();
		
		//线程四
		MyThread3 my3 = new MyThread3();
		FutureTask ft = new FutureTask(my3);
		new Thread(ft).start();;
		Object sum = 0;
		try {
			sum = ft.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			System.out.println("总和为：" + sum);
		}
		
		//线程五
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.execute(new MyThread2());		//适用于Runnable
		service.submit(new MyThread3());	//适用于Callable
		service.shutdown();
		
		ThreadTest test = new ThreadTest("测试线程");
//		test.setName("测试线程");	
		System.out.println(test.getPriority());
		test.setPriority(9);
		test.start();
		
		Thread.currentThread().setPriority(2);
		for (int i = 1 ; i <= 100 ; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
			if (i == 20) {
//				try {
//					test.join();
					test.stop();
//					test.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
		System.out.println(test.isAlive());
	}

}

class MyThread1 extends Thread{
	public void run() {
		synchronized (MyThread1.class) {
			for (int i = 0 ; i <= 100 ; i++) {
				if (i % 3 == 0) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
		}
	}
}

class MyThread2 implements Runnable{
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void run() {
		try {
			lock.lock();
			for (int i = 0 ; i <= 100 ; i++) {
				if (i % 2 != 0) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
		}finally {
			lock.unlock();
		}
	}
}

class MyThread3 implements Callable{

	public Object call() throws Exception {
		int sum = 0;
		for (int i = 0 ; i <= 100 ; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				sum += i;
			}
		}
		return sum;
	}
	
}


class ThreadTest extends Thread{
	public synchronized void run() {
		for (int i = 0 ; i <= 100 ; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
			if (i % 20 == 0) {
				this.yield();
			}
		}
	}
	
	//命名构造器
	public ThreadTest(String name) {
		super(name);
	}
	
}