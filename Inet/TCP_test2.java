package Inet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
 * 客户端发送文件给服务端，服务端将文件保存至本地
 * */

public class TCP_test2 {

	//客户端
	@Test
	public void client() {
		//获取Socket对象
		Socket socket = null;
		//获取输出流对象
		OutputStream os = null;
		//获取文件读入流对象
		FileInputStream fis = null;
		
		try {
			//对象实例化
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\Inet\\image\\timg.jpg"));
			
			//数据传输
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {	//从文件读数据
				os.write(buffer, 0, len);	//将读取的文件数据传输出去
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			//关闭流资源
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		FileOutputStream fos = null;
		
		try {
			
			ss = new ServerSocket(8899);
			socket = ss.accept();
			is = socket.getInputStream();
			fos = new FileOutputStream(
					new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\Inet\\image\\timg01.jpg"));
			
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
