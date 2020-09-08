import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class SachGiaoKhoa extends Sach {
	// 1. Thuộc tính
	private String trangThai; // true - mới, false - cũ

	// 2. Khởi tạo
	public SachGiaoKhoa() {
		super();
		this.trangThai = null;
	}

	public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			String trangThai) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.trangThai = trangThai;
	}

	// 3. Get, set
	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		super.nhap();
		System.out.print("Vui lòng nhập vào trạng thái sách: ");
		do {
			this.trangThai = scan.nextLine();
			if (!this.trangThai.equalsIgnoreCase("mới") && !this.trangThai.equalsIgnoreCase("cũ")) {
				System.out.print("Trạng thái không hợp lệ! Vui lòng nhập lại: ");
			}
		} while (!this.trangThai.equalsIgnoreCase("mới") && !this.trangThai.equalsIgnoreCase("cũ"));
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\nTrạng thái: " + this.trangThai);
	}

	// 5. Nghiệp vụ
	@Override
	public double tinhTienSach() {
		double thanhTien;
		if (this.trangThai.equalsIgnoreCase("mới")) {
			thanhTien = this.soLuong * this.donGia;
		} else {
			thanhTien = this.soLuong * this.donGia * 50 / 100;
		}
		return thanhTien;
	}
}
