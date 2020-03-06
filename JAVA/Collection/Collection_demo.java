package JAVA.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Collection_demo {
	
	/*
	 * 从键盘读取10个整数保存到List中，并按倒序、从大到小的顺序显示出来
	 * */
	@Test
	public void test1() {
		List list = new ArrayList();
		Scanner scan = new Scanner(System.in);
		for (int i = 0 ; i < 10 ; i++) {
			System.out.print("请输入第" + (i+1) + "个整数");
			list.add(scan.nextInt());
		}
		Collections.reverse(list);//反转
		System.out.println(list);
		System.out.println("****");
		Collections.sort(list);//自然排序（从小到大）
		Collections.reverse(list);//反转为从大到小
		System.out.println(list);
	}
	
}
