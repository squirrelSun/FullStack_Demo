package AdapterMethod.classAdapter;

//适配器类
public class VoltageAdapter extends Voltage_220 implements IVoltage_5 {

	@Override
	public int output5V() {
		// TODO Auto-generated method stub

		int srcV = output220V(); // 获取到220V电压
		int dstV = srcV / 44; // 转成 5v
		return dstV;
	}

}
