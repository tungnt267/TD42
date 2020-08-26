import java.util.LinkedList;
import java.util.Scanner;

/**
 *  The list of accounts contains different bank accounts
 */

/**
 * @author thanhtung
 *
 *         Created Date: 24-08-2020
 *
 */
public class AccountList {
	// Constant
	private final double TRANSFER_FEE = 2200;

	// 1. Attributes
	private LinkedList<BankAccount> accList;

	// 2. Constructor
	public AccountList() {
		accList = new LinkedList<BankAccount>();
	}

	public AccountList(LinkedList<BankAccount> accList) {
		this.accList = accList;
	}

	// 3. Getters and Setters
	public LinkedList<BankAccount> getAccList() {
		return accList;
	}

	public void setAccList(LinkedList<BankAccount> accList) {
		this.accList = accList;
	}

	public double getTRANSFER_FEE() {
		return TRANSFER_FEE;
	}

	// 4. Input, Output
	public void scan(Scanner scan) {

	}

	public LinkedList<BankAccount> addData(BankAccount bankAcc) {
		this.accList.add(bankAcc);
		return accList;
	}

	public void print() {
		System.out.print("\n----------The list of acounts----------");
		for (BankAccount bankAcc : accList) {
			bankAcc.print();
		}
	}

	// 5. Business methods
	// Transfer money from the account bank to another
	public LinkedList<BankAccount> transferMoney(BankAccount sender, BankAccount receiver) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nPlease enter the amount you want to transfer from the account number "
				+ sender.getAccountNumber() + " to the " + receiver.getAccountNumber() + ": ");
		double transferAmount;

		do {
			transferAmount = Double.parseDouble(scan.nextLine());
			if (transferAmount < 0) {
				System.out.print("Please enter the amount greater than 0: ");
			}
			if (transferAmount > sender.getAccountBalance() - this.TRANSFER_FEE) {
				System.out.print("The balance in the account is not enough! Please re-enter: ");
			}
		} while (transferAmount < 0 || transferAmount > sender.getAccountBalance() - this.TRANSFER_FEE);

		sender.setAccountBalance(sender.getAccountBalance() - transferAmount - this.TRANSFER_FEE);
		receiver.setAccountBalance(receiver.getAccountBalance() + transferAmount);

		return this.accList;
	}
}
