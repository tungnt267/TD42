import java.util.Scanner;

public class Bai9TBCongSNT {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		xuatMang();
		// Process
		// Output
		tinhTrungBinhCongSNT();
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

	// Kiem tra so nguyen to
	public static boolean kiemTraSNT(int x) {
		if (x < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	// In cac so nguyen to
	public static void inSNT() {
		System.out.print("\nCac SNT trong mang la: ");
		for (int i = 0; i < n; i++) {
			if (kiemTraSNT(mang[i])) {
				System.out.print(mang[i] + " ");
			}
		}
	}

	// Trung binh cong cac gia tri lon hon x
	public static void tinhTrungBinhCongSNT() {
		int tong = 0, dem = 0;
		float trungBinhCongSNT = 0;
		for (int i = 0; i < mang.length; i++) {
			if (kiemTraSNT(mang[i])) {
				tong += mang[i];
				dem++;
			}
		}
		if (dem == 0) {
			System.out.println("\nMang khong co so nguyen to nao!");
		} else {
			inSNT();
			trungBinhCongSNT = (float) tong / dem;
			System.out.println("\nTrung binh cong cac so nguyen to trong mang la: " + trungBinhCongSNT);
		}
	}
}
