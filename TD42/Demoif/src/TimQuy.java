import java.util.Scanner;

public class TimQuy {

	public static void main(String[] args) {
		// Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào tháng: ");
		int thang = Integer.parseInt(scan.nextLine());

		// Processing
		if (thang > 0 && thang < 13) {
			if (thang < 4) {
				System.out.println("Quý I");
			} else if (thang < 7) {
				System.out.println("Quý II");
			} else if (thang < 10) {
				System.out.println("Quý III");
			} else {
				System.out.println("Quý IV");
			}
		} else {
			System.out.println("Nhập tháng từ 1 đến 12 ");
		}
	}
}
