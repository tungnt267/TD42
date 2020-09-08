import java.util.Scanner;

public class GiamDoc extends NhanSu {
	// 1. Thuộc tính
	private float soCoPhan;
	private final float LUONG_1_NGAY = 300;

	// 2. Khởi tạo
	public GiamDoc() {
		super();
		this.soCoPhan = 0;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgay, float soCoPhan) {
		super(maSo, hoTen, soDienThoai, soNgay);
		this.soCoPhan = soCoPhan;
		this.luong1Ngay = LUONG_1_NGAY;
	}

	// 3. Get, set
	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

	public float getLUONG_1_NGAY() {
		return LUONG_1_NGAY;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập số cổ phần: ");
		this.soCoPhan = Float.parseFloat(scan.nextLine());
	}

	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void xuat() {
		super.xuat();
		System.out.print("\nSố cổ phần: " + this.soCoPhan);
	}

	// 5. Nghiệp vụ
	@Override
	public float tinhLuong() {
		return this.soNgay * this.luong1Ngay;
	}
}
