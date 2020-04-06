package IteratorMethod;

import java.util.Iterator;

//统一的聚合接口
public interface College {

	public String getName();

	// 增加系的方法
	public void addDepartment(String name, String desc);

	// 返回一个迭代器
	public Iterator<Department> createIterator();
}
