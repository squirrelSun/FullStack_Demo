package Customer;

import java.util.Scanner;

public class customerList {
	customer[] customers;
	Scanner scan=new Scanner(System.in);
	
	//增加
	public void add() {
		System.out.println("请依次输入人员信息");
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
	
	//删除
	public void delete() {
		if (this.customers == null) {
			System.out.println("暂无人员信息");
			return;
		}
		System.out.print("请输入要删除人员的信息编号：");
		int i=scan.nextInt();
		if (i<=0 && i>this.customers.length) {
			System.out.println("输入有误，查无此人！");
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
	
	//修改
	public void revise() {
		if (this.customers == null) {
			System.out.println("暂无人员信息");
			return;
		}
		System.out.print("请输入要修改人员的信息编号：");
		int i=scan.nextInt();
		if (i<=0 && i>this.customers.length) {
			System.out.println("输入有误，查无此人！");
			return;
		}
		System.out.print("您想将"+this.customers[i-1].name+"修改为：");
		this.customers[i-1].setName(scan.next());
		System.out.print("您想将"+this.customers[i-1].sex+"修改为：");
		this.customers[i-1].setSex(scan.next());
		System.out.print("您想将"+this.customers[i-1].age+"修改为：");
		this.customers[i-1].setAge(scan.nextInt());
		System.out.print("您想将"+this.customers[i-1].telephone+"修改为：");
		this.customers[i-1].setTelephone(scan.nextLong());
		System.out.print("您想将"+this.customers[i-1].email+"修改为：");
		this.customers[i-1].setEmail(scan.next());
		System.out.println("修改成功！");
	}
	
	//查找
	public void query() {
		System.out.println("--------------------------------");
		System.out.println("\t客户信息管理系统\n");
		System.out.println();
		if (this.customers == null) {
			System.out.println("暂无人员信息！");
		}else {
			System.out.println("编号 \t姓名 \t性别 \t年龄 \t电话 \t\t邮箱 ");
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
