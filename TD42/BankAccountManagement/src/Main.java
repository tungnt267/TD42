public class Main {

	public static void main(String[] args) {

		BankAccount bankAcc = new BankAccount();
		bankAcc.scan();
		bankAcc.print();

		// Deposit Money
		bankAcc.cashInMoney();
		bankAcc.print();

		// Withdraw Money
		bankAcc.cashOutMoney();
		System.out.println("\nWithdraw fee: " + bankAcc.getWITHDRAW_FEE() + " VND");
		bankAcc.print();

		// Transfer money method
		// (Please remove comments below code to test! Thank you Mentor ^^ )

//		// Data initialization
//		AccountList accList = new AccountList();
//
//		BankAccount bankAcc1 = new BankAccount("0001", "Nguyen Van A", 5000000);
//		BankAccount bankAcc2 = new BankAccount("0002", "Nguyen Van B", 3000000);
//		BankAccount bankAcc3 = new BankAccount("0003", "Nguyen Van C", 8500000);
//
//		accList.addData(bankAcc1);
//		accList.addData(bankAcc2);
//		accList.addData(bankAcc3);
//
//		accList.print();
//
//		// Transfer Money
//		accList.transferMoney(bankAcc1, bankAcc2);
//		System.out.println("\nTransfer fee: " + accList.getTRANSFER_FEE() + " VND");
//		accList.print();

	}
}
