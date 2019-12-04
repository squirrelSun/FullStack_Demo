package CommonClass.System;

import org.junit.Test;
/*
 * Java虚拟机操作类
 * 
 * */
public class System_test {

	@Test
	public void test() {
		//获取Java版本
		String javaVersion = System.getProperty("java.version");
		System.out.println("java的Version: " + javaVersion);
		//获取Java文件路径
		String javaHome = System.getProperty("java.home");
		System.out.println("java的home: " + javaHome);
		//获取系统名称
		String osName = System.getProperty("os.name");
		System.out.println("os的name: " + osName);
		//获取系统版本
		String osVersion = System.getProperty("os.version");
		System.out.println("os的Version: " + osVersion);
		//获取系统用户名
		String userName = System.getProperty("user.name");
		System.out.println("use的name: " + userName);
		//获取当前用户的文件路径
		String userHome = System.getProperty("user.home");
		System.out.println("use的home: " + userHome);
		//获取当前工程路径
		String userDir = System.getProperty("user.dir");
		System.out.println("user的dir: " + userDir);
	}
	
	
}
