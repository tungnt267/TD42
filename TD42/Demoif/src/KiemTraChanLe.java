import java.util.Scanner;

public class KiemTraChanLe {
	public static void main(String[] args) {
//		Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number n: ");
		int n = Integer.parseInt(scan.nextLine());
//		Processing
		if (n % 2 == 0) {
			System.out.println(n + " là số chẵn");
		} else {
			System.out.println(n + " là số lẻ");
		}
	}
}
