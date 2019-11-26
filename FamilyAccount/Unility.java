package FamilyAccount;

import java.util.Scanner;

//工具类
public class Unility {

	private int money=10000;//初始金额
	private int[] changeMoney;
	private String[] InOrOut;
	private String[] explain;
	
	
	public void start() {
		this.Menu();//菜单页
		Scanner scan=new Scanner(System.in);
		int i=0;
		do {
			i=scan.nextInt();
		}while (this.Judge(i));
		this.Choose(i);
	}
	

	public void Menu() {
		System.out.println("--------------------------------");
		System.out.println("\t家庭出入账记录系统\n");
		System.out.println("\t1. 收  支  明  细");
		System.out.println("\t2. 收  入  记  录");
		System.out.println("\t3. 支  出  记  录");
		System.out.println("\t4.    退  出");
		System.out.println("--------------------------------");
		System.out.println("请输入数字：");
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
		System.out.println("输入数字有误，请重新输入：");
		return true;
	}


	public void Choose(int i) {
		switch(i) {
			case 1:
				this.Show();
				break;
			case 2:
			case 3:
				this.InOrOut();
				break;
			case 4:
				this.Off();
				break;
		}
		
	}


	private void Off() {
		Scanner scan=new Scanner(System.in);
		System.out.println("您确定要退出吗？  （y/n）");
		String a=scan.next();
		switch (a) {
			case "y":
				System.out.println("欢迎下次使用");
				System.out.println("成功退出！");
				System.exit(0);
				break;
			case "n":
				this.start();
				break;
			default:
				System.out.println("输入有误，默认不退出！");
				this.start();
		}
	}


	private void InOrOut() {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入金额：");
		int money=scan.nextInt();
		System.out.println("请输入方式：");
		String ioo=scan.next();
		System.out.println("请输入账目说明：");
		String exp=scan.next();
		this.setChangeMoney(changeMoney, money);
		this.setInOrOut(InOrOut, ioo);
		this.setExplain(explain, exp);
		System.out.println("账目记录成功！");
		this.start();
	}


	private void Show() {
		System.out.println("--------------------------------\n");
		System.out.println("\t1. 收  支  明  细");
		System.out.println("余额\t金额\t收支\t说明");
		int[] cm=this.getChangeMoney();
		String[] ioo=this.getInOrOut();
		String[] exp=this.getExplain();
		int showCM=getMoney();
		for (int i=0 ;i<ioo.length ; i++) {
			switch (ioo[i]) {
				case "收入":
					showCM=showCM+cm[i];
					break;
				case "支出":
					showCM=showCM-cm[i];
					break;
			}
			System.out.println(showCM+"\t"+cm[i]+"\t"+ioo[i]+"\t"+exp[i]);
		}
		this.start();
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int[] getChangeMoney() {
		if (this.changeMoney == null) {
			this.setChangeMoney(this.changeMoney,0);
		}
		return changeMoney;
	}


	public void setChangeMoney(int[] changeMoney,int money) {
		if (changeMoney == null) {
			this.changeMoney=new int[] {money};
		}else {
			int[] old=this.changeMoney;
			this.changeMoney=new int[this.changeMoney.length+1];
			for (int i=0 ; i<old.length ; i++) {
				this.changeMoney[i]=old[i];
			}
			this.changeMoney[this.changeMoney.length-1]=money;
		}
	}


	public String[] getInOrOut() {
		if (this.InOrOut == null) {
			this.setInOrOut(this.InOrOut, "收入");
		}
		return InOrOut;
	}


	public void setInOrOut(String[] inOrOut,String ioo) {
		if (InOrOut == null) {
			this.InOrOut=new String[] {ioo};
		}else {
			String[] old=this.InOrOut;
			this.InOrOut=new String[this.InOrOut.length+1];
			for (int i=0 ; i<old.length ; i++) {
				this.InOrOut[i]=old[i];
			}
			this.InOrOut[this.InOrOut.length-1]=ioo;
		}
	}


	public String[] getExplain() {
		if (this.explain == null) {
			this.setExplain(this.explain, "初始金额");
		}
		return explain;
	}

	
	public void setExplain(String[] explain,String exp) {
		if (explain == null) {
			this.explain=new String[] {exp};
		}else {
			String[] old=this.explain;
			this.explain=new String[this.explain.length+1];
			for (int i=0 ; i<old.length ; i++) {
				this.explain[i]=old[i];
			}
			this.explain[this.explain.length-1]=exp;
		}
	}

}
