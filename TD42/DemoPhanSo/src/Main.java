
public class Main {

	public static void main(String[] args) {

		PhanSo ps1 = new PhanSo(1, 2);
//		ps1.nhap();
		System.out.print("Phan so 1: ");
		ps1.xuat();

		PhanSo ps2 = new PhanSo(3, 4);
//		ps2.nhap();
		System.out.print("Phan so 2: ");
		ps2.xuat();

		// Tinh tong
		PhanSo tong = new PhanSo();
		tong = ps1.congPhanSo(ps2);
		System.out.print("Tong 2 phan so la: ");
		tong.xuat();

		// Tinh hieu
		PhanSo hieu = new PhanSo();
		hieu = ps1.truPhanSo(ps2);
		System.out.print("Hieu 2 phan so la: ");
		hieu.xuat();

		// Tinh tich
		PhanSo tich = new PhanSo();
		tich = ps1.tichPhanSo(ps2);
		System.out.print("Tich 2 phan so la: ");
		tich.xuat();

		// Tinh thuong
		PhanSo thuong = new PhanSo();
		thuong = ps1.thuongPhanSo(ps2);
		System.out.print("Thuong 2 phan so la: ");
		thuong.xuat();
	}
}
