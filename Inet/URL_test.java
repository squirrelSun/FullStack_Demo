package Inet;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

/*
 * URL网络编程
 * 
 * URL：统一资源定位符，对应着互联网的某一资源地址
 * 格式：
 * 	协议+	主机名+端口号+资源地址（?参数列表）
 * 
 * */

public class URL_test {

	@Test
	public void test() throws MalformedURLException {
		//实例化对象
		URL url = new URL("https://www.baidu.com/s?ie=UTF-8&wd=hao123");
		
		//获取URL的协议名
		System.out.println(url.getProtocol());
		//获取URL的主机名
		System.out.println(url.getHost());
		//获取URL的端口号
		System.out.println(url.getPort());
		//获取URL的文件路径
		System.out.println(url.getPath());
		//获取URL的文件名
		System.out.println(url.getFile());
		//获取URL的查询名
		System.out.println(url.getQuery());
	}
	
}
