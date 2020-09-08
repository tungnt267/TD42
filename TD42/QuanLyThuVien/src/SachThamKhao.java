import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class SachThamKhao extends Sach {

	// 1. Thuộc tính
	private double thue;

	// 2. Khởi tạo
	public SachThamKhao() {
		super();
		this.thue = 0;
	}

	public SachThamKhao(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	// 3. Get, set
	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		super.nhap();
		System.out.print("Vui lòng nhập vào thuế: ");
		this.thue = Double.parseDouble(scan.nextLine());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\nThuế: " + this.thue);
	}

	// 5. Nghiệp vụ
	@Override
	public double tinhTienSach() {
		return this.soLuong * this.donGia + this.thue;
	}
}
