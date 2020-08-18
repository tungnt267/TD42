public class Bai13XoaSoChan {

	public static int[] mang = { 1, 4, -6, 7, 9, 0, -7, 8, -12, -4, 4, 15 };

	public static void main(String[] args) {
		// Input
		xuatMang(mang);
		// Process
		int[] ketQua = xoaChan();
		// Output
		System.out.print("\nMang sau khi da xoa cac phan tu chan: ");
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

	// Xoa cac phan tu chan trong mang
	public static int[] xoaChan() {
		int n = mang.length;
		int dem = 0;
		for (int phanTu : mang) {
			if (phanTu % 2 == 0) {
				dem++;
			}
		}
		int[] ketQua = new int[n - dem];
		int viTri = 0;
		for (int phanTu : mang) {
			if (phanTu % 2 != 0) {
				ketQua[viTri] = phanTu;
				viTri++;
			}
		}
		return ketQua;
	}
}
