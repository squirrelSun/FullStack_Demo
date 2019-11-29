package Employee;

import java.util.Calendar;

public class PayrollSystem {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		int month=cal.get(Calendar.MONTH);
		
		Employee[] emps = new Employee[2];
		
		emps[0] = new Salaried("������" , 1002 , new MyDate(1999 , 2 , 25) , 10000);
		emps[1] = new Hourly("���г�" , 1003 , new MyDate(1997 , 3 , 28) , 60 , 240);
		
		for (int i=0 ; i<emps.length ; i++) {
			System.out.println(emps[i]);
			double salary=emps[i].earings();
			System.out.println("�¹���Ϊ��"+salary);
			if (month+1 == emps[i].getBirthday().getMonth()) {
				System.out.println("���տ��֣�����100Ԫ");
			}
		}

	}
	
}
