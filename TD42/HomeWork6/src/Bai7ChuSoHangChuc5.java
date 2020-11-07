import java.util.Scanner;

public class Bai7ChuSoHangChuc5 {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		nhapMang();
		// Process
		xuatMang();
		// Output
		tinhTongChuc5();
	}

	// Nhap mang
	public static void nhapMang() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n < 2) {
				System.out.println("Vui long nhap vao do dai mang lon hon 2");
			}
		} while (n < 2);
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

	// Kiem tra so co chu so dau tien la chan
	public static boolean kiemTraSoHangChuc5(int x) {
		x = Math.abs(x);
		if (x < 10) {
			return false;
		} else {
			x /= 10;
			if (x % 5 == 0 && x % 10 != 0) {
				return true;
			}
		}
		return false;
	}

	// // Tinh tong cac so co chu so hang chuc la 5
	public static void tinhTongChuc5() {
		int count = 0, tongChuc5 = 0;
		System.out.print("\nCac gia tri co chu so hang chuc la 5: ");
		for (int i = 0; i < mang.length; i++) {
			if (kiemTraSoHangChuc5(mang[i])) {
				System.out.print(mang[i] + " ");
				tongChuc5 += mang[i];
				count++;
			}
		}
		if (count == 0) {
			System.out.print("Khong co gia tri nao thoa man dieu kien!");
		} else {
			System.out.println("\nTong cac so tren la: " + tongChuc5);
		}
	}
}
