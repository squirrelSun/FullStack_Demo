package AdapterMethod.objectAdapter;

//被适配的类
public class Voltage_220 {
	// 输出220V的电压
	public int output220V() {
		int src = 220;
		System.out.println("电压=" + src + "V");
		return src;
	}
}
