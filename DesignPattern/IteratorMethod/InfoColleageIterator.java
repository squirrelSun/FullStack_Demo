package IteratorMethod;

import java.util.Iterator;
import java.util.List;

//具体的迭代器实现类
public class InfoColleageIterator implements Iterator<Department> {

	List<Department> departmentList; // 以List方式存放
	int index = -1;// 索引

	public InfoColleageIterator(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	// 判断是否还有下一个元素
	@Override
	public boolean hasNext() {
		if (index >= departmentList.size() - 1)
			return false;
		else {
			index += 1;
			return true;
		}
	}

	// 取出下一个元素
	@Override
	public Department next() {
		return departmentList.get(index);
	}

	// 删除，默认空实现
	public void remove() {

	}

}
