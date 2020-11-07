import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bai18XuatHienNhuNhau {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
//		Input
		nhapMang();
//		Process
		xuatMang(mang);
//		ArrayList<Integer> ketQua = timXuatHienNhieuNhat();
//		Output
		System.out.print("\nCac phan tu co so lan xuat hien nhieu nhat (" + soLanXuatHienNhieuNhat() + " lan) la: "
				+ timXuatHienNhieuNhat());
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
	public static void xuatMang(int[] arr) {
		System.out.print("\nXuat mang: [ ");
		for (int phanTu : arr) {
			System.out.print(phanTu + " ");
		}
		System.out.print("]\n");
	}

	// Kiem tra mot phan tu co trong mang
	public static boolean kiemTraPhanTu(ArrayList<Integer> arr, int x) {
		for (int phanTu : arr) {
			if (x == phanTu)
				return true;
		}
		return false;
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

	// Tim so lan xuat hien nhieu nhat
	public static int soLanXuatHienNhieuNhat() {
		int maxCount = tinhSoLanXuatHien(mang[0]), vtMax = 0;
		for (int i = 0; i < n; i++) {
			if (maxCount < tinhSoLanXuatHien(mang[i])) {
				maxCount = tinhSoLanXuatHien(mang[i]);
				vtMax = i;
			}
		}
		return maxCount;
	}

	// In ra cac phan tu xuat hien nhieu nhat
	public static ArrayList<Integer> timXuatHienNhieuNhat() {

		int maxCount = soLanXuatHienNhieuNhat();

		ArrayList<Integer> ketQua = new ArrayList<Integer>();

		for (int phanTu : mang) {
			if (tinhSoLanXuatHien(phanTu) == maxCount && !kiemTraPhanTu(ketQua, phanTu)) {
				ketQua.add(phanTu);
			}
		}
		return ketQua;
	}
}
