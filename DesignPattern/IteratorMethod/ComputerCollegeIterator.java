package IteratorMethod;

import java.util.Iterator;

//具体的迭代器实现类
public class ComputerCollegeIterator implements Iterator<Department> {

	Department[] departments;// 以数组方式存放
	int position = 0; // 遍历的位置

	public ComputerCollegeIterator(Department[] departments) {
		this.departments = departments;
	}

	// 判断是否还有下一个元素
	@Override
	public boolean hasNext() {
		if (position >= departments.length || departments[position] == null)
			return false;
		else
			return true;
	}

	// 取出下一个元素
	@Override
	public Department next() {
		Department department = departments[position];
		position += 1;
		return department;
	}

	// 删除，默认空实现
	public void remove() {

	}

}
