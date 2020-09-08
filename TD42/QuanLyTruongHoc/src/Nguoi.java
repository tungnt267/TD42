import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 *         05-09-2020
 */
public class Nguoi {
	// 1. Thuộc tính
	protected String hoTen;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;

	// 2. Khởi tạo
	public Nguoi() {
		this.hoTen = null;
		this.namSinh = 0;
		this.noiSinh = null;
		this.diaChi = null;
	}

	public Nguoi(String hoTen, int namSinh, String noiSinh, String diaChi) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	// 3. Get, set
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập họ tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Vui lòng nhập năm sinh: ");
		this.namSinh = Integer.parseInt(scan.nextLine());
		System.out.print("Vui lòng nhập nơi sinh: ");
		this.noiSinh = scan.nextLine();
		System.out.print("Vui lòng nhập địa chỉ: ");
		this.diaChi = scan.nextLine();
	}

	public void xuat() {
		System.out.println("\nHọ tên: " + this.hoTen);
		System.out.println("Năm sinh: " + this.namSinh);
		System.out.println("Nơi sinh: " + this.noiSinh);
		System.out.println("Địa chỉ: " + this.diaChi);
	}
	// 5. Nghiệp vụ

}
