import java.util.Scanner;

public class Bai5SoNgayTrongThang {

	public static void main(String[] args) {
		// Input
		int thang = nhap("tháng");

		// Processing
		if (kiemTraThang(thang)) {
			int nam = nhap("năm");

			int ngay = soNgay(thang, nam);

			// Output
			xuat(ngay, thang, nam);
		} else {
			System.out.println("Tháng không hợp lệ!");
		}

	}

	public static int nhap(String s) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào " + s + " : ");
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static boolean kiemTraThang(int x) {
		if (x > 0 && x < 13) {
			return true;
		} else {
			return false;
		}
	}

	public static void xuat(int ngay, int thang, int nam) {
		System.out.println("Tháng " + thang + " năm " + nam + " có " + ngay + " ngày");
	}

	public static int soNgay(int thang, int nam) {
		int ngay = 0;
		switch (thang) {
		case 2:
			ngay = ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			ngay = 30;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			ngay = 31;
			break;
		default:
			break;
		}
		return ngay;
	}
}
