package JAVA.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

/*
 * 通道，用于源节点与目标节点的连接，在NIO中负责缓冲区中数据的传输
 * 本身并不会存储数据，配合缓冲区进行传输。通道之间也可以完成数据的传输
 * 
 * 主要实现类
 * 		用于本地数据传输：FileChannel（FileInputStream/FileOutputStream/RandomAccessFile）
 * 		用于网络数据传输：SocketChannel（Socket）、ServerSocketChannel（ServerSocket）、DatagramChannel（DatagramSocket）
 * 	获取通道（getChannel()方法/静态方法open()/Files工具类中newByteChannel()方法）
 * 
 * 分散Scatter与读取Gather
 * 	分散读取：将通道中的数据分散至多个缓冲区中（顺序写入缓冲区）
 * 	聚集写入：将多个换缓冲区中的数据聚集至一个通道中（依次读取缓冲区）
 * */

public class Channel_test {

	// 利用通道完成文件复制（非直接缓冲区）
	@Test
	public void test1() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inchannel = null;
		FileChannel outchannel = null;

		try {
			// 获取文件流
			fis = new FileInputStream(
					new File("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg"));
			fos = new FileOutputStream(
					new File("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg01.jpg"));
			// 获取通道
			inchannel = fis.getChannel();// 输入通道
			outchannel = fos.getChannel();// 输出通道
			// 分配指定大小缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			// 将输入通道中的数据存入缓冲区
			while (inchannel.read(buffer) != -1) {
				// 切换缓冲区类型为读数据操作
				buffer.flip();
				// 将缓冲区中的数据写入输出通道
				outchannel.write(buffer);
				// 清空缓冲区
				buffer.clear();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关闭通道资源
			try {
				if (outchannel != null)
					outchannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (inchannel != null)
					inchannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 利用通道完成文件复制（直接缓冲区，内存映射文件）
	@Test
	public void test2() throws Exception {
		// 获取输入通道
		FileChannel inchannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg"),
				StandardOpenOption.READ);
		FileChannel outchannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg02.jpg"),
				StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

		// 内存映射文件，存在于物理内存中（获取直接缓冲区）
		MappedByteBuffer inMapBuf = inchannel.map(MapMode.READ_ONLY, 0, inchannel.size());
		MappedByteBuffer outMapBuf = outchannel.map(MapMode.READ_WRITE, 0, inchannel.size());

		// 直接对缓冲区进行数据的读写操作
		byte[] dst = new byte[inMapBuf.limit()];
		inMapBuf.get(dst);
		outMapBuf.put(dst);

		// 关闭通道
		inchannel.close();
		outchannel.close();
	}

	// 通道直接的数据传输（直接缓冲区方式）
	@Test
	public void test3() throws Exception {
		FileChannel inchannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg"),
				StandardOpenOption.READ);
		FileChannel outchannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg03.jpg"),
				StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

//		inchannel.transferTo(0, inchannel.size(), outchannel);
		outchannel.transferFrom(inchannel, 0, inchannel.size());// 效果相同

		inchannel.close();
		outchannel.close();
	}

	// 分散读取与聚集写入，所有缓冲区大小均不够文件大小时，只能传送指定大小的文件，会造成文件数据丢失
	@Test
	public void test4() throws Exception {
		RandomAccessFile raf1 = new RandomAccessFile(
				"E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg", "rw");

		// 获取通道
		FileChannel channel1 = raf1.getChannel();

		// 分配缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(10);
		ByteBuffer buf2 = ByteBuffer.allocate(10);
		ByteBuffer buf3 = ByteBuffer.allocate(1024);

		// 分散读取
		ByteBuffer[] bufs = { buf1, buf2, buf3 };
		channel1.read(bufs);

		for (ByteBuffer b : bufs) {
			b.flip();
		}

		// 聚集写入
		RandomAccessFile raf2 = new RandomAccessFile(
				"E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg04.jpg", "rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(bufs);

		// 关闭通道
		channel2.close();
		channel1.close();
		raf2.close();
		raf1.close();
	}

	// 字符集
	@Test
	public void test5() {
		Map<String, Charset> map = Charset.availableCharsets();

		Set<Entry<String, Charset>> set = map.entrySet();

		for (Entry<String, Charset> entry : set) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	@Test
	public void test6() throws IOException {
		Charset cs1 = Charset.forName("GBK");

		// 获取编码器
		CharsetEncoder ce = cs1.newEncoder();

		// 获取解码器
		CharsetDecoder cd = cs1.newDecoder();

		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("是个三个人哥特人发");
		cBuf.flip();

		// 编码
		ByteBuffer bBuf = ce.encode(cBuf);

		for (int i = 0; i < 12; i++) {
			System.out.println(bBuf.get());
		}

		// 解码
		bBuf.flip();
		CharBuffer cBuf2 = cd.decode(bBuf);
		System.out.println(cBuf2.toString());

		System.out.println("------------------------------------------------------");

		Charset cs2 = Charset.forName("utf-16");
		bBuf.flip();
		CharBuffer cBuf3 = cs2.decode(bBuf);
		System.out.println(cBuf3.toString());
	}

}
