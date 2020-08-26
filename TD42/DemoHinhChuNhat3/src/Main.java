
public class Main {

	public static void main(String[] args) {
		HinhChuNhat hcn = new HinhChuNhat(5, 3);
//		hcn.nhap();
		hcn.xuat();
		
		float chuVi = hcn.tinhChuVi();
		float dienTich = hcn.tinhDienTich();
		
		System.out.print("\nChu vi la: " + chuVi);
		System.out.print("\nDien tich la: " + dienTich);
	}
}
