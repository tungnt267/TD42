import java.util.Scanner;

/**
 * Lớp đối tượng nhân viên thường
 */

/**
 * @author thanhtung
 * 
 *         Ngày tạo: 28-08-2020
 *
 */
public class NhanVienThuong extends NhanSu {
	// 1. Thuộc tính
	private String truongPhongQuanLy;
	private final double LUONG_NGAY = 100;

	// 2. Khởi tạo
	public NhanVienThuong() {
		super();
		this.truongPhongQuanLy = null;
	}

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double luongThang,
			String truongPhongQuanLy) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongThang);
		this.truongPhongQuanLy = truongPhongQuanLy;
	}

	// 3. get, set
	public String getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(String truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}

	public double getLUONG_NGAY() {
		return LUONG_NGAY;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		super.nhap(chucVu);
		System.out.print("Vui lòng nhập vào mã số trưởng phòng quản lý: ");
		this.truongPhongQuanLy = scan.nextLine();
	}

	@Override
	public void xuat(int stt) {
		super.xuat(stt);
		System.out.print("Nhân viên thường\t|");
		System.out.print(this.truongPhongQuanLy + "\t\t|\t\t");
	}

	// 5. Nghiệp vụ
	@Override
	public double tinhLuong() {
		super.tinhLuong();
		this.luongThang = this.LUONG_NGAY * this.soNgayLamViec;
		return this.luongThang;
	}
}
