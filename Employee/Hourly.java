package Employee;

public class Hourly extends Employee{
	
	private int wage;
	private int hour;

	public Hourly(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, number, birthday);
		this.wage=wage;
		this.hour=hour;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public double earings() {
		return wage*hour;
	}

	public String toString() {
		return "Hourly["+super.toString()+"]"; 
	}
	
}
