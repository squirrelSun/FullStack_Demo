package CommonClass.String_BufferBuilder;

import java.util.Arrays;
import org.junit.Test;

//String练习
public class String_demo {
	
	//去除字符串两端空格
	@Test 
	public void test1() {
		String str = "   as  d  ";
		int first = firstIndex(str);
		int last = lastIndex(str);
		if (first != -1 && last != -1) {	//非全空字符
			String newString = str.substring(first, last+1);
			System.out.println("去除空格前为" + str);
			System.out.println("去除空格后为" + newString);
		}else {	//全空字符
			System.out.println("为全空字符串");
		}
		
	}
	public int firstIndex(String str) {	//获取正序首个非空格字符对应的角标
		char[] c = str.toCharArray();
		for (int i = 0 ; i < c.length ; i++) {
			if (c[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	public int lastIndex(String str) {	//获取倒序首个非空格字符对应的角标
		char[] c = str.toCharArray();
		for (int i = c.length-1 ; i > 0 ; i--) {
			if (c[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	//将字符串指定部分进行翻转
	@Test
	public void test2() {
		String str = "asdsgfdfhbxc";
		String target = "fdfh";
		String newTarget = targetString(target);
		System.out.println(newTarget);
		String newString = str.replaceAll(target, newTarget);
		System.out.println(newString);
	}
	public String targetString (String str) {	//翻转字符串
		char[] c = str.toCharArray();
		if (c.length >= 1) {
			for (int i = 0 ; i < c.length/2 ; i++) {
				char change = c[i];
				c[i] = c[c.length-1-i];
				c[c.length-1-i] = change;
			}
		}
		StringBuilder newString = new StringBuilder();
		for (int i = 0 ; i < c.length ; i++) {
			newString.append(c[i]);
		}
		return newString.toString();
	}
	
	//一个字符串在另一个字符串中出现的次数
	@Test
	public void test3() {
		String str = "asdsgfdfhdbxdc";
		String target = "f";
		int[] index = new int[str.length()];
		int t = this.index(str.toCharArray() , target.toCharArray() , index , 0);
		System.out.println(t);
	}
	public int index(char[] c1 , char[] c2 , int[] index , int corner) {
		if (corner == 0) {	//记录字串的第一个字符在原字符串的角标
			int[] newIndex = new int[c1.length];
			int time = 0;
			for (int i = 0 ; i < c1.length ; i++) {
				if (c1[i] == c2[corner]) {
					newIndex[time] = i+1;
					time++;
				}
			}
			corner++;
			return this.index(c1 , c2 , newIndex , corner);
		}else if (corner < c2.length){	//根据角标数组，递归筛选出在字符串在原字符串的角标
			int[] newIndex = new int[index.length];
			int time = 0;
			for (int i = 0 ; i < index.length ; i++) {
				if (index[i] != 0 && c1[index[i]] == c2[corner]) {
					newIndex[time] = i+1;
					time++;
				}
			}
			corner++;
			 return this.index(c1 , c2 , newIndex , corner);
		}
		int time = 0;	//计算角标数组的长度即为出现次数
		for (int i = 0 ; i < index.length ; i++) {
			if (index[i] == 0) {
				break;
			}
			time++;
		}
		return time;
	}
	
	//对字符串中的字符进行自然排序
	@Test
	public void test4() {
		String str = "asdsgfdfhdbxdc";
		char[] a = str.toCharArray();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
