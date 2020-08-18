public class Bai11XoaCacSoLonNhat {

	public static float[] mang = { 1.3f, 4.5f, 6, 7, 9.1f, 0, 7, 8.4f, 9.1f, 4.8f, 4, 9.1f };

	public static void main(String[] args) {
		// Input
		xuatMang(mang);
		// Process
		float[] ketQua = xoaMax();
		// Output
		System.out.println("\nGia tri lon nhat trong mang: max = " + timMax());
		System.out.print("\nMang sau khi da xoa: ");
		xuatMang(ketQua);
	}

	// Xuat mang
	public static void xuatMang(float[] arr) {
		System.out.print("\nXuat mang: ");
		for (float phanTu : arr) {
			System.out.print(String.format("%-8s", phanTu));
		}
		System.out.println();
	}

	// Tim max
	public static float timMax() {
		float max = mang[0];
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] > max) {
				max = mang[i];
			}
		}
		return max;
	}

	// Xoa tat ca gia tri lon nhat trong mang
	public static float[] xoaMax() {
		float max = timMax();
		int n = mang.length;
		int dem = 0;
		for (float phanTu : mang) {
			if (phanTu == max) {
				dem++;
			}
		}
		float[] ketQua = new float[n - dem];
		int viTri = 0;
		for (float phanTu : mang) {
			if (phanTu != max) {
				ketQua[viTri] = phanTu;
				viTri++;
			}
		}
		return ketQua;
	}
}
