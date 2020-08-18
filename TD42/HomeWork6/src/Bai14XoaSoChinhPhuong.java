public class Bai14XoaSoChinhPhuong {

	public static int[] mang = { 1, 4, 5, 7, 9, -9, 0, 10, 27, 25, 2, 4, 15 };

	public static void main(String[] args) {
		// Input
		xuatMang(mang);
		// Process
		int[] ketQua = xoaChinhPhuong();
		// Output
		System.out.print("\nMang sau khi da xoa cac so chinh phuong: ");
		xuatMang(ketQua);
	}

	// Xuat mang
	public static void xuatMang(int[] arr) {
		System.out.print("\nXuat mang: ");
		for (int phanTu : arr) {
			System.out.print(String.format("%-8s", phanTu));
		}
		System.out.println();
	}

	// Kiem tra so chinh phuong
	public static boolean kiemTraSoChinhPhuong(int x) {
		int canNguyen = (int) Math.sqrt(x);
		if (Math.pow(canNguyen, 2) == x) {
			return true;
		}
		return false;
	}

	// Xoa cac so chinh phuong trong mang
	public static int[] xoaChinhPhuong() {
		int n = mang.length;
		int dem = 0;
		for (int phanTu : mang) {
			if (kiemTraSoChinhPhuong(phanTu)) {
				dem++;
			}
		}
		int[] ketQua = new int[n - dem];
		int viTri = 0;
		for (int phanTu : mang) {
			if (!kiemTraSoChinhPhuong(phanTu)) {
				ketQua[viTri] = phanTu;
				viTri++;
			}
		}
		return ketQua;
	}
}
