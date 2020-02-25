package Inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * 网络通信
 * 
 * 网络编程要素
 * 		1.IP和端口号
 * 			IP地址：唯一标识Internet上的计算机（Java中用InetAddress类的对象封装IP地址）
 * 					IPV4、IPV6
 * 					公网地址（万维网使用）、私网地址（局域网使用）
 * 				DNS域名解析服务器
 * 				本地回路地址	127.0.0.1/localhost
 * 			端口号（0~65535）区分主机上的进程
 * 				公认端口（0~1023）HTTP-80、FTP-21、Telnet-23
 * 				注册端口（1024~49151）Tomcat-8080、MySQL-3306、Oracle-1521
 * 				私人端口（49152~65535）
 * 			端口号与IP地址组合得到网络套接字 Socket
 * 		2.网络通信协议
 * 			OSI参考模型（应用层、表示层、会话层、传输层、网络层、数据链路层、物理层）	太过于理想化，无法实现
 * 			TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 * 				TCP/IP协议簇（传输层）：传输控制协议TCP（三次握手四次挥手）、用户数据报协议UDP
 * 
 * */

public class InetAddress_test {

	@Test
	public void testInetAddress() {
		try {
			//实例化InetAddress的方法：getByName("")\getLocalHost()
			InetAddress inet = InetAddress.getByName("192.168.1.101");	//用IP地址创建对象
			System.out.println(inet);
			InetAddress inet1 = InetAddress.getByName("127.0.0.1");
			System.out.println(inet1);
			InetAddress inet2 = InetAddress.getByName("www.baidu.com");	//用域名创建对象，需要
			System.out.println(inet2);
			InetAddress inet3 = InetAddress.getLocalHost();				//获取本机对象，等价于getByName("127.0.0.1")
			System.out.println(inet3);
			
			//常用方法
			System.out.println(inet.getHostName());			//获取本机的域名getHostName()
			System.out.println(inet.getHostAddress());		//获取本机IP地址getHostAddress()
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
