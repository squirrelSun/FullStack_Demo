package JAVA.javas;

//接口
//实现类与对象匿名创建情况

public class UsbTest {
	
	public static void main(String[] args) {
		Computer com=new Computer();
		
		
		Flash flash=new Flash();
		com.transferData(flash);	//创建非匿名实现类的非匿名对象
		
		com.transferData(new Printer());	//创建非匿名实现类的匿名对象
		
		//匿名实现类
		Usb u=new Usb() {
			public void start() {
			}
			public void stop() {
			}
		};
		com.transferData(u);	//创建匿名实现类的非匿名对象
		
		com.transferData(new Usb() {	//创建匿名实现类的匿名对象
			public void start() {
			}
			public void stop() {
			}
		});
		
	}

}

class Computer{
	
	public void transferData(Usb usb) {
		usb.start();
		System.out.println("数据传输中");
		usb.stop();
	}
	
}

interface Usb{
	//常量：长、宽等
	
	//抽象方法
	void start();
	void stop();
}

class Flash implements Usb{

	public void start() {
		System.out.println("U盘开始工作");
	}

	public void stop() {
		System.out.println("U盘停止工作");
	}
	
}

class Printer implements Usb{

	public void start() {
		System.out.println("打印机开始工作");
	}

	public void stop() {
		System.out.println("打印机停止工作");
	}
	
}
