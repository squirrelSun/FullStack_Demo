package JAVA.NIO;

import java.nio.ByteBuffer;

import org.junit.Test;

/*
 * 缓冲区Buffer，在nio中负责数据的存取。
 * 是一种容器，底层为数组，用于存储不同数据类型的数据（boolean除外），使用方式高度一致
 * 	ByteBuffer\CharBuffer\ShortBuffer\IntBuffer\LongBuffer\FloatBuffer\DoubleBuffer
 * 
 * 四大核心属性
 * 	capacity：缓冲区中最大存储数据的容量。一定声明，无法改变
 * 	limit：缓冲区中可以操作数据的大小
 * 	position：缓冲区中正在操作数据的位置
 * 	mark：记录当前position位置，可以通过reset()恢复到mark位置
 * 		0 <= mark <= position <= limit <= capacity
 * 
 * 直接缓冲区与非直接缓冲区
 * 	非直接缓冲区：通过allocate()分配缓冲区，将缓冲区建立在JVM内存中（堆空间）
 * 	直接缓冲区：通过allocateDir()方法分配直接缓冲区，将缓冲区建立在操作系统内存中
 * 			效率高，不安全，不易控制，资源消耗大
 */

public class Buffer_test {
	
	@Test
	public void test1() {
		//分配指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		//put()：存入数据至缓冲区		position滑动至即将操作数据的位置，limit和capacity均处于容器最大容量处
		String str = "asdasdad";
		buffer.put(str.getBytes());
		
		//flip()：从写数据切换至读数据模式		position滑动容器起点位置，limit滑动至目前容器已有数据的最大位置处，capacity不变
		buffer.flip();
		
		//get()：获取缓冲区的数据		position滑动至最大读取位置处,其余不变
		byte[] dst = new byte[buffer.limit()];		//最大读取至limit标记处
		buffer.get(dst);
		System.out.println(new String(dst , 0 , dst.length));
		
		//rewind()：可重复读数据		position滑动滑动容器起点位置,其余不变
		buffer.rewind();
		
		//clear()：清空缓冲器		position滑动滑动容器起点位置，limit和capacity均处于容器最大容量处
		buffer.clear();			//但是其中具体数据未被清空处于“被遗忘”状态，后续进行覆盖写
		System.out.println((char)buffer.get());
		
		System.out.println(buffer.position());		//获取当前操作位置
		System.out.println(buffer.limit());			//获取可操作容量
		System.out.println(buffer.capacity());		//获取缓冲区容量
	}
	
	@Test
	public void test2() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		String str = "asdasdad";
		buffer.put(str.getBytes());
		buffer.flip();
		byte[] dst = new byte[buffer.limit()];		
		buffer.get(dst , 0 , 2);
		System.out.println(new String(dst , 0 , 2));
		System.out.println(buffer.position());		//获取当前操作位置
		
		//mark()：标记操作位置
		buffer.mark();
		
		buffer.get(dst, 2, 2);
		System.out.println(new String(dst , 2 , 2));
		System.out.println(buffer.position());		//获取当前操作位置
		
		//reset()恢复至标记位置
		buffer.reset();
		System.out.println(buffer.position());		//获取当前操作位置
		
		if (buffer.hasRemaining()) {		//判断是否存在剩余可读数据
			System.out.println(buffer.remaining());			//获取剩余未读数据个数
		}
	}
	
	@Test
	public void test3() {
		//分配直接缓冲区
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		//判断是否为直接缓冲区
		System.out.println(buffer.isDirect());
	}
}
