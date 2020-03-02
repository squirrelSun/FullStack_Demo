package JAVA.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 创建执行线程（实现Callable接口）
 * 		支持泛型，需要实现call()，此方法存在返回值和异常
 * 		执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
 * 			FutureTask 是  Future 接口的实现类，可以用于闭锁操作
 * 
 * Runnable接口不支持泛型，实现run()，无返回值无异常
 * */

public class Collable_test {
	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1();
		
		//1.创建FutureTask类对象，用于接收运算结果
		FutureTask<Integer> result = new FutureTask<>(td);
		
		//启动线程
		new Thread(result).start();
		
		//2.接收线程运算后的结果
		try {
			Integer sum = result.get();  //当前运算未完成时，不会执行后续操作
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class ThreadDemo1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		
		for (int i = 0; i <= 100000; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}

/*
class ThreadDemo implements Runnable{

	@Override
	public void run() {
	}
	
}*/
