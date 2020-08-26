import java.util.Scanner;

/**
 * A bank account with an account number, account name and account balance
 */

/**
 * @author thanhtung
 * 
 *         Created date: 08/23/2020
 *
 */
public class BankAccount {
	// Constant
	private final double WITHDRAW_FEE = 1000;

	// 1. Attributes
	private String accountNumber;
	private String accountHolder;
	private double accountBalance;

	// 2. Constructor
	public BankAccount() {
	}

	public BankAccount(String accountNumber, String accountHolder, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}

	// 3. Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getWITHDRAW_FEE() {
		return WITHDRAW_FEE;
	}

	// 4. Input, Output
	public void scan() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the account number: ");
		this.accountNumber = scan.nextLine();
		System.out.print("Please enter the account holder: ");
		this.accountHolder = scan.nextLine();
		System.out.print("Please enter the account balance: ");
		this.accountBalance = Double.parseDouble(scan.nextLine());
	}

	public void print() {
		System.out.println("\nAcount Number: " + this.accountNumber);
		System.out.println("Acount Holer: " + this.accountHolder);
		System.out.println("Acount Balance: " + this.accountBalance + " VND");
	}

	// 5. Business methods
	// Cash in money to the bank account
	public double cashInMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nPlease enter the amount you want to deposit: ");
		double depositAmount;
		do {
			depositAmount = Double.parseDouble(scan.nextLine());
			if (depositAmount < 0) {
				System.out.print("Please enter the amount greater than 0: ");
			}
		} while (depositAmount < 0);
		this.accountBalance += depositAmount;
		return this.accountBalance;
	}

	// Cash out money from bank account
	public double cashOutMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nPlease enter the amount you want to withdraw: ");
		double withdrawAmount;
		do {
			withdrawAmount = Double.parseDouble(scan.nextLine());
			if (withdrawAmount < 0) {
				System.out.print("Please enter the amount greater than 0: ");
			}
			if (withdrawAmount > this.accountBalance - this.WITHDRAW_FEE) {
				System.out.print("The balance in the account is not enough! Please re-enter: ");
			}
		} while (withdrawAmount < 0 || withdrawAmount > this.accountBalance - this.WITHDRAW_FEE);
		this.accountBalance = this.accountBalance - withdrawAmount - this.WITHDRAW_FEE;
		return this.accountBalance;
	}
}
