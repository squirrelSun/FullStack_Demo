package CommonClass.System;

import org.junit.Test;
/*
 * Java�����������
 * 
 * */
public class System_test {

	@Test
	public void test() {
		//��ȡJava�汾
		String javaVersion = System.getProperty("java.version");
		System.out.println("java��Version: " + javaVersion);
		//��ȡJava�ļ�·��
		String javaHome = System.getProperty("java.home");
		System.out.println("java��home: " + javaHome);
		//��ȡϵͳ����
		String osName = System.getProperty("os.name");
		System.out.println("os��name: " + osName);
		//��ȡϵͳ�汾
		String osVersion = System.getProperty("os.version");
		System.out.println("os��Version: " + osVersion);
		//��ȡϵͳ�û���
		String userName = System.getProperty("user.name");
		System.out.println("use��name: " + userName);
		//��ȡ��ǰ�û����ļ�·��
		String userHome = System.getProperty("user.home");
		System.out.println("use��home: " + userHome);
		//��ȡ��ǰ����·��
		String userDir = System.getProperty("user.dir");
		System.out.println("user��dir: " + userDir);
	}
	
	
}
