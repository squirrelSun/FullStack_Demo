package ObserverMethod;

//信息推送接口
public interface Subject {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();

}