package Customer;

import java.util.Scanner;

public class customerList {
	customer[] customers;
	Scanner scan=new Scanner(System.in);
	
	//����
	public void add() {
		System.out.println("������������Ա��Ϣ");
		customer customer=new customer(scan.next(),scan.next(),scan.nextInt(),scan.nextLong(),scan.next());
		int people=0;
		if (this.customers == null) {
			people=1;
		}else {
			people=this.customers.length+1;
		}
		customer[] customers=new customer[people];
		if (people != 1) {			
			for (int i=0 ; i<this.customers.length ; i++) {
				customers[i]=this.customers[i];
			}
		}
		customers[people-1]=customer;
		this.customers=customers;
	}
	
	//ɾ��
	public void delete() {
		if (this.customers == null) {
			System.out.println("������Ա��Ϣ");
			return;
		}
		System.out.print("������Ҫɾ����Ա����Ϣ��ţ�");
		int i=scan.nextInt();
		if (i<=0 && i>this.customers.length) {
			System.out.println("�������󣬲��޴��ˣ�");
			return;
		}
		if (this.customers.length == 1) {
			customer[] customers=new customer[0];
			this.customers=customers;
		}else {
			customer[] customers=new customer[this.customers.length-1];
			for (int m=0,n=0; m<this.customers.length ; m++) {
				if (m == (i-1)) {
					continue;
				}
				customers[n]=this.customers[m];
				n++;
			}
			this.customers=customers;
		}
	}
	
	//�޸�
	public void revise() {
		if (this.customers == null) {
			System.out.println("������Ա��Ϣ");
			return;
		}
		System.out.print("������Ҫ�޸���Ա����Ϣ��ţ�");
		int i=scan.nextInt();
		if (i<=0 && i>this.customers.length) {
			System.out.println("�������󣬲��޴��ˣ�");
			return;
		}
		System.out.print("���뽫"+this.customers[i-1].name+"�޸�Ϊ��");
		this.customers[i-1].setName(scan.next());
		System.out.print("���뽫"+this.customers[i-1].sex+"�޸�Ϊ��");
		this.customers[i-1].setSex(scan.next());
		System.out.print("���뽫"+this.customers[i-1].age+"�޸�Ϊ��");
		this.customers[i-1].setAge(scan.nextInt());
		System.out.print("���뽫"+this.customers[i-1].telephone+"�޸�Ϊ��");
		this.customers[i-1].setTelephone(scan.nextLong());
		System.out.print("���뽫"+this.customers[i-1].email+"�޸�Ϊ��");
		this.customers[i-1].setEmail(scan.next());
		System.out.println("�޸ĳɹ���");
	}
	
	//����
	public void query() {
		System.out.println("--------------------------------");
		System.out.println("\t�ͻ���Ϣ����ϵͳ\n");
		System.out.println();
		if (this.customers == null) {
			System.out.println("������Ա��Ϣ��");
		}else {
			System.out.println("��� \t���� \t�Ա� \t���� \t�绰 \t\t���� ");
			for (int i=0 ; i<this.customers.length ; i++) {
				System.out.println((i+1)+
									"\t"+this.customers[i].getName()+
									"\t"+this.customers[i].getSex()+
									"\t"+this.customers[i].getAge()+
									"\t"+this.customers[i].getTelephone()+
									"\t\t"+this.customers[i].getEmail());
			}
		}
	}
	
}
