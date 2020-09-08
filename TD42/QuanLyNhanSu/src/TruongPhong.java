import java.util.Scanner;

/**
 * Lớp đối tượng trưởng phòng
 */

/**
 * @author thanhtung
 * 
 *         Ngày tạo: 28-08-2020
 *
 */
public class TruongPhong extends NhanSu {
	// 1. Thuộc tính
	private int soNVDuoiQuyen;
	private final float LUONG_MOT_NGAY = 200;
	private final float PHU_CAP = 100;

	// 2. Khởi tạo
	public TruongPhong() {
		super();
		this.soNVDuoiQuyen = 0;
		this.luongMotNgay = LUONG_MOT_NGAY;
	}

	public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
		this.soNVDuoiQuyen = 0;
		this.luongMotNgay = LUONG_MOT_NGAY;
	}

	// 3. get, set
	public int getSoNVDuoiQuyen() {
		return soNVDuoiQuyen;
	}

	public void setSoNVDuoiQuyen(int soNVDuoiQuyen) {
		this.soNVDuoiQuyen = soNVDuoiQuyen;
	}

	public float getLUONG_MOT_NGAY() {
		return LUONG_MOT_NGAY;
	}

	public float getPHU_CAP() {
		return PHU_CAP;
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
		System.out.print(String.format("%-13s", "Trưởng Phòng") + "|");
		System.out.print(String.format("%-14s", "") + "|");
		System.out.print(String.format("%-17s", this.soNVDuoiQuyen) + "|");
		System.out.print(String.format("%-15s", "") + "|");
		System.out.print(String.format("%-14s", this.tinhLuong()) + "|");
		System.out.print(String.format("%-14s", "") + "|");
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.luongMotNgay * this.soNgayLamViec + this.PHU_CAP * this.soNVDuoiQuyen;
	}
}
