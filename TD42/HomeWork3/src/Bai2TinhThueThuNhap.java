import java.util.Scanner;

public class Bai2TinhThueThuNhap {

	public static float tongThuNhapNam;
	public static int soNguoiPhuThuoc;

	public static final float THUE_60 = 5;
	public static final float THUE_60_120 = 10;
	public static final float THUE_120_216 = 15;
	public static final float THUE_216_384 = 20;
	public static final float THUE_384_624 = 25;
	public static final float THUE_624_960 = 30;
	public static final float THUE_TREN_960 = 35;

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
			// Input
			nhapThongTin();
			// Process
			float thuNhapChiuThue = tinhThuNhapChiuThue();
			float thuePhaiTra = tinhThueThuNhapCaNhan(thuNhapChiuThue);
			// Output
			xuatThue(thuePhaiTra);
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
	}

	public static void nhapThongTin() {
		Scanner scan = new Scanner(System.in);
		String hoTen;

		System.out.println("Nhập họ tên: ");
		hoTen = scan.nextLine();
		do {
			System.out.println("Tổng thu nhập năm (triệu): ");
			tongThuNhapNam = Float.parseFloat(scan.nextLine());
			if (tongThuNhapNam < 0) {
				System.out.println("Tổng thu nhập phải không âm! ");
			}
		} while (tongThuNhapNam < 0);
		do {
			System.out.println("Nhập số người phụ thuộc: ");
			soNguoiPhuThuoc = Integer.parseInt(scan.nextLine());
			if (soNguoiPhuThuoc < 0) {
				System.out.println("Số người phụ thuộc phải không âm! ");
			}
		} while (soNguoiPhuThuoc < 0);
	}

	public static float tinhThuNhapChiuThue() {
		return tongThuNhapNam - 4 - soNguoiPhuThuoc * 1.6f;
	}

	public static float tinhThueThuNhapCaNhan(float thuNhapChiuThue) {
		float thuePhaiTra;
		if (thuNhapChiuThue <= 60) {
			thuePhaiTra = thuNhapChiuThue * THUE_60 / 100;
			;
		} else if (thuNhapChiuThue > 60 && thuNhapChiuThue <= 120) {
			thuePhaiTra = thuNhapChiuThue * THUE_60_120 / 100;
		} else if (thuNhapChiuThue > 120 && thuNhapChiuThue <= 216) {
			thuePhaiTra = thuNhapChiuThue * THUE_120_216 / 100;
		} else if (thuNhapChiuThue > 216 && thuNhapChiuThue <= 384) {
			thuePhaiTra = thuNhapChiuThue * THUE_216_384 / 100;
		} else if (thuNhapChiuThue > 384 && thuNhapChiuThue <= 624) {
			thuePhaiTra = thuNhapChiuThue * THUE_384_624 / 100;
		} else if (thuNhapChiuThue > 624 && thuNhapChiuThue <= 960) {
			thuePhaiTra = thuNhapChiuThue * THUE_624_960 / 100;
		} else {
			thuePhaiTra = thuNhapChiuThue * THUE_TREN_960 / 100;
		}
		return thuePhaiTra;
	}

	public static void xuatThue(float thuePhaiTra) {
		System.out.println("Thuế phải trả là: " + thuePhaiTra + " triệu VNĐ");
	}
}
