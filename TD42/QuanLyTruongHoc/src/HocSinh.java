import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class HocSinh extends Nguoi {
	// 1. Thuộc tính
	private float diemToan;
	private float diemVan;
	private float diemNgoaiNgu;

	// 2. Khởi tạo
	public HocSinh() {
		super();
		this.diemToan = 0;
		this.diemVan = 0;
		this.diemNgoaiNgu = 0;
	}

	public HocSinh(String hoTen, int namSinh, String noiSinh, String diaChi, float diemToan, float diemVan,
			float diemNgoaiNgu) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
	}

	// 3. Get, set
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

	public float getDiemNgoaiNgu() {
		return diemNgoaiNgu;
	}

	public void setDiemNgoaiNgu(float diemNgoaiNgu) {
		this.diemNgoaiNgu = diemNgoaiNgu;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		super.nhap();

		System.out.print("Vui lòng nhập điểm toán: ");
		do {
			this.diemToan = Float.parseFloat(scan.nextLine());
			if (this.diemToan < 0 || this.diemToan > 10) {
				System.out.print("Điểm phải trong khoảng 0-10. Vui lòng nhập lại: ");
			}
		} while (this.diemToan < 0 || this.diemToan > 10);

		System.out.print("Vui lòng nhập điểm văn: ");
		do {
			this.diemVan = Float.parseFloat(scan.nextLine());
			if (this.diemVan < 0 || this.diemVan > 10) {
				System.out.print("Điểm phải trong khoảng 0-10. Vui lòng nhập lại: ");
			}
		} while (this.diemVan < 0 || this.diemVan > 10);

		System.out.print("Vui lòng nhập điểm ngoại ngữ: ");
		do {
			this.diemNgoaiNgu = Float.parseFloat(scan.nextLine());
			if (this.diemNgoaiNgu < 0 || this.diemNgoaiNgu > 10) {
				System.out.print("Điểm phải trong khoảng 0-10. Vui lòng nhập lại: ");
			}
		} while (this.diemNgoaiNgu < 0 || this.diemNgoaiNgu > 10);
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Điểm toán: " + this.diemToan);
		System.out.println("Điểm văn: " + this.diemVan);
		System.out.println("Điểm ngoại ngữ: " + this.diemNgoaiNgu);
	}

	// 5. Nghiệp vụ
	public float tinhDiemTB() {
		return (this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3;
	}

	public String xepLoai() {
		if (this.tinhDiemTB() <= 10 && this.tinhDiemTB() > 9)
			return "Xuất Sắc";
		if (this.tinhDiemTB() >= 8)
			return "Giỏi";
		if (this.tinhDiemTB() >= 7)
			return "Khá";
		if (this.tinhDiemTB() >= 5)
			return "Trung Bình";
		return "Yếu";
	}
}
