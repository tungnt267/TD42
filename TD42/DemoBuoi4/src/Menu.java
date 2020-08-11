import java.util.Scanner;

public class Menu {

	public static int soThuNhat;
	public static int soThuHai;

	public static void main(String[] args) {
		
		int chon;
		float ketQua = 0;
		nhap();
		do {
			chon = inMenu();
			ketQua = xuLyChon(chon);
			System.out.println("Ket qua: " + ketQua);
		} while (chon != 0);
		// Process
		// Output
	}

	public static void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap so thu nhat: ");
		soThuNhat = Integer.parseInt(scan.nextLine());
		System.out.println("Nhap so thu hai: ");
		soThuHai = Integer.parseInt(scan.nextLine());
	}

	public static int tinhTong() {
		return soThuNhat + soThuHai;
	}

	public static int tinhHieu() {
		return soThuNhat - soThuHai;
	}

	public static int tinhTich() {
		return soThuNhat * soThuHai;
	}

	public static float tinhThuong() {
		return (float) soThuNhat / soThuHai;
	}

	public static int inMenu() {
		int chon;
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Vui long chon 1 so: ");
		System.out.println("1. Tinh Tong: ");
		System.out.println("2. Tinh Hieu: ");
		System.out.println("3. Tinh Tich: ");
		System.out.println("4. Tinh Thuong: ");
		System.out.println("0. Thoat ");
		System.out.println("-------------------------------------------------");
		chon = Integer.parseInt(scan.nextLine());
		return chon;
	}

	public static float xuLyChon(int chon) {
		float ketQua = 0;
		switch (chon) {
		case 1:
			ketQua = tinhTong();
			break;
		case 2:
			ketQua = tinhHieu();
			break;
		case 3:
			ketQua = tinhTich();
			break;
		case 4:
			ketQua = tinhThuong();
			break;
		}
		return ketQua;
	}
}