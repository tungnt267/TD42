import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung Ngay tao: 23-08-2020
 *
 */
public class HocSinh {
	// 1. Thuoc tinh
	private String maHocSinh;
	private String hoTenHocSinh;
	private float diemToan;
	private float diemVan;

	// 2. Khoi tao
	public HocSinh() {

	}

	public HocSinh(String maHocSinh, String hoTenHocSinh, float diemToan, float diemVan) {
		this.maHocSinh = maHocSinh;
		this.hoTenHocSinh = hoTenHocSinh;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
	}

	// 3. get, set
	public String getMaHocSinh() {
		return maHocSinh;
	}

	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getHoTenHocSinh() {
		return hoTenHocSinh;
	}

	public void setHoTenHocSinh(String hoTenHocSinh) {
		this.hoTenHocSinh = hoTenHocSinh;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	// 4. nhap, xuat
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ma hoc sinh: ");
		this.maHocSinh = scan.nextLine();
		System.out.print("Nhap ho ten hoc sinh: ");
		this.hoTenHocSinh = scan.nextLine();

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
				System.out.print("Diem Toan phai trong khoang 0-10! Vui long nhap lai: ");
			}
		} while (this.diemVan > 10 || this.diemVan < 0);

	}

	public void xuat() {
		System.out.print("\nMa hoc sinh: " + this.maHocSinh);
		System.out.print("\nHo ten hoc sinh: " + this.hoTenHocSinh);
		System.out.print("\nDiem Toan: " + this.diemToan);
		System.out.print("\nDiem Van: " + this.diemVan + "\n");
	}

	// 5. nghiep vu
	public float tinhDiemTB() {
		return (this.diemToan + this.diemVan) / 2;
	}

	public String xepLoai() {
		if (this.tinhDiemTB() <= 10 && this.tinhDiemTB() >= 8.5)
			return "Gioi";
		if (this.tinhDiemTB() >= 6.5)
			return "Kha";
		if (this.tinhDiemTB() >= 5)
			return "Trung Binh";
		return "Yeu";
	}
}
