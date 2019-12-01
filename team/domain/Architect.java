package team.domain;

public class Architect extends Designer {

	private int stock;// ��Ʊ

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public String toString() {
		return getDetails() + "\t�ܹ�ʦ\t" + getStstus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDeatailsForTeam() {
		return getMemberId() + "/" + getDetails() + "\t�ܹ�ʦ\t" + getBonus() + "\t" + getStock();
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
