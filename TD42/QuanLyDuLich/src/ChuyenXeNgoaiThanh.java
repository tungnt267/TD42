import java.util.Scanner;

public class ChuyenXeNgoaiThanh extends ChuyenXe {

	private String noiDen;
	private int soNgayDiDuoc;
	final int TIEN_SO_NGAY = 500;

	Scanner scan = new Scanner(System.in);

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}

	public ChuyenXeNgoaiThanh() {
		// TODO Auto-generated constructor stub
		super();
		this.noiDen = "";
		this.soNgayDiDuoc = -1;
	}

	public ChuyenXeNgoaiThanh(int _maSoChuyen, String _hoTen, int _soXe, float _doanhThu, String _noiDen,
			int _soNgayDiDuoc) {
		// TODO Auto-generated constructor stub
		super(_maSoChuyen, _hoTen, _soXe, _doanhThu);
		this.noiDen = _noiDen;
		this.soNgayDiDuoc = _soNgayDiDuoc;
	}

	@Override
	public void nhap() {
		super.nhap();

		System.out.println("Vui long nhap vao noi den: ");
		this.noiDen = scan.nextLine();

		System.out.println("Vui long nhap vao so km: ");
		this.soNgayDiDuoc = Integer.parseInt(scan.nextLine());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println(
				"Noi den: " + this.noiDen + " so ngay di duoc: " + this.soNgayDiDuoc + " doanh thu: " + this.doanhThu);
	}

	@Override
	public float tinhDoanhThu() {
		this.doanhThu = this.soNgayDiDuoc * TIEN_SO_NGAY;
		return this.doanhThu;
	}

}
