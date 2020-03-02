package JAVA.JUC;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * 添加操作多时，效率低，因为每次添加时都会进行复制，内存开销非常大。
 * 并发迭代操作多时可以选择。
 */

public class CopyOnWriteArrayList_test {
	
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		
		for (int i = 0; i < 10; i++) {
			new Thread(ht).start();
		}
	}
	
}

class HelloThread implements Runnable{
	
	//发生并发修改异常
//	private static List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	//每次写入时均会复制一个新列表进行写入操作
	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
	
	static{
		list.add("AA");
		list.add("BB");
		list.add("CC");
	}

	@Override
	public void run() {
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
			
			list.add("AA");
		}
		
	}
	
}
