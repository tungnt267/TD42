import java.util.Scanner;

public class Bai15DichPhaiMang {

	public static int n = 0, k = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		// Process
		xuatMang();
		// Output
		dichPhaiK();
		System.out.print("\nMang sau khi da dich phai " + k + " lan: ");
		xuatMang();
	}

	// Random number
	public static int randomNumber(int a, int b) {
		return a + (int) (Math.random() * ((b - a) + 1));
	}

	// Khoi tao mang ngau nhien
	public static void taoMangNgauNhien() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		n = Integer.parseInt(scan.nextLine());
		mang = new int[n];
		for (int i = 0; i < n; i++) {
			mang[i] = randomNumber(-100, 100);
		}
	}

	// Xuat mang
	public static void xuatMang() {
		System.out.print("\nXuat mang: [ ");
		for (int phanTu : mang) {
			System.out.print(phanTu + " ");
		}
		System.out.print("]\n");
	}

	// Dich phai mang k lan
	public static int[] dichPhaiK() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nNhap vao so lan muon dich phai k = ");
		do {
			k = Integer.parseInt(scan.nextLine());
			if (k < 0) {
				System.out.print("Vui long nhap vao so k khong am: ");
			}
		} while (k < 0);
		int h = k;
		while (h > n) {
			h %= n;
		}
		for (int i = 0; i < h; i++) {
			for (int j = n - 1; j > 0; j--) {
				int temp = mang[j];
				mang[j] = mang[j - 1];
				mang[j - 1] = temp;
			}
		}
		return mang;
	}
}
