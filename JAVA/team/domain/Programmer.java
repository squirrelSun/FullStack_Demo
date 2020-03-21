package JAVA.team.domain;

import JAVA.team.service.Status;

public class Programmer extends Employee {

	private int memberId;// 开发团队中的id
	private Status ststus = Status.FREE;
	private Equipment equipment;

	public String toString() {
		return getDetails() + "\t程序员\t" + ststus + "\t\t\t" + equipment.getDescription();
	}
	
	public String getDeatailsForTeam() {
		return memberId + "/" + getDetails() + "\t程序员";
	}
	
	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStstus() {
		return ststus;
	}

	public void setStstus(Status ststus) {
		this.ststus = ststus;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


}
