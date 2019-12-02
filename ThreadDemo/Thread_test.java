package ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

//2���������ֱ���ͬһ���˻���3000��ÿ��1000�������Σ���ӡÿ���˻����
public class Thread_test {

	public static void main(String[] args) {
		Account acct = new Account();
		Customer c1 = new Customer(acct);
		c1.setName("asd");
		Customer c2 = new Customer(acct);
		c2.setName("zxc");
		
		c1.start();
		c2.start();
	}
}

class Account{
	
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	} 
	
	//��Ǯ
	public void add(double amt) {
		if (amt > 0) {
			try {
				balance += amt;
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��Ǯ�ɹ������Ϊ��" + balance);
		}
	}
}

class Customer extends Thread{
	
	private Account acct;

	public Customer(Account acct) {
		this.acct = acct;
	}
	
	private static ReentrantLock lock = new ReentrantLock();

	public void run() {
		for (int i =0 ; i < 3 ; i++) {
			try {
				lock.lock();
				acct.add(1000);				
			}
			finally {
				lock.unlock();
			}
		}
	}
	
}
