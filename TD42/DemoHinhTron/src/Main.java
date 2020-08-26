
public class Main {

	public static void main(String[] args) {
		HinhTron ht = new HinhTron();
		ht.nhap();
		ht.xuat();
		
		float chuVi = ht.tinhChuVi();
		float dienTich = ht.tinhDienTich();
		
		System.out.print("\nChu vi la: " + chuVi);
		System.out.print("\nDien tich la: " + dienTich);
	}

}
