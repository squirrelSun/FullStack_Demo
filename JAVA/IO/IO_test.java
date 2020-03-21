package JAVA.IO;

import java.io.*;
import org.junit.Test;

/*
 * I/O流
 * 
 * 分类
		按数据单位分：字节流（8bit）、字符流（16bit）
		按流向分：输入流（输入内存）、输出流（输出内存）
		按角色分：节点流（处理数据）、处理流（处理节点流）
 * 	抽象基类:			字节流			字符流
 * 			输入流	InputStream		Reader
 * 			输出流	OutputStream	Writer
 * 		文件流（节点流）
 * 			FlieInputStream	(read(byte[] buffer))		FlieOutputStream	(writer(byte[] buffer , 0 , len))	
 * 			FlieReader	(read(char[] buffer))	FlieWriter	(writer(char[] buffer , 0 , len))
 * 		缓冲流（处理流的一种）
 * 			BufferedInputStream	(read(byte[] buffer))		BufferedOutputStream	(writer(byte[] buffer , 0 , len))	
 * 			BufferedReader	(read(char[] buffer) / readLine())	BufferedWriter	(writer(char[] buffer , 0 , len))
 * 	
 * 通过字符流处理文本文件(.txt\.java\.c\.cpp)，通过字节流处理非文本文件(图片\视频\.doc\.ppt)
 * 
 * 
 * */

public class IO_test {

	/*
	 * 文件流
	 */
	@Test // 将World.txt文件内容读入内存,并输出到控制台
	public void testFileReader1() {
		// 实例化对象，指明操作的文件
		File file1 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World.txt");
		// 提供具体的流
		FileReader file2 = null;
		try {
			// 对读入流初始化
			file2 = new FileReader(file1);
			// read();返回读入的一个字符，如果达到文件末尾，返回-1
			int data = file2.read(); // 数据的读入过程
			// 打印值，并循环读取字符
			while (data != -1) {
				System.out.print((char) data);
				data = file2.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 手动关闭流(为了流资源能保证关闭)
			try {
				if (file2 != null)
					file2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	// 对read()的重载方法
	public void testFileReader2() {
		// File类的实例化
		File file = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\IO\\JAVA\\World.txt");
		FileReader fr = null;
		try {
			// FileReader流的实例化
			fr = new FileReader(file);
			// 读入操作
			char[] cbuf = new char[2]; // 定义每次读取的数组长度
			int len;
			while ((len = fr.read(cbuf)) != -1) { // Read(char[] cbuf);返回每次读入到数组中的个数，达到文件末尾返回-1
				// 输出方式一
				for (int i = 0; i < len; i++) {
					System.out.print(cbuf[i]);
				}
				// 输出方式二
				String str = new String(cbuf, 0, len);
				System.out.print(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 资源流关闭
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test // 将内存中的数据，写出到硬盘的文件里，写出时文件不存在会自动创建此文件
	public void testFileWriter() throws IOException {
		// 提供File类的对象，指明操作的文件
		File file = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\Hello.txt");
		// 提供FileWriter的对象
		FileWriter fw = null;
		// 对写出流初始化
		fw = new FileWriter(file); // 在执行写入操作时，对原有文件进行覆盖写入
//		fw = new FileWriter(file,true);		//在执行写入操作时，追加在原文件后面（false：执行写入操作时，覆盖原文件写入）
		// 读入操作
		fw.write("Hello\n");
		fw.write("I have a dream");

		// 流资源关闭
		fw.close();
	}

	@Test // 对文件进行复制
	public void testFileReaderAndWriter() {
		// 创建File类的对象，指明读入和写出的文件
		File file1 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World.txt");// 读入文件
		File file2 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\Hello.txt");// 写出文件

		// 创建输入输出流对象
		FileReader fr = null;
		FileWriter fw = null;

		try {
			// 数据的读入和写出操作
			fr = new FileReader(file1);
			fw = new FileWriter(file2, true);
			char[] cbuf = new char[2];
			int len;
			while ((len = fr.read(cbuf)) != -1) {
				fw.write(cbuf, 0, len); // 每次写出len个字符
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				// 关闭流资源
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				try {
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test // 中文字符无法用字节传输
	public void testFileInoutOutputStream() {
		// 创建文件及流对象
		File file1 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg.jpg");
		File file2 = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg01.jpg");
		FileInputStream in = null;
		FileOutputStream out = null;

		// 读取数据
		try {
			in = new FileInputStream(file1);
			out = new FileOutputStream(file2);
			byte[] buf = new byte[5];
			int len;
			while ((len = in.read(buf)) != -1) {
				// 复制
				out.write(buf, 0, len);
			}
			System.out.println("复制完成");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关闭流资源
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				try {
					if (out != null)
						out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testCopyFile() {
		long start = System.currentTimeMillis();
		File in = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg.jpg");
		File out = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg02.jpg");
		copyFile(in, out);
		long end = System.currentTimeMillis();
		System.out.println("复制成功，用时：" + (end - start) + "ms");// 3ms
	}

	// 指定路径下的文件的复制
	public void copyFile(File file1, File file2) {
		FileInputStream in = null;
		FileOutputStream out = null;
		// 读取数据
		try {
			in = new FileInputStream(file1);
			out = new FileOutputStream(file2);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) != -1) {
				// 复制
				out.write(buf, 0, len);
			}
			System.out.println("复制完成");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关闭流资源
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				try {
					if (out != null)
						out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 缓冲流 提升读取和写入的速度（内部提供了一个缓冲区，默认值为8192，8kb）
	 */
	@Test
	public void testCopyBuffer1() {
		long start = System.currentTimeMillis();
		File in = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg.jpg");
		File out = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg03.jpg");
		copyBufferStream(in, out);
		long end = System.currentTimeMillis();
		System.out.println("复制成功，用时：" + (end - start) + "ms");// 1ms
	}

	// 指定路径下的非文本文件的复制
	public void copyBufferStream(File file1, File file2) {
		// 造缓冲流（处理流）
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		try {
			// 造节点流
			FileInputStream in = new FileInputStream(file1);
			FileOutputStream out = new FileOutputStream(file2);
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
			// 数据传输
			byte[] buffer = new byte[1024];
			int len;
			while ((len = bin.read(buffer)) != -1) {
				bout.write(buffer, 0, len);
			}
			bout.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关流资源（先关外层在关内层，在关外层的同时内层同时也就关闭，可以忽略）
			try {
				if (bout != null)
					bout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (bin != null)
				try {
					bin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Test
	public void testCopyBuffer2() {
		long start = System.currentTimeMillis();
		File in = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World.txt");
		File out = new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World1.txt");
		copyBufferStream(in, out);
		long end = System.currentTimeMillis();
		System.out.println("复制成功，用时：" + (end - start) + "ms");// 1ms
	}

	// 指定路径下的文本文件的复制
	public void copyBufferReaderWrite(File file1, File file2) {
		// 造缓冲流（处理流）
		BufferedReader bin = null;
		BufferedWriter bout = null;

		try {
			// 造节点流
			FileReader in = new FileReader(file1);
			FileWriter out = new FileWriter(file2);
			bin = new BufferedReader(in);
			bout = new BufferedWriter(out);
			// 数据传输
//				//方式一：char[]
//				char[] buffer = new char[1024];
//				int len;
//				while ((len = bin.read(buffer)) != -1) {
//					bout.write(buffer, 0, len);
//				} 
//				bout.flush();
			// 方式二:String
			String data;
			while ((data = bin.readLine()) != null) { // 读取整行的文本数据
				// 输出时不会自动换行
//					bout.write(data + "\n");	//手动添加
				bout.write(data);
				bout.newLine(); // 方法
			}
			bout.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关流资源（先关外层在关内层，在关外层的同时内层同时也就关闭，可以忽略）
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
//				out.close();
//				in.close();
		}

	}

	/*
	 * 转换流（处理流） 属于字符流 输入：字节输入流-->InputStreamReader-->字符输入流
	 * 输出：字符输出流-->OutputStreamWriter-->字节输出流 字符集 ASCII gbk UTF-8
	 */

	// 从字节的输入流到字符的输入流的转换，从字符的输出到字节的输出
	@Test
	public void testStreamReaderWriter() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World.txt");
		FileOutputStream fos = new FileOutputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World1.txt");

//		InputStreamReader isr = new InputStreamReader(fis);	//无第二个参数，表示使用系统默认的字符集
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);	//无第二个参数，表示使用系统默认的字符集
		OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");

		char[] cbuf = new char[2];
		int len;
		while ((len = isr.read(cbuf)) != -1) {
			osw.write(cbuf, 0, len);
		}

		isr.close();
		osw.close();
	}

	/*
	 * 对象流 用于传输Java的对象 序列化机制 将内存中的Java对象转换为二进制流，保存至硬盘或用网络传输至其他网络节点，同时可以还原为Java对象 序列化
	 * ObjectOutputStream 从内存持久化 反序列化 ObjectInpuyStream 读取到内存
	 * 
	 * 可序列化的对象要求 对象需要实现Serializable（常用）或Externalizable接口 定义序列版本号（全局常量，任意值） static
	 * final long serialVersionUID = ********; Long类型 对象内部的属性也必须是可序列化的（基本数据类型均可序列化）
	 * 
	 * 无法序列化对象内部的static和transient修饰的属性
	 * 
	 */
	@Test // 序列化 将内存中的Java对象持久化
	public void testObjectOutputStream() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\object.dat"));
			oos.writeObject(new String("asdasdasd"));
			oos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test // 反序列化 将对象持久化缓存至内存
	public void testObjectInputStream() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new FileInputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\object.dat"));
			Object obj = ois.readObject();
			String str = (String) obj;
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 随机（任意）存取文件流 RandomAccessFile 
	 * 	直接继承于Object，实现了DataInput和DataOutput接口
	 * 	既可以作为输入，也可以作为输出流 可以直接跳至文件的任意位置执行读、写操作
	 * 	如果作为输出流时，写出的文件不存在会直接创建，如果写出到的文件存在，会对文件进行覆盖（默认从头覆盖）
	 * 
	 * 通过相关操作实现插入效果 testAddFile()
	 */
	@Test
	public void testRandonAccessFile1() {
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		/*
		 * 第二个参数表示创建的模式 
		 * 		r:以只读方式打开 
		 * 		rw:打开以便读取和输入 
		 * 		rwd:打开以便读取和输入；同步文件同步文件内容的更新
		 * 		rws:打开以便读取和输入；同步文件同步文件内容和元数据的更新
		 */

		try {
			raf1 = new RandomAccessFile(new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg.jpg"),
					"r");
			raf2 = new RandomAccessFile(
					new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\image\\timg06.jpg"), "rw");
			byte[] buffer = new byte[1024];
			while ((raf1.read(buffer)) != -1) {
				raf2.write(buffer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (raf2 != null)
					raf2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (raf1 != null)
					raf1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testRandonAccessFile2() throws IOException {
		RandomAccessFile raf1 = new RandomAccessFile(
				new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World2.txt"), "rw");
		raf1.seek(2); // seek(index);将指针调到角标index的位置，默认为0
		raf1.write("asd".getBytes()); // 默认写出，从头覆盖文件
		raf1.close();
	}

	@Test
	// 使用RandonAccessFile，实现插入效果
	public void testAddFile() throws IOException {
		RandomAccessFile raf1 = new RandomAccessFile(
				new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World2.txt"), "rw");
		// 将指针调到要插入的位置角标
		raf1.seek(2);
		byte[] buffer = new byte[5];
		// 保存加入位置之后的所有数据
		StringBuilder builder = new StringBuilder(
				(int) new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World2.txt").length());
		int len;
		while ((len = raf1.read(buffer)) != -1) {
			builder.append(new String(buffer, 0, len));
		}
		// 将指针重新调回插入位置
		raf1.seek(2);
		// 写入要插入的数据
		raf1.write("qweqwe".getBytes());
		// 写入保存的后续数据
		raf1.write(builder.toString().getBytes());
		raf1.close();
	}

	/*
	 * 其他流 
	 * 	标准输入输出流
	 * 		System.in 			System.out 
	 * 	打印流 
	 * 		PrintStream 		PrintWriter 
	 * 	数据流
	 * 		DataInputStream 	DataOutputStream
	 */

	// 重新制定打印位置
	@Test
	public void testPoint() {
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream(
					new File("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\World.txt"));
			// 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
			ps = new PrintStream(fos, true);
			if (ps != null) {// 把标准输出流(控制台输出)改成文件
				System.setOut(ps);
			}
			for (int i = 0; i <= 255; i++) { // 输出ASCII字符
				System.out.print((char) i);
				if (i % 50 == 0) { // 每50个数据一行
					System.out.println(); // 换行
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// 对基本数据类型的变量或字符串进行持久化存储
	@Test // 写入数据
	public void testDataOutputStream() {
		DataOutputStream dos = null;
		try { // 创建连接到指定文件的数据输出流对象
			dos = new DataOutputStream(
					new FileOutputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\data.txt"));
			dos.writeUTF("我爱北京天安门"); // 写UTF字符串
			dos.writeBoolean(false); // 写入布尔值
			dos.writeLong(1234567890L); // 写入长整数
			System.out.println("写文件成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 关闭流对象
			try {
				if (dos != null) {
					// 关闭过滤流时,会自动关闭它包装的底层节点流
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test // 读取数据（顺序与写入顺序相同）
	public void testDataInputStream() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(
					new FileInputStream("E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JAVA\\IO\\data.txt"));
			String info = dis.readUTF();
			boolean flag = dis.readBoolean();
			long time = dis.readLong();
			System.out.println(info);
			System.out.println(flag);
			System.out.println(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
