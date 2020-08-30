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
	private float coPhan;
	private final double LUONG_NGAY = 300;

	// 2. Khởi tạo
	public GiamDoc() {
		super();
		this.coPhan = 0;
	}

	public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double luongThang, float coPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongThang);
		this.coPhan = coPhan;
	}

	// 3. get, set
	public float getCoPhan() {
		return coPhan;
	}

	public void setCoPhan(float coPhan) {
		this.coPhan = coPhan;
	}

	public double getLUONG_NGAY() {
		return LUONG_NGAY;
	}

	// 4. Nhập, xuất
	@Override
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		super.nhap(chucVu);
		System.out.print("Vui lòng nhập vào số cổ phần trong công ty (%): ");
		do {
			this.coPhan = Float.parseFloat(scan.nextLine());
			if (this.coPhan < 0 || this.coPhan > 100) {
				System.out.print("Vui lòng nhập cổ phần trong khoảng 1-100%: ");
			}
		} while (this.coPhan < 0 || this.coPhan > 100);
	}

	@Override
	public void xuat(int stt) {
		super.xuat(stt);
		System.out.print("Giám Đốc\t\t\t\t\t|");
		System.out.print(this.coPhan + "\t|");
	}

	// 5. Nghiệp vụ
	@Override
	public double tinhLuong() {
		super.tinhLuong();
		this.luongThang = this.LUONG_NGAY * this.soNgayLamViec;
		return this.luongThang;
	}
}
