package JAVA.team.junit;

import org.junit.Test;

import JAVA.team.domain.Employee;
import JAVA.team.service.NameListService;
import JAVA.team.service.TeamException;

//测试类
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] Employees = service.getAllEmployees();
		for (int i = 0 ; i < Employees.length ; i++) {
			System.out.println(Employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 110;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
