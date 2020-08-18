import java.util.Scanner;

public class Main {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
//		nhapMang();
//		khoiTaoMang();
		// Process
		/*
		int sum = tinhTong();
		int sumChan = tinhTongChan();
		int sumViTriChan = tinhTongTaiViTriChan();
		int sumLe = tinhTongLe();
		int sumViTriLe = tinhTongTaiViTriLe();
		boolean ketQua = kiemTraMangToanDuong();
		int viTriAmDauTien = timViTriAmDauTien();
		int max = timMax();
		int min = timMin();
		int count = demSNT();
		// Output
		xuatMang();
		xuatMangForEach();

		System.out.println("\n\nTong cac phan tu cua mang: " + sum);
		System.out.println("Tong cac phan tu chan cua mang: " + sumChan);
		System.out.println("Tong cac phan tu tai vi tri chan cua mang: " + sumViTriChan);
		System.out.println("Tong cac phan tu le cua mang: " + sumLe);
		System.out.println("Tong cac phan tu tai vi tri le cua mang: " + sumViTriLe);
		if (ketQua) {
			System.out.println("\nMang toan duong!");
		} else {
			System.out.println("\nMang co so am!");
		}
		if (viTriAmDauTien == -1) {
			System.out.println("Mang khong co phan tu am!");
		} else {
			System.out.println("Vi tri so am dau tien cua mang la: i = " + viTriAmDauTien);
		}
		System.out.println("\nPhan tu lon nhat trong mang la: " + max);
		System.out.println("Phan tu nho nhat trong mang la: " + min);
		System.out.print("\nCac so chinh phuong: ");
		inCacSoChinhPhuong();
		System.out.print("\nCac so luy thua cua 3 la: ");
		inSoLuyThuaCua3();
		System.out.print("\nSo cac SNT trong mang la: " + count);
		*/
		tinhTongCacChuSo(123);
	}

	// Random number
	public static int randomNumber(int a, int b) {
		return a + (int) (Math.random() * ((b - a) + 1));
	}

	// Khoi tao mang ngau nhien
	public static void khoiTaoMang() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		n = Integer.parseInt(scan.nextLine());
		mang = new int[n];
		for (int i = 0; i < n; i++) {
			mang[i] = randomNumber(-100, 100);
		}
	}

	// Nhap mang
	public static void nhapMang() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap so phan tu cua mang: ");
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
		System.out.println("Xuat mang:");
		for (int i = 0; i < n; i++) {
			System.out.println("mang[" + i + "] = " + mang[i]);
		}
	}

	// Xuat mang for each
	public static void xuatMangForEach() {
		System.out.print("\nXuat mang for each: ");
		for (int phanTu : mang) {
			System.out.print(phanTu + " ");
		}
	}

	// Tong cac phan tu
	public static int tinhTong() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mang[i];
		}
		return sum;
	}

	// Tong cac phan tu chan
	public static int tinhTongChan() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (mang[i] % 2 == 0) {
				sum += mang[i];
			}
		}
		return sum;
	}

	// Tong cac phan tu tai vi tri chan
	public static int tinhTongTaiViTriChan() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				sum += mang[i];
			}
		}
		return sum;
	}

	// Tong cac phan tu le
	public static int tinhTongLe() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (mang[i] % 2 != 0) {
				sum += mang[i];
			}
		}
		return sum;
	}

	// Tong cac phan tu tai vi tri le
	public static int tinhTongTaiViTriLe() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 != 0) {
				sum += mang[i];
			}
		}
		return sum;
	}

	// Kiem tra mang toan so duong
	public static boolean kiemTraMangToanDuong() {
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] < 0) {
				return false;
			}
		}
		return true;
	}

	// Tim vi tri so am dau tien
	public static int timViTriAmDauTien() {
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] < 0) {
				return i;
			}
		}
		return -1;
	}

	// Tim phan tu lon nhat trong mang
	public static int timMax() {
		int max = mang[0];
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] > max) {
				max = mang[i];
			}
		}
		return max;
	}

	// Tim phan tu nho nhat trong mang
	public static int timMin() {
		int min = mang[0];
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] < min) {
				min = mang[i];
			}
		}
		return min;
	}

	// Kiem tra so chinh phuong
	public static boolean kiemTraSoChinhPhuong(int x) {
		int canNguyen = (int) Math.sqrt(x);
		if (Math.pow(canNguyen, 2) == x) {
			return true;
		}
		return false;
	}

	// In so chinh phuong
	public static void inCacSoChinhPhuong() {
		for (int i = 0; i < n; i++) {
			if (kiemTraSoChinhPhuong(mang[i])) {
				System.out.print(mang[i] + " ");
			}
		}
	}

	// Kiem tra so nguyen to
	public static boolean kiemTraSNT(int x) {
		int count = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0)
				count++;
			if (count > 2)
				return false;
		}
		if (count == 2)
			return true;
		return false;
	}

	// Dem so nguyen to
	public static int demSNT() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (kiemTraSNT(mang[i])) {
				count++;
			}
		}
		return count;
	}

	// Kiem tra luy thua cua 3 (3^k)
	public static boolean kiemTraLuyThua3(int n) {
		if (n == 1) {
			return false;
		} else {
			while (n % 3 == 0) {
				n /= 3;
			}
			return n == 1;
		}
	}

	// In cac so luy thua cua 3
	public static void inSoLuyThuaCua3() {
		for (int i = 0; i < n; i++) {
			if (kiemTraLuyThua3(mang[i])) {
				System.out.print(mang[i] + " ");
			}
		}
	}

	// Tinh tong cac chu so
	public static int tinhTongCacChuSo(int x) {
		int tong = 0, du = 0, nguyen;
		do {
			nguyen = x / 10;
			du = x % 10;
			tong = tong + du;
			x = nguyen;
		} while (nguyen != 0);
		return tong;
	}
}
