import java.util.Scanner;

public class BaiTap5MangMotChieu {

	public static int n = 0;
	public static int[] mang;

	public static void main(String[] args) {
		// Input
		nhapMang();
		// Process
		// Output
		chonMenu();
	}

	public static void chonMenu() {
		Scanner scan = new Scanner(System.in);
		int chon;
		boolean thoat = false;
		System.out.println();
		xuatMang();
		do {
			inMenu();
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				xuatMang();
				int tongDuong = tinhTongCacSoDuong();
				System.out.println("Tong cac so duong trong mang la: " + tongDuong);
				break;
			case 2:
				xuatMang();
				int demSoDuong = demSoDuong();
				System.out.println("So luong so duong trong mang la: " + demSoDuong);
				break;
			case 3:
				xuatMang();
				int min = timMin();
				System.out.println("So nho nhat trong mang la: " + min);
				break;
			case 4:
				xuatMang();
				int minDuong = timMinDuong();
				System.out.println("So duong nho nhat trong mang la: " + minDuong);
				break;
			case 5:
				xuatMang();
				int soChanCuoi = timSoChanCuoiCung();
				if (soChanCuoi == -1) {
					System.out.println("Mang khong co gia tri chan!");
				} else {
					System.out.println("So chan cuoi cung trong mang la: " + soChanCuoi);
				}
				break;
			case 6:
				xuatMang();
				mang = doiCho2GiaTri();
				System.out.print("Mang sau khi doi cho 2 phan tu: ");
				xuatMang();
				break;
			case 7:
				xuatMang();
				mang = sapXepTangDan();
				System.out.print("Mang da sap xep: ");
				xuatMang();
				break;
			case 8:
				xuatMang();
				int soNTDauTien = timSoNguyenToDauTien();
				System.out.println("So nguyen to dau tien cua mang: " + soNTDauTien);
				break;
			case 9:
//				xuatMang();
				float[] mangSoThuc = nhapMangSoThuc();
				xuatMangSoThuc(mangSoThuc);
				System.out.println("So luong so nguyen la: " + timSoNguyenTrongMangThuc(mangSoThuc));
				break;
			case 10:
				xuatMang();
				soSanhAmDuong();
				break;
			case 0:
				System.out.println("Chuong trinh da ket thuc!");
				thoat = true;
				break;
			default:
				break;
			}
		} while (!thoat);
	}

	// In Menu
	public static void inMenu() {
		System.out.print("\n1. Tổng các số dương  trong mảng.");
		System.out.print("\n2. Đếm có bao nhiêu số dương trong mảng.");
		System.out.print("\n3. Tìm số nhỏ nhất trong mảng.");
		System.out.print("\n4. Tìm số dương nhỏ nhất trong mảng.");
		System.out.print("\n5. Tìm số chẵn cuối cùng trong mảng.");
		System.out.print("\n6. Đổi chỗ 2 giá trị trong mảng theo vị trí.");
		System.out.print("\n7. Sắp xếp mảng theo thứ tự tăng dần.");
		System.out.print("\n8. Tìm số nguyên tố đầu tiên trong mảng.");
		System.out.print("\n9. Nhập thêm 1 mảng số thực, tìm số lượng sô nguyên trong mảng số thực.");
		System.out.print("\n10. So sánh số lượng số dương và số lượng số âm.");
		System.out.print("\n0. Thoát chương trình.\n");
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
		System.out.print("\nmang: [ ");
		for (int phanTu : mang) {
			System.out.print(phanTu + " ");
		}
		System.out.print("]\n");
	}

	// 1. Tong cac so duong
	public static int tinhTongCacSoDuong() {
		int tongDuong = 0;
		for (int i = 0; i < n; i++) {
			if (mang[i] > 0) {
				tongDuong += mang[i];
			}
		}
		return tongDuong;
	}

	// 2. Dem so cac so duong
	public static int demSoDuong() {
		int dem = 0;
		for (int i = 0; i < n; i++) {
			if (mang[i] > 0) {
				dem++;
			}
		}
		return dem;
	}

	// 3. Tim phan tu nho nhat trong mang
	public static int timMin() {
		int min = mang[0];
		for (int i = 0; i < n; i++) {
			if (mang[i] <= min) {
				min = mang[i];
			}
		}
		return min;
	}

	// 4. Tim so duong nho nhat trong mang
	public static int timMinDuong() {
		int minDuong = mang[0];
		for (int i = 0; i < n; i++) {
			if (mang[i] > 0) {
				minDuong = mang[i];
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (mang[i] > 0 && mang[i] <= minDuong) {
				minDuong = mang[i];
			}
		}
		return minDuong;
	}

	// 5. Tim so chan cuoi cung trong mang
	public static int timSoChanCuoiCung() {
		int soChanCuoi = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (mang[i] % 2 == 0) {
				soChanCuoi = mang[i];
				break;
			}
		}
		return soChanCuoi;
	}

	// 6. Doi cho 2 gia tri trong mang theo vi tri
	public static int[] doiCho2GiaTri() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao 2 vi tri muon doi cho gia tri: ");
		System.out.print("\nVi tri thu nhat i = ");
		int viTriMot = Integer.parseInt(scan.nextLine());
		System.out.print("\nVi tri thu hai i = ");
		int viTriHai = Integer.parseInt(scan.nextLine());
		int temp = mang[viTriMot];
		mang[viTriMot] = mang[viTriHai];
		mang[viTriHai] = temp;
		return mang;
	}

	// 7. Sap xep mang theo thu tu tang dan
	public static int[] sapXepTangDan() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (mang[j] < mang[i]) {
					int temp = mang[i];
					mang[i] = mang[j];
					mang[j] = temp;
				}
			}
		}
		return mang;
	}

	// 8. Tim so nguyen to dau tien trong mang
	// Kiem Tra so nguyen to
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

	// Tim SNT dau tien
	public static int timSoNguyenToDauTien() {
		int ketQua = mang[0];
		for (int i = 0; i < n; i++) {
			if (kiemTraSNT(mang[i])) {
				ketQua = mang[i];
				break;
			}
		}
		return ketQua;
	}

	// 9. Tim so luong so nguyen trong mang so thuc
	// Nhap mang so thuc
	public static float[] nhapMangSoThuc() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n----------------------Nhap mang so thuc----------------------");
		System.out.println("Nhap so phan tu cua mang: ");
		int length = Integer.parseInt(scan.nextLine());
		float[] mangSoThuc = new float[length];
		System.out.println("Nhap cac phan tu cua mang: ");
		for (int i = 0; i < length; i++) {
			System.out.print("mangSoThuc[" + i + "]: ");
			mangSoThuc[i] = Float.parseFloat(scan.nextLine());
		}
		return mangSoThuc;
	}

	// Xuat mang so thuc
	public static void xuatMangSoThuc(float[] mangSoThuc) {
		System.out.print("\nMang so thuc: [ ");
		for (float phanTu : mangSoThuc) {
			System.out.print(phanTu + " ");
		}
		System.out.print("]\n");
	}

	// Kiem tra so nguyen
	public static boolean kiemTraSoNguyen(float x) {
		int y = (int) x;
		return y == x;
	}

	// Tim so luong so nguyen
	public static int timSoNguyenTrongMangThuc(float[] mangSoThuc) {
		int demSoNguyen = 0;
		for (int i = 0; i < mangSoThuc.length; i++) {
			if (kiemTraSoNguyen(mangSoThuc[i])) {
				demSoNguyen++;
			}
		}
		return demSoNguyen;
	}

	// 10. So sanh so luong so duong va so am
	public static void soSanhAmDuong() {
		int demDuong = 0, demAm = 0;
		for (int i = 0; i < n; i++) {
			if (mang[i] > 0) {
				demDuong++;
			} else if (mang[i] < 0) {
				demAm++;
			}
		}
		if (demDuong > demAm) {
			System.out.print("\nMang co nhieu so duong hon! So luong so duong: " + demDuong + " - So luong so am: "
					+ demAm + "\n");
		} else if (demDuong < demAm) {
			System.out.print(
					"\nMang co nhieu so am hon! So luong so am: " + demAm + " - So luong so duong: " + demDuong + "\n");
		} else {
			System.out.print("\nSo luong so duong va so am bang nhau va deu bang " + demDuong + "\n");
		}
	}
}
