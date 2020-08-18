import java.util.Scanner;

public class Bai16XuatHienNhieuNhatItNhat {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
//		Input
		nhapMang();
//		Process
		xuatMang();
//		Output
		System.out.println("Phan tu xuat hien nhieu nhat dau tien trong mang la: " + timXuatHienNhieuNhat());
		System.out.println("Phan tu xuat hien it nhat dau tien trong mang la: " + timXuatHienItNhat());
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

	// So lan xuat hien cua mot phan tu
	public static int tinhSoLanXuatHien(int x) {
		int count = 0;
		for (int phanTu : mang) {
			if (phanTu == x) {
				count++;
			}
		}
		return count;
	}

	// Phan tu xuat hien nhieu nhat dau tien
	public static int timXuatHienNhieuNhat() {
		int maxCount = tinhSoLanXuatHien(mang[0]), vtMax = 0;
		for (int i = 0; i < n; i++) {
			if (maxCount < tinhSoLanXuatHien(mang[i])) {
				maxCount = tinhSoLanXuatHien(mang[i]);
				vtMax = i;
			}
		}
		return mang[vtMax];
	}

	// Phan tu xuat hien it nhat dau tien
	public static int timXuatHienItNhat() {
		int minCount = tinhSoLanXuatHien(mang[0]), vtMin = 0;
		for (int i = 0; i < n; i++) {
			if (minCount > tinhSoLanXuatHien(mang[i])) {
				minCount = tinhSoLanXuatHien(mang[i]);
				vtMin = i;
			}
		}
		return mang[vtMin];
	}
}
