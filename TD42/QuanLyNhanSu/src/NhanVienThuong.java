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
	private String maTruongPhongQuanLy;
	private final float LUONG_MOT_NGAY = 100;

	// 2. Khởi tạo
	public NhanVienThuong() {
		super();
		this.maTruongPhongQuanLy = null;
		this.luongMotNgay = LUONG_MOT_NGAY;
	}

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec,
			String maTruongPhongQuanLy) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
		this.maTruongPhongQuanLy = maTruongPhongQuanLy;
		this.luongMotNgay = LUONG_MOT_NGAY;
	}

	// 3. get, set
	public String getMaTruongPhongQuanLy() {
		return maTruongPhongQuanLy;
	}

	public void setMaTruongPhongQuanLy(String maTruongPhongQuanLy) {
		this.maTruongPhongQuanLy = maTruongPhongQuanLy;
	}

	public float getLUONG_MOT_NGAY() {
		return LUONG_MOT_NGAY;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		super.nhap(chucVu);
	}

	@Override
	public void xuat(int stt) {
		super.xuat(stt);
		System.out.print(String.format("%-13s", "Nhân viên") + "|");
		System.out.print(String.format("%-14s", this.maTruongPhongQuanLy) + "|");
		System.out.print(String.format("%-17s", "") + "|");
		System.out.print(String.format("%-11s", "") + "|");
		System.out.print(String.format("%-12s", this.tinhLuong()) + "|");
		System.out.print(String.format("%-14s", "") + "|");
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.luongMotNgay * this.soNgayLamViec;
	}
}
