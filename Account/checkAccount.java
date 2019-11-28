package Account;

public class checkAccount extends account {

	private double overdraft;//透支限额
	
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
			System.out.println("超过可透支限额");
		}
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	
}
