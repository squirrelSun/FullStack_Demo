package java;

//�ӿ�
//ʵ��������������������

public class UsbTest {
	
	public static void main(String[] args) {
		Computer com=new Computer();
		
		
		Flash flash=new Flash();
		com.transferData(flash);	//����������ʵ����ķ���������
		
		com.transferData(new Printer());	//����������ʵ�������������
		
		//����ʵ����
		Usb u=new Usb() {
			public void start() {
			}
			public void stop() {
			}
		};
		com.transferData(u);	//��������ʵ����ķ���������
		
		com.transferData(new Usb() {	//��������ʵ�������������
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
		System.out.println("���ݴ�����");
		usb.stop();
	}
	
}

interface Usb{
	//�������������
	
	//���󷽷�
	void start();
	void stop();
}

class Flash implements Usb{

	public void start() {
		System.out.println("U�̿�ʼ����");
	}

	public void stop() {
		System.out.println("U��ֹͣ����");
	}
	
}

class Printer implements Usb{

	public void start() {
		System.out.println("��ӡ����ʼ����");
	}

	public void stop() {
		System.out.println("��ӡ��ֹͣ����");
	}
	
}
