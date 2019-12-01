package team.domain;

public class Designer extends Programmer {

	private double bonus;// ����

	public String toString() {
		return getDetails() + "\t���ʦ\t" + getStstus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDeatailsForTeam() {
		return getMemberId() + "/" + getDetails() + "\t���ʦ\t" + getBonus();
	}
	
	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
