import java.util.Scanner;

public class Bai8AbsSoLienKe {

	public static int n = 0;
	public static float[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		xuatMang();
		// Process
		// Output
		System.out.println("Tong can tim la: " + tinhTong());
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

	// Tinh tong cac gia tri lon hon tri tuyet doi so lien sau
	public static float tinhTong() {
		float tong = 0;
		for (int i = 0; i < mang.length - 1; i++) {
			if (mang[i] > Math.abs(mang[i + 1])) {
				tong += mang[i];
			}
		}
		return tong;
	}

}
