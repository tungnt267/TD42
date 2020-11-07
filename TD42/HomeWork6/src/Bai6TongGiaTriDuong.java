import java.util.Scanner;

public class Bai6TongGiaTriDuong {

	public static int n = 0;
	public static float[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		xuatMang();
		// Process
		// Output
		System.out.println("Tong cac so duong trong mang la: " + tinhTongCacSoDuong());
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

	// Tinh tong cac gia tri duong
	public static float tinhTongCacSoDuong() {
		float tongDuong = 0;
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] > 0) {
				tongDuong += mang[i];
			}
		}
		return tongDuong;
	}
}
