import java.util.Scanner;

public class Main {

	public static int dong = 0;
	public static int cot = 0;
	public static int[][] maTran;

	public static void main(String[] args) {
		// Input
//		nhapMaTran();
		taoMaTranNgauNhien();
		// Process
		xuatMaTran();
		// Output
		System.out.println("\nTong la: " + tinhTong());
		System.out.println("Max la: " + timMax());
		System.out.println("min la: " + timMin());
		System.out.println("Tong duong cheo chinh: " + tinhTongDuongCheoChinh());
		System.out.println("Tong duong cheo phu: " + tinhTongDuongCheoPhu());
	}

	// Nhap mang hai chieu
	public static void nhapMaTran() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so dong: ");
		dong = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap so cot: ");
		cot = Integer.parseInt(scan.nextLine());
		maTran = new int[dong][cot];
		System.out.print("Nhap cac phan tu cua ma tran: ");
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				System.out.print("maTran[" + i + "][" + j + "] = ");
				maTran[i][j] = Integer.parseInt(scan.nextLine());
			}
		}
	}

	// Random number
	public static int randomNumber(int a, int b) {
		return a + (int) (Math.random() * ((b - a) + 1));
	}

	// Nhap mang hai chieu ngau nhien
	public static void taoMaTranNgauNhien() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so dong: ");
		dong = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap so cot: ");
		cot = Integer.parseInt(scan.nextLine());
		maTran = new int[dong][cot];
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				maTran[i][j] = randomNumber(1, 10);
			}
		}
	}

	// Xuat mang hai chieu
	public static void xuatMaTran() {
		System.out.println("\nXuat ma tran: ");
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				System.out.print(maTran[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// Tinh tong
	public static int tinhTong() {
		int tong = 0;
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				tong += maTran[i][j];
			}
		}
		return tong;
	}

	// Tim max
	public static int timMax() {
		int max = maTran[0][0];
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				if (maTran[i][j] > max) {
					max = maTran[i][j];
				}
			}
		}
		return max;
	}

	// Tim min
	public static int timMin() {
		int min = maTran[0][0];
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				if (maTran[i][j] < min) {
					min = maTran[i][j];
				}
			}
		}
		return min;
	}

	// Tong duong cheo chinh
	public static int tinhTongDuongCheoChinh() {
		int tongDuongCheoChinh = 0;
		for (int i = 0; i < dong; i++) {
			tongDuongCheoChinh += maTran[i][i];
		}
		return tongDuongCheoChinh;
	}

	// Tong duong cheo phu
	public static int tinhTongDuongCheoPhu() {
		int tongDuongCheoPhu = 0;
		for (int i = 0; i < dong; i++) {
			for (int j = 0; j < cot; j++) {
				if (i + j == dong - 1) {
					tongDuongCheoPhu += maTran[i][j];
				}
			}
		}
		return tongDuongCheoPhu;
	}
}
