package JAVA.team.view;

import java.util.*;

//进行键盘的数据传输
public class TSUility {
	private static Scanner scan=new Scanner(System.in);
	
	//读取键盘
	public static char readMenuSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1 , false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' &&c != '4' ) {
				System.out.print("选择错误，请重新选择：");
			}else
				break;
		}
		return c;
	}

	//提示等待，直到用户按回车返回
	public static void readReturn() {
		System.out.println("请按回车继续...");
		readKeyBoard(100 , true);
	}
	
	//读取不超过2位数的整数，并作为方法的返回值
	public static int readInt() {
		int n;
		while(true) {
			String str = readKeyBoard(2 , false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	
	//键盘读取退出确认选项，作为返回值
	public static char readConfirmSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1 , false).toUpperCase();
			c = str.charAt(0);
			if (c == 'Y' || c == 'N') {
				break;
			} else {
				System.out.print("输入错误，请重新输入：");
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
				System.out.print("输入长度（不大于" + limit + "）错误，请重新输入:");
				continue;
			}
			break;
		}
		return line;
	}
	
}
