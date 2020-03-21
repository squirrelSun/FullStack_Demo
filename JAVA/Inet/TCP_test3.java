package JAVA.Inet;

import java.io.ByteArrayOutputStream;
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
 * 客户端发送文件给服务端，服务端将文件保存至本地，并返回“发送成功”给服务端
 * */


public class TCP_test3 {

	//客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		FileInputStream fis = null;
		ByteArrayOutputStream baos =null;
		
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\Inet\\image\\timg.jpg"));
			
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {	//从文件读数据
				os.write(buffer, 0, len);	//将读取的文件数据传输出去
			} 
			
			socket.shutdownOutput();		//通知接收端，数据发送完成
			
			//接受服务器端的数据，并显示到控制台上
			is = socket.getInputStream();
			baos = new ByteArrayOutputStream();
			while ((len = is.read(buffer)) != -1) {	//从文件读数据
				baos.write(buffer, 0, len);	//将读取的文件数据传输出去
			} 
			
			System.out.println(baos.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (baos != null)
					baos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		OutputStream os = null;
		FileOutputStream fos = null;
		
		try {
			
			ss = new ServerSocket(8899);
			socket = ss.accept();
			is = socket.getInputStream();
			fos = new FileOutputStream(
					new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\Inet\\image\\timg02.jpg"));
			
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			} 
			
			//服务器端给客户端反馈
			os = socket.getOutputStream();
			os.write("数据已接受".getBytes());
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(os != null)
					os.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ss != null)
					ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
