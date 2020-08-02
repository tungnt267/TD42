import java.util.Scanner;

public class TinhTong2So {

	public static void main(String[] args) {
		// Input
		int soThuNhat, soThuHai;
		soThuNhat = nhap();
		soThuHai = nhap();
		// Processing
		int tong = tinhTong(soThuNhat, soThuHai);
		int hieu = tinhHieu(soThuNhat, soThuHai);
		int tich = tinhTich(soThuNhat, soThuHai);
		float thuong = tinhThuong(soThuNhat, soThuHai);
		// Output
		xuat("Tổng là: ", tong);
		xuat("Hiệu là: ", hieu);
		xuat("Tích là: ", tich);
		xuat("Thương là: ", thuong);
	}
	public static int nhap() {
		int n = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số: ");
		n = Integer.parseInt(scan.nextLine());
		return n;
	}
	public static int tinhTong(int a, int b) {
		return a + b;
	}
	public static int tinhHieu(int a, int b) {
		return a - b;
	}
	public static int tinhTich(int a, int b) {
		return a * b;
	}
	public static float tinhThuong(int a, int b) {
		return (float) a / b;
	}
	public static void xuat(String thongBao, int ketQua) {
		System.out.println(thongBao + ketQua);
	}
	public static void xuat(String thongBao, float ketQua) {
		System.out.println(thongBao + ketQua);
	}
}
