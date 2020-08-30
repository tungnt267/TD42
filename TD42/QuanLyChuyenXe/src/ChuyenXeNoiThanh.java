import java.util.Scanner;

public class ChuyenXeNoiThanh extends ChuyenXe {
	// 1. Thuộc tính
	private int soTuyen;
	private int soKm;

	// 2. Khởi tạo
	public ChuyenXeNoiThanh() {
		super();
		this.soTuyen = 0;
		this.soKm = 0;
	}

	public ChuyenXeNoiThanh(String maChuyen, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen, int soKm) {
		super(maChuyen, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	// 3. get, set
	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKm() {
		return soKm;
	}

	public void setSoKm(int soKm) {
		this.soKm = soKm;
	}

	// 4. Nhập, xuất
	public void nhap() {
		super.nhap();
		Scanner scan = new Scanner(System.in);
		System.out.print("Số tuyến: ");
		this.soTuyen = Integer.parseInt(scan.nextLine());
		System.out.print("Số km: ");
		this.soKm = Integer.parseInt(scan.nextLine());
	}

	public void xuat() {
		super.xuat();
		System.out.print("\nSố tuyến: " + this.soTuyen);
		System.out.print("\nSố Km: " + this.soKm);
	}
	// 5. Nghiệp vụ

}
