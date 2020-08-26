import java.util.Scanner;

public class Bai1LuyThua3 {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
//		Input
		nhapMang();
//		Process
		xuatMang();
//		Output
		System.out.print("\nCac gia tri trong mang co dang 3^k la: ");
		inSoLuyThuaCua3();
	}

	// Nhap mang
	public static void nhapMang() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		n = Integer.parseInt(scan.nextLine());
		mang = new int[n];
		System.out.println("Nhap cac phan tu cua mang: ");
		for (int i = 0; i < n; i++) {
			System.out.print("mang[" + i + "]: ");
			mang[i] = Integer.parseInt(scan.nextLine());
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

	// Kiem tra luy thua cua 3 (3^k)
	public static boolean kiemTraLuyThua3(int n) {
		if (n == 0) {
			return true;
		} else {
			while (n % 3 == 0) {
				n /= 3;
			}
			return n == 1;
		}
	}

	// In cac so luy thua cua 3
	public static void inSoLuyThuaCua3() {
		for (int i = 0; i < n; i++) {
			if (kiemTraLuyThua3(mang[i])) {
				System.out.print(mang[i] + " ");
			}
		}
	}

}
