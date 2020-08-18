import java.util.Scanner;

public class Bai3SoChanTrongDoan {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		taoMangNgauNhien();
		xuatMang();
		// Process
		// Output
		lietKeSoChanTrongDoan();
	}

	// Random number
	public static int randomNumber(int a, int b) {
		return a + (int) (Math.random() * ((b - a) + 1));
	}

	// Khoi tao mang ngau nhien
	public static void taoMangNgauNhien() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n % 2 != 0) {
				System.out.print("Vui long nhap vao n chan: ");
			}
		} while (n % 2 != 0);
		mang = new int[n];
		for (int i = 0; i < n; i++) {
			mang[i] = randomNumber(-100, 100);
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

	// Liet ke so chan trong doan [x, y]
	public static void lietKeSoChanTrongDoan() {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.print("\nNhap vao x: ");
		int x = Integer.parseInt(scan.nextLine());
		System.out.print("\nNhap vao y: ");
		int y = Integer.parseInt(scan.nextLine());
		System.out.print("\nCac so chan trong mang thuoc doan [" + x + ", " + y + "] la: ");
		for (int i = 0; i < n; i++) {
			if (mang[i] >= x && mang[i] <= y && mang[i] % 2 == 0) {
				System.out.print(mang[i] + " ");
				count++;
			}
		}
		if (count == 0) {
			System.out.print("\nKhong co so nao trong doan tren!");
		}
	}
}
