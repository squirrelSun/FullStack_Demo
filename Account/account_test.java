package Account;

public class account_test {

	public static void main(String[] args) {
//		account acct=new account(1122, 20000, 0.045);
//		acct.withdraw(30000);
//		System.out.println("�����˻����Ϊ��"+acct.getBalance());
//		acct.withdraw(2500);
//		System.out.println("�����˻����Ϊ��"+acct.getBalance());
//		acct.deposit(3000);
//		System.out.println("�����˻����Ϊ��"+acct.getBalance());
//		System.out.println("������Ϊ��"+acct.getMonthlyInterest()*100+"%");
		
		checkAccount acct=new checkAccount(1122, 20000, 0.045,5000);
		acct.withdraw(5000);
		System.out.println("�����˻����Ϊ"+acct.getBalance()+"��͸֧���Ϊ"+acct.getOverdraft());
		acct.withdraw(18000);
		System.out.println("�����˻����Ϊ"+acct.getBalance()+"��͸֧���Ϊ"+acct.getOverdraft());
		acct.withdraw(3000);
		System.out.println("�����˻����Ϊ"+acct.getBalance()+"��͸֧���Ϊ"+acct.getOverdraft());
		
	}
	
}
