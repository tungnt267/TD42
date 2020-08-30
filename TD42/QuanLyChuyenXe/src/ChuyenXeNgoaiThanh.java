import java.util.Scanner;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
	// 1. Thuộc tính
	private String noiDen;
	private int soNgay;

	// 2. Khởi tạo
	public ChuyenXeNgoaiThanh() {
		super();
		this.noiDen = null;
		this.soNgay = 0;
	}

	public ChuyenXeNgoaiThanh(String maChuyen, String hoTenTaiXe, String soXe, double doanhThu, String noiDen,
			int soNgay) {
		super(maChuyen, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgay = soNgay;
	}

	// 3. get, set
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	// 4. Nhập, xuất
	public void nhap() {
		super.nhap();
		Scanner scan = new Scanner(System.in);
		System.out.print("Nơi đến: ");
		this.noiDen = scan.nextLine();
		System.out.print("Số ngày: ");
		this.soNgay = Integer.parseInt(scan.nextLine());
	}

	public void xuat() {
		super.xuat();
		System.out.print("\nNơi đến: " + this.noiDen);
		System.out.print("\nSố ngày đi được: " + this.soNgay);
	}
	// 5. Nghiệp vụ

}
