package BridgeMethod;

//具体实现类，继承 抽象类 Phone
public class UpRightPhone extends Phone {

	// 构造器
	public UpRightPhone(Brand brand) {
		super(brand);
	}

	public void open() {
		System.out.print(" 直立样式 ");
		super.open();
	}

	public void close() {
		System.out.print(" 直立样式 ");
		super.close();
	}

	public void call() {
		System.out.print(" 直立样式 ");
		super.call();
	}
}
