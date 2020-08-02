import java.util.Scanner;

public class TimQuy {

	public static void main(String[] args) {
		// Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào tháng: ");
		int thang = Integer.parseInt(scan.nextLine());
		int quy = 0;

		// Processing
//		if (thang > 0 && thang < 13) {
//			if (thang < 4) {
//				System.out.println("Quý I");
//			} else if (thang < 7) {
//				System.out.println("Quý II");
//			} else if (thang < 10) {
//				System.out.println("Quý III");
//			} else {
//				System.out.println("Quý IV");
//			}
//		} else {
//			System.out.println("Nhập tháng từ 1 đến 12 ");
//		}

		switch (thang) {
		case 1:
			quy = 1;
			break;
		case 2:
			quy = 1;
			break;
		case 3:
			quy = 1;
			break;
		case 4:
		case 5:
		case 6:
			quy = 2;
			break;
		case 7:
		case 8:
		case 9:
			quy = 3;
			break;
		case 10:
		case 11:
		case 12:
			quy = 4;
			break;
		default:
			System.out.println("Nhập vào tháng từ 1 đến 12");
		}
		System.out.println("Quý: " + quy);
	}
}
