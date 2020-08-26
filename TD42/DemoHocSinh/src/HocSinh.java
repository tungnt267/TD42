import java.util.Scanner;

/**
 * Lop hoc sinh co ho ten, diem toan, diem van
 */

/**
 * @author thanhtung Ngay tao: 22-08-2020
 */
public class HocSinh {
	// 1. Thuoc tinh - attributes
	private String hoTen;
	private float diemToan;
	private float diemVan;

	// 2. Khoi tao - constructors
	public HocSinh() {

	}

	public HocSinh(String hoTen, float diemToan, float diemVan) {
		this.hoTen = hoTen;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
	}
	// 3. get, set

	// 4. nhap, xuat - Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		this.hoTen = scan.nextLine();
		
		System.out.print("Nhap diem Toan: ");
		do {
			this.diemToan = Float.parseFloat(scan.nextLine());
			if (this.diemToan > 10 || this.diemToan < 0) {
				System.out.print("Diem Toan phai trong khoang 0-10! Vui long nhap lai: ");
			}
		} while (this.diemToan > 10 || this.diemToan < 0);
		
		System.out.print("Nhap diem Van: ");
		do {
			this.diemVan = Float.parseFloat(scan.nextLine());
			if (this.diemVan > 10 || this.diemVan < 0) {
				System.out.print("Diem Van phai trong khoang 0-10! Vui long nhap lai: ");
			}
		} while (this.diemVan > 10 || this.diemVan < 0);
	}

	public void xuat() {
		System.out.print("\nHo ten: " + this.hoTen);
		System.out.print("\nDiem Toan: " + this.diemToan);
		System.out.print("\nDiem Van: " + this.diemVan);
	}

	// 5. nghiep vu - bussiness methods
	public float tinhDiemTB() {
		return (this.diemToan + this.diemVan) / 2;
	}

	public String xepLoai() {
		if (this.tinhDiemTB() >= 8.5)
			return "Gioi";
		if (this.tinhDiemTB() >= 6.5)
			return "Kha";
		if (this.tinhDiemTB() >= 5)
			return "Trung Binh";
		return "Yeu";
	}
}
