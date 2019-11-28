package Account;

public class checkAccount extends account {

	private double overdraft;//͸֧�޶�
	
	public checkAccount(int id,double balance,double annualInterestRate,double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft=overdraft;
	}
	
	public void withdraw(double amount) {
		if (getBalance() >= amount) {
			super.withdraw(amount);
//			setBalance(getBalance() - amount);
		}else if (overdraft >= amount-getBalance()){
			overdraft-=(amount-getBalance());
			super.withdraw(super.getBalance());
		}else {
			System.out.println("������͸֧�޶�");
		}
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	
}
