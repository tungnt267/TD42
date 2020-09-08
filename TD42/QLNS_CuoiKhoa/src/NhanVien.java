
public class NhanVien extends NhanSu {

	// 1. Thuộc tính
	private String maTruongPhong;
	private final float LUONG_1_NGAY = 100;

	// 2. Khởi tạo
	public NhanVien() {
		super();
		this.maTruongPhong = null;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgay, String maTruongPhong) {
		super(maSo, hoTen, soDienThoai, soNgay);
		this.maTruongPhong = maTruongPhong;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	// 3. Get, set
	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}

	public float getLUONG_1_NGAY() {
		return LUONG_1_NGAY;
	}

	// 4. Nhập, xuất
	public void nhap() {

	}

	public String getMaTruongPhong() {
		return maTruongPhong;
	}

	public void xuat() {
		super.xuat();
		System.out.println("\nMã trưởng phòng: " + this.maTruongPhong);
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.soNgay * this.luong1Ngay;
	}
}
