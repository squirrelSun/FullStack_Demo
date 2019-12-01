package team.service;

import team.domain.*;
import  static team.service.Data.*;

/*
 * ����Data�е����ݷ�װ��Employee[]�����У�ͬʱ�ṩ��ز���Employee[]�ķ���
 * 
 * */
public class NameListService {

	private Employee[] employees;
	
	//��Employee������Ԫ�س�ʼ��
	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0 ; i < employees.length ; i++) {
			//��ȡԱ������
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//��ȡEMPLOYEE���ĸ�������Ϣ 
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
	
	//ָ��λ���ϵ�Ա�����豸
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

	//��ȡ���е�Ա��
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	//��ȡָ��id��Ա������
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0 ; i < employees.length ; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("�Ҳ���ָ����Ա��");
	}
	
}
