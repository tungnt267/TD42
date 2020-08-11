import java.util.Scanner;

public class DemoFor {

	public static void main(String[] args) {
		int n = nhap();
		in(n);
		System.out.print("\nTong: " + tinhTong(n));
		soLe(n);
		soChan(n);
		System.out.print("\nTong cac so chan: " + tinhTongSoChan(n));
		System.out.print("\nCo " + soChiaHetChoBa(n) + " chia het cho 3");
	}

	public static int nhap() {
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap so: ");
			n = Integer.parseInt(scan.nextLine());
		} while (n <= 0);
		return n;
	}

	public static void in(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	public static int tinhTong(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	public static void soLe(int n) {
		System.out.print("\nSo le: ");
		for (int i = 0; i <= n; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static void soChan(int n) {
		System.out.print("\nSo chan: ");
		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static int tinhTongSoChan(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0) {
				sum += i;
			} else {
				sum = sum;
			}
		}
		return sum;
	}

	public static int soChiaHetChoBa(int n) {
		int dem = 0;
		for (int i = 0; i <= n; i++) {
			if (i % 3 == 0) {
				dem++;
			}
		}
		return dem;
	}
}
