import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class ChuyenXe {
	// 1. Thuộc tính
	protected String maChuyen;
	protected String hoTenTaiXe;
	protected String soXe;
	protected double doanhThu;

	// 2. Khởi tạo
	public ChuyenXe() {
	}

	public ChuyenXe(String maChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		this.maChuyen = maChuyen;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	// 3. get, set
	public String getMaChuyen() {
		return maChuyen;
	}

	public void setMaChuyen(String maChuyen) {
		this.maChuyen = maChuyen;
	}

	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}

	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	// 4. Nhập, xuất
	public void nhap() {

	}

	public void xuat() {
		System.out.print("Mã chuyến: " + this.maChuyen);
		System.out.print("\nHọ tên: " + this.hoTenTaiXe);
		System.out.print("\nSố xe: " + this.soXe);
		System.out.print("\nDoanh thu: " + this.doanhThu);
	}
	// 5. Nghiệp vụ
}
