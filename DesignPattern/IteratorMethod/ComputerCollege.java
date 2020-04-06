package IteratorMethod;

import java.util.Iterator;

//具体的聚合方式
public class ComputerCollege implements College {

	Department[] departments;// 数组方式存储
	int numOfDepartment = 0;// 保存当前数组的对象个数

	public ComputerCollege() {
		this.departments = new Department[5];
		addDepartment("Java", " Java专业 ");
		addDepartment("PHP", " PHP专业 ");
		addDepartment("大数据", " 大数据专业 ");

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "计算机学院";
	}

	@Override
	public void addDepartment(String name, String desc) {
		// TODO Auto-generated method stub
		Department department = new Department(name, desc);
		departments[numOfDepartment] = department;
		numOfDepartment += 1;
	}

	public Iterator<Department> createIterator() {
		// TODO Auto-generated method stub
		return new ComputerCollegeIterator(departments);
	}

}
