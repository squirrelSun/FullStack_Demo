package team.view;

import java.util.*;

//���м��̵����ݴ���
public class TSUility {
	private static Scanner scan=new Scanner(System.in);
	
	//��ȡ����
	public static char readMenuSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1 , false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' &&c != '4' ) {
				System.out.print("ѡ�����������ѡ��");
			}else
				break;
		}
		return c;
	}

	//��ʾ�ȴ���ֱ���û����س�����
	public static void readReturn() {
		System.out.println("�밴�س�����...");
		readKeyBoard(100 , true);
	}
	
	//��ȡ������2λ��������������Ϊ�����ķ���ֵ
	public static int readInt() {
		int n;
		while(true) {
			String str = readKeyBoard(2 , false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return n;
	}
	
	//���̶�ȡ�˳�ȷ��ѡ���Ϊ����ֵ
	public static char readConfirmSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1 , false).toUpperCase();
			c = str.charAt(0);
			if (c == 'Y' || c == 'N') {
				break;
			} else {
				System.out.print("����������������룺");
			}
		}
		return c;
	}
	
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.length() == 0) {
				if (blankReturn)
					return line;
				else 
					continue;
			}
			if (line.length() < 1 || line.length() > limit) {
				System.out.print("���볤�ȣ�������" + limit + "����������������:");
				continue;
			}
			break;
		}
		return line;
	}
	
}
