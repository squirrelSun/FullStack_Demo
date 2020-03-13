package JAVA.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/*
 * NIO完成网络通信
 * 三要素
 * 	通道：负责连接服务端与客户端
 * 		SelectableChannel抽象类（SocketChannel、ServerSocketChannel、DatagramChannel）
 * 	缓冲区：负责数据的存取
 * 	选择器（selector）：SelectableChannel的多路选择器。用于监控SelectableChannel的IO状态
 * */

public class BlockingNIO_test {

	/*
	 * ---------------------------阻塞式NIO，服务器无返回数据----------------------------------
	 */
	// 客户端
	@Test
	public void client() throws Exception {
		// 获取通道
		SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		FileChannel inChannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg"),
				StandardOpenOption.READ);

		// 分配缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 读取本地文件并发送至服务端
		while (inChannel.read(buffer) != -1) {
			buffer.flip();
			channel.write(buffer);
			buffer.clear();
		}

		// 关闭通道
		inChannel.close();
		channel.close();

	}

	// 服务端
	@Test
	public void Server() throws Exception {
		// 获取通道
		ServerSocketChannel channel = ServerSocketChannel.open();

		FileChannel outChannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg04.jpg"),
				StandardOpenOption.WRITE);

		// 绑定端口号连接
		channel.bind(new InetSocketAddress(9898));

		// 获取客户端连接通道
		SocketChannel socketChannel = channel.accept();

		// 分配缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 接受客户端数据并保存至本地
		while (socketChannel.read(buffer) != -1) {
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}

		// 关闭通道
		socketChannel.close();
		outChannel.close();
		channel.close();
	}

	/*
	 * ---------------------------阻塞式NIO，服务器有返回数据----------------------------------
	 */
	// 客户端
	@Test
	public void client1() throws Exception {
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		FileChannel inChannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg.jpg"),
				StandardOpenOption.READ);

		ByteBuffer buf = ByteBuffer.allocate(1024);

		while (inChannel.read(buf) != -1) {
			buf.flip();
			sChannel.write(buf);
			buf.clear();
		}

		//手动切断发送数据
		sChannel.shutdownOutput();

		// 接收服务端的反馈
		int len = 0;
		while ((len = sChannel.read(buf)) != -1) {
			buf.flip();
			System.out.println(new String(buf.array(), 0, len));
			buf.clear();
		}

		inChannel.close();
		sChannel.close();
	}

	// 服务端
	@Test
	public void server1() throws Exception {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();

		FileChannel outChannel = FileChannel.open(
				Paths.get("E:\\Java\\WorkSpace\\eclipse\\FullStack\\src\\JAVA\\NIO\\image\\timg05.jpg"),
				StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		ssChannel.bind(new InetSocketAddress(9898));

		SocketChannel sChannel = ssChannel.accept();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		while (sChannel.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}

		// 发送反馈给客户端
		buf.put("服务端接收数据成功".getBytes());
		buf.flip();
		sChannel.write(buf);

		sChannel.close();
		outChannel.close();
		ssChannel.close();
	}

}
