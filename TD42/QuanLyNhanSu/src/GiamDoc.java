import java.util.Scanner;

/**
 * Lớp đối tượng giám đốc
 */

/**
 * @author thanhtung
 * 
 *         Ngày tạo: 28-08-2020
 *
 */
public class GiamDoc extends NhanSu {
	// 1. Thuộc tính
	private float soCoPhan;
	private final float LUONG_MOT_NGAY = 300;
	private float tongThuNhap;

	// 2. Khởi tạo
	public GiamDoc() {
		super();
		this.soCoPhan = 0;
		this.luongMotNgay = LUONG_MOT_NGAY;
		this.tongThuNhap = 0;
	}

	public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, float soCoPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
		this.soCoPhan = soCoPhan;
		this.luongMotNgay = LUONG_MOT_NGAY;
		this.tongThuNhap = 0;
	}

	// 3. get, set
	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

	public float getLUONG_MOT_NGAY() {
		return LUONG_MOT_NGAY;
	}

	public float getTongThuNhap() {
		return tongThuNhap;
	}

	public void setTongThuNhap(float tongThuNhap) {
		this.tongThuNhap = tongThuNhap;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		super.nhap(chucVu);
		System.out.print("Vui lòng nhập vào số cổ phần trong công ty (%): ");
		do {
			this.soCoPhan = Float.parseFloat(scan.nextLine());
			if (this.soCoPhan < 0 || this.soCoPhan > 100) {
				System.out.print("Vui lòng nhập cổ phần trong khoảng 1-100%: ");
			}
		} while (this.soCoPhan < 0 || this.soCoPhan > 100);
	}

	@Override
	public void xuat(int stt) {
		super.xuat(stt);
		System.out.print(String.format("%-13s", "Giám Đốc") + "|");
		System.out.print(String.format("%-14s", "") + "|");
		System.out.print(String.format("%-17s", "") + "|");
		System.out.print(String.format("%-15s", this.soCoPhan) + "|");
		System.out.print(String.format("%-14s", this.tinhLuong()) + "|");
		System.out.print(String.format("%-14s", this.tongThuNhap) + "|");
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.luongMotNgay * this.soNgayLamViec;
	}
}
