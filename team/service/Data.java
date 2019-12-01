package team.service;

public class Data {

	public static final int EMPLOYEE = 10; 
	public static final int PROGRAMMER = 11;
	public static final int DESIGNER = 12;
	public static final int ARCHITECT = 13;

	public static final int PC = 21;
	public static final int NOTEBOOK = 22;
	public static final int PRINTER = 23;

//	EMPLOYEE	:10 , id , name , age , salary
//	PROGRAMMER	:11 , id , name , age , salary
//	DESIGNER	:12 , id , name , age , salary , bonus
//	ARCHITECT	:13 , id , name , age , salary , bonus, stock
	
	public static final String[][] EMPLOYEES = {
			{"10" , "1" , "a" , "22" , "3000"},
			{"13" , "2" , "b" , "32" , "18000" , "15000" , "2000"},
			{"11" , "3" , "c" , "23" , "7000"},
			{"11" , "4" , "d" , "24" , "7300"},
			{"12" , "5" , "e" , "28" , "10000" , "5000"},
			{"11" , "6" , "f" , "22" , "6800"},
			{"12" , "7" , "g" , "29" , "10800" , "5200"},
			{"13" , "8" , "h" , "27" , "19800" , "15000" , "2500"},
			{"12" , "9" , "i" , "30" , "9800" , "5500"},
			{"11" , "10" , "j" , "26" , "6600"},
			{"11" , "11" , "k" , "21" , "7100"},
			{"12" , "12" , "l" , "25" , "9600" , "4800"}
	};
	
	
//	PC			:21 , model , display
//	NOTEBOOK	:22 , model , price
//	PRINTER		:23 , name , type
	public static final String[][] EQUIPMENTS = {
			{},
			{"22" , "ÁªÏë" , "asdf"},
			{"21" , "´÷¶û" , "qwe"},
			{"21" , "´÷¶û" , "sdfg"},
			{"23" , "¼ÑÄÜ" , "sdgf"},
			{"21" , "»ªË¶" , "xzv"},
			{"21" , "»ªË¶" , "asd"},
			{"23" , "°®ÆÕÉú" , "gj"},
			{"22" , "»ÝÆÕ" , "vbn"},
			{"21" , "´÷¶û" , "dg"},
			{"21" , "»ªË¶" , "uyk"},
			{"22" , "»ÝÆÕ" , "tyutu"},
	};
	
	
}
