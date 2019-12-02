package ThreadDemo;
//���������У���������
public class ProductTest {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor p = new Productor(clerk);
		p.setName("������");
		Customer1 c = new Customer1(clerk);
		c.setName("������");
		
		p.start();
		c.start();
	}
	
}

//����
class Clerk{

	private int produceNum = 0;
	
	public synchronized void produceProductor() {
		if (produceNum < 20) {
			produceNum++;
			notify();
			System.out.println(Thread.currentThread().getName() + "��ʼ������" + produceNum + "����Ʒ");
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
			System.out.println(Thread.currentThread().getName() + "��ʼ���ѵ�" + produceNum + "����Ʒ");
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

//����
class Productor extends Thread{
	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��ʼ����");
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

//����
class Customer1 extends Thread{
	private Clerk clerk;

	public Customer1(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��ʼ����");
		while(true) {
			try {
				sleep(11);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.produceCustomer1();
		}
	}
	
}
