package ObserverMethod;

import java.util.ArrayList;

//包含最新的天气情况信息 
//含有 观察者集合，使用ArrayList管理 
//当数据有更新时，就主动的调用 ArrayList，通知所有的观察者看到最新的信息
public class WeatherData implements Subject {
	//天气信息
	private float temperatrue;
	private float pressure;
	private float humidity;
	// 观察者集合
	private ArrayList<Observer> observers;

	// 加入新的第三方
	public WeatherData() {
		observers = new ArrayList<>();
	}

	public float getTemperature() {
		return temperatrue;
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	// 调用 接入方的 update
	public void dataChange() {
		notifyObservers();
	}

	// 当数据有更新时，就调用 setData
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		// 将最新的信息 推送给 接入方 currentConditions
		dataChange();
	}

	// 注册一个观察者
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	// 移除一个观察者
	@Override
	public void removeObserver(Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

	// 遍历所有的观察者，并通知
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
		}
	}
}