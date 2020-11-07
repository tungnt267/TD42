import java.util.Scanner;

public class Bai10TBCongX {

	public static int n = 0;
	public static float[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		xuatMang();
		// Process
		// Output
		tinhTrungBinhCongX();
	}

	// Random number
	public static float randomNumber(float a, float b) {
		return a + (float) (Math.random() * ((b - a) + 1));
	}

	// Khoi tao mang ngau nhien
	public static void taoMangNgauNhien() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		n = Integer.parseInt(scan.nextLine());
		mang = new float[n];
		for (int i = 0; i < n; i++) {
			mang[i] = randomNumber(-1000, 1000);
		}
	}

	// Xuat mang
	public static void xuatMang() {
		System.out.print("\nXuat mang: [ ");
		for (float phanTu : mang) {
			System.out.print(phanTu + " ");
		}
		System.out.print("]\n");
	}

	// Trung binh cong cac gia tri lon hon x
	public static void tinhTrungBinhCongX() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap x: ");
		float x = Float.parseFloat(scan.nextLine());
		float tong = 0;
		int dem = 0;
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] > x) {
				tong += mang[i];
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("Mang khong co gia tri nao lon hon " + x);
		} else {
			System.out.println("Trung binh cong cac so lon hon " + x + " la: " + tong / dem);
		}
	}

}
