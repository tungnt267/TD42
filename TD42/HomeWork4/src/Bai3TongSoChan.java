import java.util.Scanner;

public class Bai3TongSoChan {

	public static void main(String[] args) {
		// Input
		int tong;
		// Process
		tong = tinhTong();
		// Output
		xuatTong(tong);
	}

	public static int tinhTong() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số: ");
		int n = Integer.parseInt(scan.nextLine());

		int tong = 0;
		while (n != 0) {
			if (n % 2 == 0) {
				tong += n;
			}
			System.out.println("Nhập số: ");
			n = Integer.parseInt(scan.nextLine());
		}
		return tong;
	}

	public static void xuatTong(int tong) {
		System.out.println("Tổng là: " + tong);
	}

}
