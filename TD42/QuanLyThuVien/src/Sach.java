import java.util.Scanner;

/**
 * Lớp đối tượng sách
 */

/**
 * @author thanhtung
 *
 */
public abstract class Sach {
	// 1. Thuộc tính
	protected String maSach;
	protected String ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;

	// 2. Khởi tạo
	public Sach() {
	}

	public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	// 3. Get, set
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập mã sách: ");
		this.maSach = scan.nextLine();
		System.out.print("Vui lòng nhập vào ngày nhập sách: ");
		this.ngayNhap = scan.nextLine();
		System.out.print("Vui lòng nhập vào đơn giá: ");
		this.donGia = Double.parseDouble(scan.nextLine());
		System.out.print("Vui lòng nhập vào số lượng: ");
		this.soLuong = Integer.parseInt(scan.nextLine());
		System.out.print("Vui lòng nhập vào tên nhà xuất bản: ");
		this.nhaXuatBan = scan.nextLine();

	}

	public void xuat() {
		System.out.print("\n\nMã sách: " + this.maSach);
		System.out.print("\nNgày nhập sách: " + this.ngayNhap);
		System.out.print("\nĐơn giá: " + this.donGia);
		System.out.print("\nSố lượng: " + this.soLuong);
		System.out.print("\nNhà xuất bản: " + this.nhaXuatBan);
	}

	// 5. Nghiệp vụ
	public abstract double tinhTienSach();
}
