package JAVA.Customer;

import java.util.Scanner;

public class customerView {
	customerList customers=new customerList();
	Scanner scan=new Scanner(System.in);
	
	public void start() {
		int i=0;
		this.menu();
		do {
			i=scan.nextInt();
		}while (this.Judge(i));
		this.Choose(i);
	}

	//选择
	public void Choose(int i) {
		switch(i) {
			case 1:
				customers.add();
				this.start();
			case 2:
				customers.delete();
				this.start();
			case 3:
				customers.revise();
				this.start();
			case 4:
				customers.query();
				this.start();
			case 5:
				this.Off();
				break;
		}
		
	}
	
	public boolean Judge(int i) {
		if (i == 1) {
			return false;
		}else if (i == 2) {
			return false;
		}else if (i == 3) {
			return false;
		}else if (i == 4) {
			return false;
		}
		System.out.print("输入有误，请重新输入：");
		return true;
	}
	
	//菜单
	private void menu() {
		System.out.println("--------------------------------");
		System.out.println("\t客户信息管理系统\n");
		System.out.println("\t1. 增  加  用  户");
		System.out.println("\t2. 删  除  用  户");
		System.out.println("\t3. 修  改  用  户");
		System.out.println("\t4. 显  示  用  户");
		System.out.println("\t5.       退  出");
		System.out.println("--------------------------------");
		System.out.println("请输入选项:");
	}
	
	//退出
	private void Off() {
		System.out.println("您确认退出吗？（n/y）");
		String a=scan.next();
		switch (a) {
			case "y":
				System.out.println("感谢使用本系统");
				System.out.println("再见！");
				System.exit(0);
				break;
			case "n":
				this.start();
				break;
			default:
				this.start();
				System.out.println("输入有误，默认返回初始界面");
		}
	}
	
	
}
