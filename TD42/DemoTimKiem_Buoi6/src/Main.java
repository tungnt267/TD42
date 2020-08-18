import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static LinkedList<Integer> mang = new LinkedList<Integer>();

	public static void main(String[] args) {
		// Input
		nhap();
		// Process
		xuat();
//		LinkedList<Integer> dsKetQua = timViTriTuyenTinh();
		// Output
//		System.out.println("\nTong la: " + tinhTong());
//		System.out.print("\nCac vi tri phan tu can tim: " + dsKetQua);
		sapXepTangDan();
		sapXepGiamDan();
	}

	public static void nhap() {
		Scanner scan = new Scanner(System.in);
		String chon = null;
		int so;
		do {
			System.out.print("Nhap so: ");
			so = Integer.parseInt(scan.nextLine());
			mang.add(so);
			System.out.print("Ban co muon nhap tiep khong? nhan 'y' de tiep: ");
			chon = scan.nextLine();
		} while (chon.equalsIgnoreCase("y"));
	}

	// Xuat mang
	public static void xuat() {
		System.out.println("\nXuat mang: ");
		for (int i = 0; i < mang.size(); i++) {
			System.out.print(mang.get(i) + " ");
		}
		System.out.println();
	}

	// Tinh tong
	public static int tinhTong() {
		int tong = 0;
		for (int i = 0; i < mang.size(); i++) {
			tong += mang.get(i);
		}
		return tong;
	}

	// Tim tuyen tinh
	public static boolean timTuyenTinh() {
		boolean ketQua = false;
		// B1: Nhap phan tu can tim
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap vao phan tu can tim: ");
		int n = Integer.parseInt(scan.nextLine());
		// B2: Duyet tu dau den cuoi mang
		for (int i = 0; i < mang.size(); i++) {
			if (mang.get(i) == n) {
				ketQua = true;
				return ketQua;
			}
		}
		return ketQua;
	}

	// Tim vi tri so can tim, tim tuyen tinh
	public static LinkedList<Integer> timViTriTuyenTinh() {
		LinkedList<Integer> dsKetQua = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.print("\nNhap vao so can tim: ");
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < mang.size(); i++) {
			if (mang.get(i) == n) {
				dsKetQua.add(i);
			}
		}
		return dsKetQua;
	}

	// Sap xep tang dan
	public static void sapXepTangDan() {
		for (int i = 0; i < mang.size(); i++) {
			for (int j = i + 1; j < mang.size(); j++) {
				if (mang.get(i) > mang.get(j)) {
					int temp = mang.get(i);
					mang.set(i, mang.get(j));
					mang.set(j, temp);
				}
			}
		}
		System.out.print("\nMang da sap xep tang dan: " + mang);
		
	}
	
	// Sap xep giam dan
	public static void sapXepGiamDan() {
		for (int i = 0; i < mang.size(); i++) {
			for (int j = i + 1; j < mang.size(); j++) {
				if (mang.get(i) < mang.get(j)) {
					int temp = mang.get(i);
					mang.set(i, mang.get(j));
					mang.set(j, temp);
				}
			}
		}
		System.out.print("\nMang da sap xep giam dan: " + mang);
		
	}
}
