import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 * 
 *         Ngay tao: 22-08-2020
 */
public class PhanSo {

	// 1. Thuoc tinh - attributes
	private int tuSo;
	private int mauSo;

	// 2. Khoi tao - constructors
	public PhanSo() {

	}

	public PhanSo(int tuSo, int mauSo) {
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}
	// 3. get, set

	// 4. nhap, xuat - Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Nhap tu so: ");
		this.tuSo = Integer.parseInt(scan.nextLine());

		System.out.print("Nhap mau so: ");
		do {
			this.mauSo = Integer.parseInt(scan.nextLine());
			if (this.mauSo == 0) {
				System.out.print("Mau so phai khac 0! Vui long nhap lai: ");
			}
		} while (this.mauSo == 0);
	}

	public void xuat() {
		System.out.println(this.tuSo + "/" + this.mauSo);
	}

	// 5. nghiep vu - bussiness methods
	// Cong phan so
	public PhanSo congPhanSo(PhanSo ps2) {
		PhanSo tong = new PhanSo();
		tong.tuSo = this.tuSo * ps2.mauSo + ps2.tuSo * this.mauSo;
		tong.mauSo = this.mauSo * ps2.mauSo;
		return rutGonPS(tong);
	}

	// Tru phan so
	public PhanSo truPhanSo(PhanSo ps2) {
		PhanSo hieu = new PhanSo();
		hieu.tuSo = this.tuSo * ps2.mauSo - ps2.tuSo * this.mauSo;
		hieu.mauSo = this.mauSo * ps2.mauSo;
		return rutGonPS(hieu);
	}

	// Tich phan so
	public PhanSo tichPhanSo(PhanSo ps2) {
		PhanSo tich = new PhanSo();
		tich.tuSo = this.tuSo * ps2.tuSo;
		tich.mauSo = this.mauSo * ps2.mauSo;
		return rutGonPS(tich);
	}

	// Thuong phan so
	public PhanSo thuongPhanSo(PhanSo ps2) {
		PhanSo thuong = new PhanSo();
		thuong.tuSo = this.tuSo * ps2.mauSo;
		thuong.mauSo = this.mauSo * ps2.tuSo;
		return rutGonPS(thuong);
	}

	// Tim UCLN (gcd), BCNN(lcm = (a+b) / gcd)
	public int timUocChungLonNhat(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	// Rut gon
	public PhanSo rutGonPS(PhanSo ps) {
		PhanSo ketQua = new PhanSo();
		int gcd = timUocChungLonNhat(ps.tuSo, ps.mauSo);
		ketQua.tuSo = ps.tuSo / gcd;
		ketQua.mauSo = ps.mauSo / gcd;
		return ketQua;
	}
}
