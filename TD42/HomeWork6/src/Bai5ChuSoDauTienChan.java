import java.util.Scanner;

public class Bai5ChuSoDauTienChan {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		nhapMang();
		// Process
		xuatMang();
		// Output
		timDauTienChan();
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

	// Kiem tra so co chu so dau tien la chan
	public static boolean kiemTraChuSoDauTienChan(int x) {
		while (Math.abs(x) > 9) {
			x /= 10;
		}
		return x % 2 == 0;
	}

	// Cac gia tri co chu so dau tien la chan
	public static void timDauTienChan() {
		int count = 0;
		System.out.print("\nCac gia tri co chu so dau tien la chan: ");
		for (int i = 0; i < mang.length; i++) {
			if (kiemTraChuSoDauTienChan(mang[i])) {
				System.out.print(mang[i] + " ");
				count++;
			}
		}
		if (count == 0) {
			System.out.print("Khong co gia tri nao thoa man dieu kien!");
		}
	}

}
