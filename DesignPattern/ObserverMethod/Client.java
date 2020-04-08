package ObserverMethod;

public class Client {

	public static void main(String[] args) {
		// 创建一个WeatherData
		WeatherData weatherData = new WeatherData();

		// 创建观察者
		CurrentConditions currentConditions = new CurrentConditions();
		BaiduSite baiduSite = new BaiduSite();

		// 注册到weatherData
		weatherData.registerObserver(currentConditions);
		weatherData.registerObserver(baiduSite);

		System.out.println("通知各个注册的观察者");
		weatherData.setData(10f, 100f, 30.3f);
		
		System.out.println("删除currentConditions观察者");
		weatherData.removeObserver(currentConditions);
		
		System.out.println("通知各个注册的观察者");
		weatherData.setData(10f, 100f, 30.3f);
	}

}
