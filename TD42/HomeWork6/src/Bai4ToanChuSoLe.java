import java.util.Scanner;

public class Bai4ToanChuSoLe {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		// Process
		xuatMang();
		// Output
		timSoToanChuSoLe();
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
			mang[i] = randomNumber(-1000, 1000);
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

	// Kiem tra so co toan chu so le
	public static boolean kiemTraToanChuSoLe(int x) {
		x = Math.abs(x);
		do {
			if (x % 2 == 0)
				return false;
			x /= 10;
		} while (x > 0);
		return true;
	}

	// Cac gia tri co toan chu so le trong mang
	public static void timSoToanChuSoLe() {
		int count = 0;
		System.out.print("\nCac gia tri co toan chu so le la: ");
		for (int i = 0; i < mang.length; i++) {
			if (kiemTraToanChuSoLe(mang[i])) {
				System.out.print(mang[i] + " ");
				count++;
			}
		}
		if (count == 0) {
			System.out.print("Khong co gia tri nao thoa man dieu kien!");
		}
	}
}
