/**
 * Tài khoản ngân hàng có số tài khoản, tên tài khoản, số tiền trong tài khoản
 */

/**
 * @author thanhtung
 *
 *         Ngay tạo: 23-08-2020
 */
public class TaiKhoan {
	// 1. Attributes
	private String accountNumber;
	private String accountHolder;
	private double currentBalance;

	// 2. Constructor
	public TaiKhoan() {

	}

	public TaiKhoan(String soTaiKhoan, String tenTaiKhoan, double soTien) {
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soTien = soTien;
	}

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

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	// 3. setters and getters

	// 4. Input, Output

	// 5. Business methods
}
