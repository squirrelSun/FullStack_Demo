package JAVA.Employee;

public class Salaried extends Employee{
	
	private double monthiySalary;

	public Salaried(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}

	public Salaried(String name, int number, MyDate birthday, double monthiySalary) {
		super(name, number, birthday);
		this.monthiySalary=monthiySalary;
	}
	
	public double earings() {
		return monthiySalary;
	}
	
	public double getMonthiySalary() {
		return monthiySalary;
	}

	public void setMonthiySalary(double monthiySalary) {
		this.monthiySalary = monthiySalary;
	}

	public String toString() {
		return "Salaried["+super.toString()+"]"; 
	}
	
}
