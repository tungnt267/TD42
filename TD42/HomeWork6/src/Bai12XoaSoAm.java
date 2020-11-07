public class Bai12XoaSoAm {

	public static float[] mang = { 1.3f, -4.5f, -6, 7, 9.1f, 0, -7, 8.4f, -9.1f, -4.8f, 4, 9.1f , -11.5f};

	public static void main(String[] args) {
		// Input
		xuatMang(mang);
		// Process
		float[] ketQua = xoaAm();
		// Output
		System.out.print("\nMang sau khi da xoa cac phan tu am: ");
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

	// Xoa cac phan tu am trong mang
	public static float[] xoaAm() {
		int n = mang.length;
		int dem = 0;
		for (float phanTu : mang) {
			if (phanTu < 0) {
				dem++;
			}
		}
		float[] ketQua = new float[n - dem];
		int viTri = 0;
		for (float phanTu : mang) {
			if (phanTu >= 0) {
				ketQua[viTri] = phanTu;
				viTri++;
			}
		}
		return ketQua;
	}
}
