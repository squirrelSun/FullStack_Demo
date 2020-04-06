package IteratorMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//具体的聚合方式
public class InfoCollege implements College {

	List<Department> departmentList;// List方式存储

	public InfoCollege() {
		departmentList = new ArrayList<Department>();
		addDepartment("信息安全", " 信息安全专业 ");
		addDepartment("网络安全", " 网络安全专业 ");
		addDepartment("服务器安全", " 服务器安全专业 ");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "信息工程学院";
	}

	@Override
	public void addDepartment(String name, String desc) {
		// TODO Auto-generated method stub
		Department department = new Department(name, desc);
		departmentList.add(department);
	}

	public Iterator<Department> createIterator() {
		// TODO Auto-generated method stub
		return new InfoColleageIterator(departmentList);
	}

}
