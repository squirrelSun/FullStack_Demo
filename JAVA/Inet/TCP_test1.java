package JAVA.Inet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;

/*
 * TCP的网络编程
 * 
 * 客户端发送数据给客户端，客户端将信息显示在控制台
 * */

public class TCP_test1 {

	//客户端
	@Test
	public void client() {
		//创建Socket和传输流对象
		Socket socket = null;
		OutputStream os = null;
		
		try {
			//指明IP和端口号
			InetAddress inet = InetAddress.getByName("127.0.0.1"); //服务端地址为127.0.0.1
			socket = new Socket(inet, 8899);	//端口号为6553
			
			//获取输出流，用于输出数据
			os = socket.getOutputStream();
			
			//传送数据
			os.write("你好，我是客户端".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//关闭资源
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (socket != null)
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//服务端
	@Test
	public void server() {
		//创建ServerSocket和传输流对象
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		
		try {
			//指明自己的端口号
			ss = new ServerSocket(8899);
			
			//调用accept()，表示可以接受来自客户端的socket
			socket = ss.accept();
			
			//获取输入流，从输入流读取数据
			is = socket.getInputStream();
			baos = new ByteArrayOutputStream();
			
			//数据接收
			byte[] buffer = new byte[5];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);			//写入ByteArrayOutputStream的缓冲区
			}
			
			//打印数据
			System.out.println(baos.toString());
			System.out.println("收到数据来自："+socket.getInetAddress().getHostAddress());
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//关闭资源
			try {
				if (baos != null)
					baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (ss != null)
					ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}



