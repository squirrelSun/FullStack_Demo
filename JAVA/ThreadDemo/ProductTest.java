package JAVA.ThreadDemo;
//生产，持有，消费问题
public class ProductTest {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor p = new Productor(clerk);
		p.setName("生产者");
		Customer1 c = new Customer1(clerk);
		c.setName("消费者");
		
		p.start();
		c.start();
	}
	
}

//持有
class Clerk{

	private int produceNum = 0;
	
	public synchronized void produceProductor() {
		if (produceNum < 20) {
			produceNum++;
			notify();
			System.out.println(Thread.currentThread().getName() + "开始生产第" + produceNum + "个产品");
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void produceCustomer1() {
		if (produceNum > 0) {
			System.out.println(Thread.currentThread().getName() + "开始消费第" + produceNum + "个产品");
			produceNum--;
			notify();
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

//生产
class Productor extends Thread{
	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始生产");
		while(true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.produceProductor();
		}
	}
	
} 

//消费
class Customer1 extends Thread{
	private Clerk clerk;

	public Customer1(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始消费");
		while(true) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.produceCustomer1();
		}
	}
	
}
