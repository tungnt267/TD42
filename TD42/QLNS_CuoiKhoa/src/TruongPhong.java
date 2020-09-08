
public class TruongPhong extends NhanSu {
	// 1. Thuộc tính
	private int soNhanVien;
	private final float LUONG_1_NGAY = 200;

	// 2. Khởi tạo
	public TruongPhong() {
		super();
		this.soNhanVien = 0;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgay) {
		super(maSo, hoTen, soDienThoai, soNgay);
		this.soNhanVien = 0;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	// 3. Get, set
	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	public float getLUONG_1_NGAY() {
		return LUONG_1_NGAY;
	}

	// 4. Nhập, xuất
	public void nhap() {

	}

	public void xuat() {
		super.xuat();
		System.out.print("\nSố nhân viên: " + this.soNhanVien);
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.soNgay * this.luong1Ngay + 100 * this.soNhanVien;
	}
}
