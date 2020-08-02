import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
//		Input
//		final double PI = 3.14;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào bán kính hình tròn: ");
		double r = Double.parseDouble(scan.nextLine());
//		Processing
		double p = 2 * r * Math.PI;
		double s = Math.PI * Math.pow(r, 2);
//		Output
		System.out.println("Chu vi đường tròn: P = " + String.format("%.2f", p));
		System.out.println("Diện tích hình tròn: S = " + String.format("%.3f", s));
	}
}
