import java.util.Scanner;

public class TinhTienGrab {
	// DEFINE
	public static String loaiXe;
	public static float soKm;
	public static int thoiGianCho;

	// CONSTANT
	public static final int GRAB_CAR_MUC_1 = 8000;
	public static final int GRAB_CAR_MUC_2 = 7500;
	public static final int GRAB_CAR_MUC_3 = 7000;
	public static final int GRAB_CAR_WAIT = 2000;

	public static final int GRAB_SUV_MUC_1 = 9000;
	public static final int GRAB_SUV_MUC_2 = 8500;
	public static final int GRAB_SUV_MUC_3 = 8000;
	public static final int GRAB_SUV_WAIT = 3000;

	public static final int GRAB_BLACK_MUC_1 = 10000;
	public static final int GRAB_BLACK_MUC_2 = 9500;
	public static final int GRAB_BLACK_MUC_3 = 9000;
	public static final int GRAB_BLACK_WAIT = 3500;

	public static void main(String[] args) {
		// Input
		nhap();
		// Process
		double tongTien = tinhTien();
		// Output
		inHoaDon(tongTien);
	}

	public static void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập loại xe: ");
		loaiXe = scan.nextLine();
		System.out.println("Số km đã đi: ");
		soKm = Float.parseFloat(scan.nextLine());
		System.out.println("Thời gian chờ: ");
		thoiGianCho = Integer.parseInt(scan.nextLine());
	}

	public static double tinhTien() {
		double tong = 0;
		double thoiGian = thoiGianCho < 3 ? 0 : (Math.ceil((double) thoiGianCho / 3));
		if (loaiXe.equalsIgnoreCase("grabcar")) {
			if (soKm <= 1) {
				tong = GRAB_CAR_MUC_1 + GRAB_CAR_WAIT * thoiGian;
			} else if (soKm > 1 && soKm <= 19) {
				tong = GRAB_CAR_MUC_1 + GRAB_CAR_MUC_2 * (soKm - 1) + GRAB_CAR_WAIT * thoiGian;
			} else {
				tong = GRAB_CAR_MUC_1 + GRAB_CAR_MUC_2 * 18 + GRAB_CAR_MUC_3 * (soKm - 19)
						+ GRAB_CAR_WAIT * thoiGian;
			}
		} else if (loaiXe.equalsIgnoreCase("grabsuv")) {
			if (soKm <= 1) {
				tong = GRAB_SUV_MUC_1 + GRAB_SUV_WAIT * thoiGian;
			} else if (soKm > 1 && soKm <= 19) {
				tong = GRAB_SUV_MUC_1 + GRAB_SUV_MUC_2 * (soKm - 1) + GRAB_SUV_WAIT * thoiGian;
			} else {
				tong = GRAB_SUV_MUC_1 + GRAB_SUV_MUC_2 * 18 + GRAB_SUV_MUC_3 * (soKm - 19)
						+ GRAB_SUV_WAIT * thoiGian;
			}
		} else if (loaiXe.equalsIgnoreCase("grabblack")) {
			if (soKm <= 1) {
				tong = GRAB_BLACK_MUC_1 + GRAB_BLACK_WAIT * thoiGian;
			} else if (soKm > 1 && soKm <= 19) {
				tong = GRAB_BLACK_MUC_1 + GRAB_BLACK_MUC_2 * (soKm - 1) + GRAB_BLACK_WAIT * thoiGian;
			} else {
				tong = GRAB_BLACK_MUC_1 + GRAB_BLACK_MUC_2 * 18 + GRAB_BLACK_MUC_3 * (soKm - 19)
						+ GRAB_BLACK_WAIT * thoiGian;
			}
		} else {
			System.out.println("Loại xe không đúng!");
		}
		return tong;
	}

	public static void inHoaDon(double tongTien) {
		System.out.println("------------------------------------------------------");
		System.out.println("Số km: " + soKm);
		System.out.println("Loại xe: " + loaiXe);
		System.out.println("Thời gian chờ: " + thoiGianCho);
		System.out.println("------------------------------------------------------");
		System.out.print("Tổng tiền: ");
		String chuoiDinhDang = String.format("%10s", tongTien + " VNĐ");
		System.out.println(chuoiDinhDang);
	}

}
