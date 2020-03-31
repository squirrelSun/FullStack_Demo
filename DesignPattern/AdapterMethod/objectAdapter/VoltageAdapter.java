package AdapterMethod.objectAdapter;

//适配器类
public class VoltageAdapter implements IVoltage_5 {

	private Voltage_220 voltage_220;

	// 构造器，传入Voltage_220的实例对象
	public VoltageAdapter(Voltage_220 voltage_220) {
		super();
		this.voltage_220 = voltage_220;
	}

	@Override
	public int output5V() {

		int dst = 0;
		if (null != voltage_220) {
			int src = voltage_220.output220V();// 获取220V 电压
			System.out.println("使用对象适配器，进行适配");
			dst = src / 44;
			System.out.println("适配完成，输出的电压为=" + dst);
		}
		return dst;
	}

}
