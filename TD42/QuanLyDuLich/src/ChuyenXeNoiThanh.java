import java.util.Scanner;

public class ChuyenXeNoiThanh extends ChuyenXe {

	private int soTuyen;
	private int soKm;
	final int TIEN_KM = 100;

	Scanner scan = new Scanner(System.in);

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

	public ChuyenXeNoiThanh() {
		// TODO Auto-generated constructor stub
		super();
		this.soTuyen = -1;
		this.soKm = -1;
	}

	public ChuyenXeNoiThanh(int _maSoChuyen, String _hoTen, int _soXe, float _doanhThu, int _soTuyen, int _soKm) {
		// TODO Auto-generated constructor stub
		super(_maSoChuyen, _hoTen, _soXe, _doanhThu);
		this.soTuyen = _soTuyen;
		this.soKm = _soKm;
	}

	@Override
	public void nhap() {
		super.nhap();

		System.out.println("Vui long nhap vao so tuyen: ");
		this.soTuyen = Integer.parseInt(scan.nextLine());

		System.out.println("Vui long nhap vao so km: ");
		this.soKm = Integer.parseInt(scan.nextLine());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("So tuyen xe: " + this.soTuyen + " so km: " + this.soKm + " doanh thu: " + this.doanhThu);
	}

	@Override
	public float tinhDoanhThu() {
		this.doanhThu = this.soKm * TIEN_KM;
		return this.doanhThu;
	}

}
