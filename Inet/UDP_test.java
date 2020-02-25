package Inet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.junit.Test;

/*
 * UDP的网络编程
 * 
 * */

public class UDP_test {

	//发送端
	@Test
	public void send() throws IOException {
		
		DatagramSocket socket = new DatagramSocket();
		
		String str = "UDP";
		byte[] data = str.getBytes();
		
		InetAddress inet =InetAddress.getLoopbackAddress();
		DatagramPacket packet = new DatagramPacket(data , 0 , data.length , inet , 9090);
		
		socket.send(packet);
		
		socket.close();
	}
	
	//接收端
	@Test
	public void receiver() throws IOException {
		
		DatagramSocket socket = new DatagramSocket(9090);	//指定端口号
		
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer , 0 , buffer.length);
		
		socket.receive(packet);
		
		System.out.println(new String(packet.getData() , 0 , packet.getLength()));
		
		socket.close();
	}
	
}
