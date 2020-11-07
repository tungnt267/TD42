import java.util.Scanner;

public class Bai17DaoNguocMang {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		// Process
		xuatMang();
		daoNguocMang();
		// Output
		System.out.print("\nMang sau khi dao nguoc: ");
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
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n < 2) {
				System.out.print("Vui long nhap vao do dai mang lon hon 2: ");
			}
		} while (n < 2);
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

	// Dao nguoc mang
	public static int[] daoNguocMang() {
		for (int i = 0; i < n / 2; i++) {
			int temp = mang[i];
			mang[i] = mang[n - i - 1];
			mang[n - i - 1] = temp;
		}
		return mang;
	}
}
