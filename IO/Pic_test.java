package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件的加密解密
 */

public class Pic_test {

	//加密
	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		File in = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\IO\\image\\timg.jpg");
		File out = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\IO\\image\\timg04.jpg");
		scretBufferStream(in , out);
		long end = System.currentTimeMillis();
		System.out.println("加密成功，用时：" + (end - start) + "ms");
	}
	
	//指定路径下的非文本文件的加密
	public void scretBufferStream(File file1 , File file2) {
		//造缓冲流（处理流）
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
		//造节点流
			FileInputStream in = new FileInputStream(file1);
			FileOutputStream out = new FileOutputStream(file2);
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
		//数据传输
			byte[] buffer = new byte[20];
			int len;
			while ((len = bin.read(buffer)) != -1) {
				
				//对字节数据进行修改，实现加密
				for (int i = 0 ; i < len ; i++) {
					buffer[i] = (byte) ( buffer[i] ^ 5 );
				}
				
				bout.write(buffer, 0, len);
			} 
			bout.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//关流资源
			try {
				if (bout != null) 
					bout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (bin != null)
					bin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	//解密
	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		File in = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\IO\\image\\timg04.jpg");
		File out = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\IO\\image\\timg05.jpg");
		scretBufferStream(in , out);
		long end = System.currentTimeMillis();
		System.out.println("加密成功，用时：" + (end - start) + "ms");
	}
	
	//指定路径下的非文本文件的加密
	public void unscretBufferStream(File file1 , File file2) {
		//造缓冲流（处理流）
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
		//造节点流
			FileInputStream in = new FileInputStream(file1);
			FileOutputStream out = new FileOutputStream(file2);
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
		//数据传输
			byte[] buffer = new byte[20];
			int len;
			while ((len = bin.read(buffer)) != -1) {
				
				//对字节数据进行修改，实现加密
				for (int i = 0 ; i < len ; i++) {
					buffer[i] = (byte) ( buffer[i] ^ 5 );
				}
				
				bout.write(buffer, 0, len);
			} 
			bout.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//关流资源
			try {
				if (bout != null) 
					bout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (bin != null)
					bin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
}
