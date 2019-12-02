package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ���̵߳Ĵ���
 * 	����һ�������̳���Thread�����࣬��дrun()����������������󣬵���start������(����������_�߳�һ\��������_�̶߳�)
 * 	������������ʵ��Runnable�ӿڵ��࣬ʵ������дrun()����������ʵ������󣬴˶�����Ϊ�������ݸ�Thread��Ĺ��������������󣬵���start������
 * 	������������ʵ��Callable�ӿڵ��࣬ʵ������дcall()����д��ִ�еĲ���������ʵ������󣬴˶�����Ϊ�������ݸ�Thread��Ĺ��������������󣬵���start��������get()��ȡcall()�����ķ���ֵ��
 * 	�����ģ��̳߳�
 * 	����ʹ���̳߳ء��ӿڱ����˵��̳У����״������̹߳�������
 * 
 * �̵߳�״̬��
 * 		�½�������������
 *		��������start()�󣬵ȴ�����CPUʱ��Ƭ���߱���������������δ������CPU��Դ
 *		���У����CPU������Դ
 *		��������Ϊ��������ȣ��ó�CPU����ʱ��ֹ�Լ��Ĳ����͹���
 *		���������ȫ����������ǰǿ������ֹ������쳣���½���
 * 
 * �߳����ȼ���
 * 	���ȼ���ռģʽ�������ȼ�����ʱ�CPUִ�У�
 * 		Ĭ�ϣ�NORM_PRIORIT��Ϊ5�����MAX_PRIORITY��Ϊ10����СΪ��MIN_PRIORITY��1
 * 		getPriorit()��ȡ���ȼ�
 * 		setPriorit(int p)�������ȼ�
 * 
 * ͨ��ͬ�����ƣ�����̰߳�ȫ���⣨����ͬ������ʱ��ֻ��һ���̲߳��룬�����̵߳ȴ��������ڵ��̵߳Ĺ��̣�
 * 	��ʽһ��ͬ�������
 * 		synchronized(ͬ��������){
 * 			//����ͬ������(������������)
 * 		}
 * 		ͬ�����������������κ�һ����Ķ��󣬶����Գ䵱����Ҫͬ�����̹߳���һ�������õ�ǰ��  this.class��
 * 	��ʽ����ͬ�������������������ݵĴ���������������һ�������У�
 * 		private synchronized void ***(){
 * 			//����ͬ������(������������)
 * 		}
 * 		ͬ������������Ҫ��ʽ����
 * 	��ʽ����Lock����ʵ��Runnable�ӿ�ʱ��
 *	 		class *** implements Runnable{
 *				private ReentrantLock lock = new ReentrantLock();
 *				public void run() {
 *					try {
 *						//����ͬ������(������������)
 *						lock.lock();
 *					}finally {
 *						lock.unlock();
 *					}
 *				}
 *	 		}
 * 	��������ͬ���̣߳�û���쳣����ʾ��ȫ����������״̬���ȴ��Է������Լ���Ҫ��ͬ����Դ
 * 	
 * ���÷�����
 * 		void start()������ǰ�̲߳����õ�ǰ�̵߳�run()����
 * 		run()��дThread���еĴ˷����������߳�Ҫִ�еĲ��������ڴ˷�����
 * 		String currentThread()���ص�ǰ�̶߳���
 * 		void setName(String name)�����߳�����
 * 		static Thread getName()�����߳�����
 * 		static void yield()�߳��ò�(�ͷŵ�ǰCPU��ʹ��Ȩ)
 * 		join()���߳�a�е����߳�b��join()�������߳�a��������״̬��ֱ���߳�b��ȫִ�����߳�a��������״̬
 * 		static void sleep(long millies)��ǰ�߳�����millies���룬���а�ȫ��
 * 		stop()ǿ���߳��������ڽ���(�ѹ�ʱ)
 * 		boolean isAlive()�ж��߳��Ƿ񻹴��
 * 		wait()��ǰ�߳̽�������״̬���ͷŰ�ȫ��
 * 		notify()/notifyAll()���ѱ�wait()��һ����ȫ�����߳�
 * */

public class MyThread extends Thread{
	
	public static void main(String[] args) {
		//�߳�һ
		MyThread1 my1 = new MyThread1();
		my1.start();		
		
		//�̶߳�
		new Thread() {
			public void run() {
				for (int i = 0 ; i <= 100 ; i++) {
					if (i % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
		
		//�߳���
		MyThread2 my2 = new MyThread2();
		Thread t1 = new Thread(my2);
		t1.start();
		
		//�߳���
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
			System.out.println("�ܺ�Ϊ��" + sum);
		}
		
		//�߳���
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.execute(new MyThread2());		//������Runnable
		service.submit(new MyThread3());	//������Callable
		service.shutdown();
		
		ThreadTest test = new ThreadTest("�����߳�");
//		test.setName("�����߳�");	
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
	
	//����������
	public ThreadTest(String name) {
		super(name);
	}
	
}