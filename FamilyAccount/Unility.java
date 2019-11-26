package FamilyAccount;

import java.util.Scanner;

//������
public class Unility {

	private int money=10000;//��ʼ���
	private int[] changeMoney;
	private String[] InOrOut;
	private String[] explain;
	
	
	public void start() {
		this.Menu();//�˵�ҳ
		Scanner scan=new Scanner(System.in);
		int i=0;
		do {
			i=scan.nextInt();
		}while (this.Judge(i));
		this.Choose(i);
	}
	

	public void Menu() {
		System.out.println("--------------------------------");
		System.out.println("\t��ͥ�����˼�¼ϵͳ\n");
		System.out.println("\t1. ��  ֧  ��  ϸ");
		System.out.println("\t2. ��  ��  ��  ¼");
		System.out.println("\t3. ֧  ��  ��  ¼");
		System.out.println("\t4.    ��  ��");
		System.out.println("--------------------------------");
		System.out.println("���������֣�");
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
		System.out.println("���������������������룺");
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
		System.out.println("��ȷ��Ҫ�˳���  ��y/n��");
		String a=scan.next();
		switch (a) {
			case "y":
				System.out.println("��ӭ�´�ʹ��");
				System.out.println("�ɹ��˳���");
				System.exit(0);
				break;
			case "n":
				this.start();
				break;
			default:
				System.out.println("��������Ĭ�ϲ��˳���");
				this.start();
		}
	}


	private void InOrOut() {
		Scanner scan=new Scanner(System.in);
		System.out.println("�������");
		int money=scan.nextInt();
		System.out.println("�����뷽ʽ��");
		String ioo=scan.next();
		System.out.println("��������Ŀ˵����");
		String exp=scan.next();
		this.setChangeMoney(changeMoney, money);
		this.setInOrOut(InOrOut, ioo);
		this.setExplain(explain, exp);
		System.out.println("��Ŀ��¼�ɹ���");
		this.start();
	}


	private void Show() {
		System.out.println("--------------------------------\n");
		System.out.println("\t1. ��  ֧  ��  ϸ");
		System.out.println("���\t���\t��֧\t˵��");
		int[] cm=this.getChangeMoney();
		String[] ioo=this.getInOrOut();
		String[] exp=this.getExplain();
		int showCM=getMoney();
		for (int i=0 ;i<ioo.length ; i++) {
			switch (ioo[i]) {
				case "����":
					showCM=showCM+cm[i];
					break;
				case "֧��":
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
			this.setInOrOut(this.InOrOut, "����");
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
			this.setExplain(this.explain, "��ʼ���");
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
