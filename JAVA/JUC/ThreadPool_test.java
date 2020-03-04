package JAVA.JUC;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 线程池
 * 	提供了一个线程队列，保存着所有处于等待状态的线程，避免了创建与销毁线程的开销，提高响应速度
 * 
 * ExecutorService子接口：负责线程池的主要接口
 * 		ThreadPoolExecutor：实现类
 * 		ScheduledExecutorService：子接口，负责线程调度
 * 			ScheduledThreadPoolExecutor：实现类，继承于ThreadPoolExecutor，兼具线程池与调度功能
 * 
 * Executors工具类
 * 	newFixedThreadPool()：创建固定大小的连接池
 * 	newCachedThreadPool()：缓存线程池，大小不固定，可以根据需求自动更改数量
 * 	newSingleThreadExecutor()：只包含一个线程的线程池
 * 
 * 	newScheduledThreadPol()：创建固定大小的可调度的线程池，可以延迟或定时的执行任务
 * 	
 * */

public class ThreadPool_test {

	public static void main(String[] args) {
		// 创建普通线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		// Runnable接口
		// 创建任务
		ThreadPoolDemo td = new ThreadPoolDemo();
		// 为线程池中的线程分配任务
		for (int i = 0; i < 10; i++) {
			threadPool.submit(td);
		}
		// 关闭线程池
		threadPool.shutdown(); // 等待现有的线程执行完所有操作后关闭线程池
//		threadPool.shutdownNow();	//立即关闭线程池

		// 创建可调度线程的线程池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		// 为线程分配任务，参数一：任务 参数二：延迟时间 参数三：牙延迟时间单位
		for (int i = 0; i < 10; i++) {
			Future<Integer> future = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int num = new Random().nextInt(100); // 生成随机数
					System.out.println(Thread.currentThread().getName() + ":" + num);
					return num;
				}
			}, 1, TimeUnit.SECONDS);
			// 打印返回值
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 关闭连接池
		pool.shutdown();
	}

}

class ThreadPoolDemo implements Runnable {

	private int i = 0;

	@Override
	public void run() {
		while (i <= 100) {
			System.out.println(Thread.currentThread().getName() + " : " + i++);
		}
	}

}

class ThreadPoolDemo1 implements Callable<Integer> {

	private int i = 0;

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		while (i <= 100) {
			sum += i;
		}
		return sum;
	}

}