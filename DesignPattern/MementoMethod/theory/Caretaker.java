package MementoMethod.theory;

import java.util.ArrayList;
import java.util.List;

//存储信息管理类
public class Caretaker {

	// 在List 集合中存放备忘录对象
	private List<Memento> mementoList = new ArrayList<>();

	public void add(Memento memento) {
		mementoList.add(memento);
	}

	// 获取第index个Originator 的 备忘录对象(保存状态)
	public Memento get(int index) {
		return mementoList.get(index);
	}
}
