package JAVA.IO;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/*
 * File类的使用
 * 
 * 1.File类的一个对象代表一个文件或一个文件目录
 * 2.路径分隔符，静态常量File.separator
 * 		windows及DAS中为\;UNIX和URL中为/
 	相对路径
 		相对于存在当前项目路径下
	绝对路径
		带盘符的绝对路径
 * 3.File类中存在对文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
		不存在写入或读取文件内部的操作
 * 4.File类对象常作为参数传入流的构造器中
 * */

public class File_test {

	//创建实例对象
	@Test
	public void test1() {
		//String filePath
		File file1 = new File("Hellow.txt");//相对路径
		File file2 = new File("E:\\Java\\Hellow.txt");//绝对路径
		System.out.println(file1);
		System.out.println(file2);
		
		//String partentPath,String childPath
		File file3 = new File("E:","Java");
		System.out.println(file3);
		
		//File partentPath,String filePath
		File file4 = new File(file3,"world.txt");
		System.out.println(file4);
		
	}
	
	//常用方法
	@Test//获取相关
	public void test2() {
		File file1 = new File("Hello.txt");//相对路径
		File file2 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\JAVA\\src\\IO\\World.txt");//绝对路径
		
		//获取文件信息
		System.out.println(file1.getAbsolutePath());	//获取绝对路径
		System.out.println(file1.getPath());	//获取相对路径
		System.out.println(file1.getName());	//获取文件名字
		System.out.println(file1.getParent());	//获取上一层路径，相对路径定义的对象无定法获取
		System.out.println(file1.length());		//获取文件长度
		System.out.println(file1.lastModified());	//获取最后一次修改时间
		
		System.out.println();
		
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getPath());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.length());
		System.out.println(file2.lastModified());
		
		System.out.println("-----------------------");
		//适用于文件目录
		File file3 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA");
		String[] list1 = file3.list();		//获取下一层文件或文件夹所组成的String数组，存储的是名字
		File[] list2 = file3.listFiles();	//获取下一层文件或文件夹所组成的File数组，存储的是绝对路径
		
		for (String s : list1) {
			System.out.println(s);
		}
		System.out.println();
		for (File s : list2) {
			System.out.println(s);
		}
	}
	@Test//判断相关
	public void test3() {
		File file1 = new File("src\\JAVA\\IO\\World.txt");
		File file2 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO");
		
		//判断文件信息
		System.out.println(file1.isDirectory());	//是否为文件目录
		System.out.println(file1.isFile());			//是否为一个文件
		System.out.println(file1.exists());			//是否在硬盘中存在
		System.out.println(file1.canRead());		//是否可以读
		System.out.println(file1.canWrite());		//是否可以写
		System.out.println(file1.isHidden());		//是否隐藏
		
		System.out.println();
		
		//判断文件夹信息
		System.out.println(file2.isDirectory());	
		System.out.println(file2.isFile());			
		System.out.println(file2.exists());			
		System.out.println(file2.canRead());		
		System.out.println(file2.canWrite());		
		System.out.println(file2.isHidden());		
	}
	@Test//创建及删除相关
	public void test4() {
		//文件相关
		File file1 = new File("src\\JAVA\\IO\\Hello.txt");
		
		if (!file1.exists()) {
			try {
				file1.createNewFile();					//创建文件
				System.out.println("创建成功1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			file1.delete();								//删除文件
			System.out.println("删除成功1");
		}
		
		System.out.println("-----------");

		
		//文件目录相关
		File file2 = new File("src\\IO\\JAVA\\IOTest\\test2");
		File file3 = new File("src\\IO\\JAVA\\IOTest\\test3");
		
		boolean mkdir = file2.mkdir();				//创建文件目录，如果上层目录不存在，创建失败
		if (mkdir) {
			System.out.println("创建成功2");
		}else {
			System.out.println(file2.delete());		//删除文件目录，删除文件目录时，该文件目录下不能存在子目录或文件
		}		
		boolean mkdirs = file3.mkdirs();			//创建文件目录，如果上层目录不存在，一并创建上层目录
		if (mkdirs) {
			System.out.println("创建成功3");
		}else {
			System.out.println(file3.delete());	//删除文件目录
		}
	}
}





