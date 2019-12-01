package team.junit;

import org.junit.Test;

import team.domain.Employee;
import team.service.NameListService;
import team.service.TeamException;

//≤‚ ‘¿‡
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
