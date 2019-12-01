package team.service;

import team.domain.*;
import  static team.service.Data.*;

/*
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * 
 * */
public class NameListService {

	private Employee[] employees;
	
	//给Employee及数组元素初始化
	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0 ; i < employees.length ; i++) {
			//获取员工类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取EMPLOYEE的四个基本信息 
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			switch (type) {
				case EMPLOYEE:
					employees[i] = new Employee(id , name , age , salary);
					break;
				case PROGRAMMER:
					equipment = createEquipment(i);
					employees[i] = new Programmer(id , name , age , salary , equipment);
					break;
				case DESIGNER:
					equipment = createEquipment(i);
					bonus = Double.parseDouble(EMPLOYEES[i][5]);
					employees[i] = new Designer(id , name , age , salary , equipment , bonus);
					break;
				case ARCHITECT:
					equipment = createEquipment(i);
					bonus = Double.parseDouble(EMPLOYEES[i][5]);
					stock = Integer.parseInt(EMPLOYEES[i][6]);
					employees[i] = new Architect(id , name , age , salary , equipment , bonus , stock);
					break;
			}
		}
	}
	
	//指定位置上的员工个设备
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		switch (key) {
			case Data.PC:
				return new PC(EQUIPMENTS[index][1] , EQUIPMENTS[index][2]);
			case Data.PRINTER:
				return new Printer(EQUIPMENTS[index][1] , EQUIPMENTS[index][2]);
			case Data.NOTEBOOK:
				return new NoteBook(EQUIPMENTS[index][1] , EQUIPMENTS[index][2]);
		}
		return null;
	}

	//获取所有的员工
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	//获取指定id的员工对象
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0 ; i < employees.length ; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
	
}
