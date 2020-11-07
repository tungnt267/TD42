import java.util.Scanner;

public class Bai5Menu {

	public static int soThuNhat;
	public static int soThuHai;

	public static void main(String[] args) {
		// Input
		int chon;
		float ketQua = 0;
		nhap();
		// Process
		// Output
		do {
			chon = inMenu();
			ketQua = xuLyChon(chon);
			xuatKetQua(chon, ketQua);
		} while (chon != 0);
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
		Scanner scan = new Scanner(System.in);
		System.out.print("\n---------------------------------");
		System.out.print("\nVui lòng chọn một chức năng:  ");
		System.out.print("\n1. Tinh Tổng ");
		System.out.print("\n2. Tinh Hiệu ");
		System.out.print("\n3. Tinh Tích ");
		System.out.print("\n4. Tinh Thương ");
		System.out.print("\n0. Kết thúc chương trình! ");
		System.out.print("\n---------------------------------");
		int chon = Integer.parseInt(scan.nextLine());
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

	public static void xuatKetQua(int chon, float ketQua) {
		if (chon != 0 && chon != 1 && chon != 2 && chon != 3 && chon != 4) {
			System.out.print("\nChức năng không hợp lệ! ");
		} else {
			if (chon == 0) {
				System.out.print("\nĐã thoát chương trình!");
			} else {
				System.out.print("\nKet qua: " + ketQua);
			}
		}
	}
}
