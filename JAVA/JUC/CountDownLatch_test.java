package JAVA.JUC;

import java.util.concurrent.CountDownLatch;

/*
 * 闭锁
 * 在完成某些运算时，只有子其他所有线程的运算全部完成时，才能进行当前运算
 * */

public class CountDownLatch_test {

	public static void main(String[] args) {
		
		//创建锁实例
		final CountDownLatch latch = new CountDownLatch(50);	//线程数，每一个结束运算，数字减一
		LatchDemo ld = new LatchDemo(latch);

		long start = System.currentTimeMillis();

		for (int i = 0; i < 50; i++) {
			new Thread(ld).start();
		}

		try {
			latch.await();		//当线程数为0时，继续执行下面的操作
		} catch (InterruptedException e) {
		}

		long end = System.currentTimeMillis();

		System.out.println("耗费时间为：" + (end - start));
	}

}

class LatchDemo implements Runnable {

	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 50000; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
				}
			}
		} finally {
			latch.countDown();		//运行数减一
		}

	}

}