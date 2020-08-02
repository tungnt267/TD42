import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
//		Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number n: ");
		int n = scan.nextInt();
//		Process
		int thousand = n / 1000;
		int hundred = (n % 1000) / 100;
		int ten = (n % 100) / 10;
		int unit = n % 10;
//		Output
		int sum = thousand + hundred + ten + unit;
		System.out.println("Sum of digits: " + sum);
	}
}
