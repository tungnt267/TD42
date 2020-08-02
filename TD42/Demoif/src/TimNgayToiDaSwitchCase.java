import java.util.Scanner;

public class TimNgayToiDaSwitchCase {

	public static void main(String[] args) {
		//	Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào tháng: ");
		int thang = Integer.parseInt(scan.nextLine());
		System.out.println("Nhập vào năm: ");
		int nam = Integer.parseInt(scan.nextLine());
		int ketQua = 0;

		// Processing
		switch (thang) {
			case 2:
				ketQua = ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) ? 29 : 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				ketQua = 30;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				ketQua = 31;
				break;
			default:
				System.out.println("Tháng không hợp lệ!");
		}
		// Output
		System.out.println("Tháng " + thang + " năm " + nam + " có " + ketQua + " ngày");
	}
}
