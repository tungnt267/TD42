import java.util.Scanner;

/**
 * Lớp đối tượng trưởng ph
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
	private final double LUONG_NGAY = 200;

	// 2. Khởi tạo
	public TruongPhong() {
		super();
		this.soNVDuoiQuyen = 0;
	}

	public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double luongThang,
			int soNVDuoiQuyen) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongThang);
		this.soNVDuoiQuyen = soNVDuoiQuyen;
	}

	// 3. get, set
	public int getSoNVDuoiQuyen() {
		return soNVDuoiQuyen;
	}

	public void setSoNVDuoiQuyen(int soNVDuoiQuyen) {
		this.soNVDuoiQuyen = soNVDuoiQuyen;
	}

	public double getLUONG_NGAY() {
		return LUONG_NGAY;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		super.nhap(chucVu);
		System.out.print("Vui lòng nhập vào số nhân viên dưới quyền: ");
		this.soNVDuoiQuyen = Integer.parseInt(scan.nextLine());
	}

	@Override
	public void xuat(int stt) {
		super.xuat(stt);
		System.out.print("Trưởng Phòng\t\t\t|");
		System.out.print(this.soNVDuoiQuyen + "\t|");
	}

	// 5. Nghiệp vụ
	@Override
	public double tinhLuong() {
		super.tinhLuong();
		this.luongThang = this.LUONG_NGAY * this.soNgayLamViec + 100 * this.soNVDuoiQuyen;
		return this.luongThang;
	}
}
