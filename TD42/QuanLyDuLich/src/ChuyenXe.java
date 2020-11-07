import java.util.Scanner;

public class ChuyenXe {

	protected int maSoChuyen;
	protected String hoTen;
	protected int soXe;
	protected float doanhThu;

	Scanner scan = new Scanner(System.in);

	public int getMaSoChuyen() {
		return maSoChuyen;
	}

	public void setMaSoChuyen(int maSoChuyen) {
		this.maSoChuyen = maSoChuyen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoXe() {
		return soXe;
	}

	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	public float getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(float doanhThu) {
		this.doanhThu = doanhThu;
	}

	public ChuyenXe() {
		this.maSoChuyen = -1;
		this.hoTen = "";
		this.soXe = -1;
		this.doanhThu = 0;
	}

	public ChuyenXe(int _maSoChuyen, String _hoTen, int _soXe, float _doanhThu) {
		this.maSoChuyen = _maSoChuyen;
		this.hoTen = _hoTen;
		this.soXe = _soXe;
		this.doanhThu = _doanhThu;
	}

	public void nhap() {
		System.out.println("Vui long nhap vao ma so chuyen: ");
		this.maSoChuyen = Integer.parseInt(scan.nextLine());

		System.out.println("Vui long nhap vao ho ten tai xe: ");
		this.hoTen = scan.nextLine();

		System.out.println("Vui long nhap vao so xe: ");
		this.soXe = Integer.parseInt(scan.nextLine());
	}

	public void xuat() {
		System.out.println(
				"Ma so chuyen xe: " + this.maSoChuyen + " ten tai xe: " + this.hoTen + " bien so xe: " + this.soXe);
	}

	public float tinhDoanhThu() {
		this.doanhThu = 0;
		return this.doanhThu;
	}

}
