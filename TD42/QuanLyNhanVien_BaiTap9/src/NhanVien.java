import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 29-08-2020
 */
public class NhanVien {
	// 1. Thuộc tính
	private String maNhanVien;
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private double heSoLuong;

	private final double LUONG_CO_BAN = 1000;

	// 2. Khởi tạo
	public NhanVien() {
		this.maNhanVien = null;
		this.hoTen = null;
		this.ngaySinh = null;
		this.diaChi = null;
		this.heSoLuong = 0;
	}

	public NhanVien(String maNhanVien, String hoTen, String ngaySinh, String diaChi, double heSoLuong) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
	}

	// 3. get, set
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getLUONG_CO_BAN() {
		return LUONG_CO_BAN;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập mã nhân viên: ");
		this.maNhanVien = scan.nextLine();
		System.out.print("Vui lòng nhập họ tên nhân viên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Vui lòng nhập ngày sinh của nhân viên: ");
		this.ngaySinh = scan.nextLine();
		System.out.print("Vui lòng nhập địa chỉ của nhân viên: ");
		this.diaChi = scan.nextLine();
		System.out.print("Vui lòng nhập hệ số lương: ");
		do {
			this.heSoLuong = Double.parseDouble(scan.nextLine());
			if (this.heSoLuong <= 0) {
				System.out.print("Hệ số lương phải lớn hơn 0! Vui lòng nhập lại: ");
			}
		} while (this.heSoLuong <= 0);
	}

	public void xuat() {
		System.out.print("\nMã nhân viên: " + this.maNhanVien);
		System.out.print("\nHọ tên: " + this.hoTen);
		System.out.print("\nNgày sinh: " + this.ngaySinh);
		System.out.println("\nĐịa chỉ: " + this.diaChi);
	}

	// 5. Nghiệp vụ
	public double tinhLuongNhanVien() {
		return this.heSoLuong * LUONG_CO_BAN;
	}
}
