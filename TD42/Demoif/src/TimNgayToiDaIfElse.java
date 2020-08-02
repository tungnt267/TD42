import java.util.Scanner;

public class TimNgayToiDaIfElse {
	public static void main(String[] args) {
		// Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào tháng: ");
		int thang = Integer.parseInt(scan.nextLine());
		System.out.println("Nhập vào năm: ");
		int nam = Integer.parseInt(scan.nextLine());
		int ketQua = 0;

		// Processing
		if (thang > 0 && thang < 13) {
			if (thang == 2) {
				if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
					ketQua = 29;
				} else {
					ketQua = 28;
				}
			} else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
				ketQua = 30;
			} else {
				ketQua = 31;
			}
			System.out.println("Tháng " + thang + " năm " + nam + " có " + ketQua + " ngày");
		} else {
			System.out.println("Tháng không hợp lệ!");
		}
	}
}
