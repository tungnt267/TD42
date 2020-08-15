import java.util.Scanner;

public class Bai7OanTuTi {

	public static int chonNguoiDung; // lựa chọn của người dùng
	public static int chonMay; // lựa chọn của máy
	public static int nguoiDungThang = 0; // số lần người dùng thắng
	public static int mayThang = 0; // số lần máy thắng

	public static void main(String[] args) {

		// Input
		// Process

		// Output
		do {
			nhap();
			tinhTiSo();
			if (chonNguoiDung == 0) {
				xuatKetQua();
			}
		} while (chonNguoiDung != 0);
	}

	public static int nhap() {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Nhập vào lựa chọn của bạn: ");
			chonNguoiDung = Integer.parseInt(scan.nextLine());
			if (chonNguoiDung < 0 || chonNguoiDung > 3) {
				System.out.println("Nhập vào một số trong khoảng 0-3! ");
			}
		} while (chonNguoiDung < 0 || chonNguoiDung > 3);
		return chonNguoiDung;
	}

	public static int phatSinhSoNgauNhien() {
		return (int) (Math.random() * 3 + 1);
	}

	public static void tinhTiSo() {
		chonMay = phatSinhSoNgauNhien(); // 1 = Bao, 2 = Búa, 3 = Kéo
		if (chonNguoiDung == 1) {
			if (chonMay == 1) {
				System.out.println("Hòa!");
				mayThang++;
				nguoiDungThang++;
			} else if (chonMay == 3) {
				System.out.println("Bạn thua!");
				mayThang++;
			} else {
				System.out.println("Bạn thắng!");
				nguoiDungThang++;
			}
		}
		if (chonNguoiDung == 2) {
			if (chonMay == 2) {
				System.out.println("Hòa!");
				mayThang++;
				nguoiDungThang++;
			} else if (chonMay == 1) {
				System.out.println("Bạn thua!");
				mayThang++;
			} else {
				System.out.println("Bạn thắng!");
				nguoiDungThang++;
			}
		}
		if (chonNguoiDung == 3) {
			if (chonMay == 3) {
				System.out.println("Hòa!");
				mayThang++;
				nguoiDungThang++;
			} else if (chonMay == 2) {
				System.out.println("Bạn thua!");
				mayThang++;
			} else {
				System.out.println("Bạn thắng!");
				nguoiDungThang++;
			}
		}
	}

	public static void xuatKetQua() {
		System.out.println("------------------------------------------------------------");
		if (nguoiDungThang > mayThang) {
			System.out.println("Bạn đã thắng máy với tỉ số: " + nguoiDungThang + "-" + mayThang);
		} else if (nguoiDungThang < mayThang) {
			System.out.println("Bạn đã thua máy với tỉ số: " + nguoiDungThang + "-" + mayThang);
		} else {
			System.out.println("Bạn hòa với máy! Tỉ số: " + nguoiDungThang + "-" + mayThang);
		}
	}
}
