package VisitorMethod;

import java.util.LinkedList;
import java.util.List;

//数据结构，管理具体访问者（Man , Woman）
public class ObjectStructure {

	// 维护集合，存放访问者
	private List<Person> persons = new LinkedList<>();

	// 增加
	public void attach(Person p) {
		persons.add(p);
	}

	// 移除
	public void detach(Person p) {
		persons.remove(p);
	}

	// 显示测评情况
	public void display(Action action) {
		for (Person p : persons) {
			p.accept(action);
		}
	}
}
