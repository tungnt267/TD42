import java.util.Scanner;

public class Bai2CapGiaTriGanNhauNhat {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		nhapMang();
		xuatMang();
		// Process
		// Output
		timCapSoGanNhauNhat();
	}

	// Nhap mang
	public static void nhapMang() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n < 2) {
				System.out.print("Vui long nhap vao do dai mang lon hon 2: ");
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

	// Khoang cach nho nhat giua 2 gia tri trong mang
	public static int timKhoangCachMin() {
		int khoangCachMin = Math.abs(mang[1] - mang[0]);
		for (int i = 1; i < mang.length; i++) {
			khoangCachMin = Math.min(khoangCachMin, Math.abs(mang[i] - mang[i - 1]));
		}
		return khoangCachMin;
	}

	// Tim cap gia tri gan nhau nhat
	public static void timCapSoGanNhauNhat() {
		int khoangCachMin = timKhoangCachMin();
		System.out.println("Cac cap gia tri gan nhau nhat la: ");
		for (int i = 1; i < n; i++) {
			if (Math.abs(mang[i] - mang[i - 1]) == khoangCachMin) {
				System.out
						.println(mang[i - 1] + "(vi tri i = " + (i - 1) + ") va " + mang[i] + "(vi tri i = " + i + ")");
			}
		}
	}

}
