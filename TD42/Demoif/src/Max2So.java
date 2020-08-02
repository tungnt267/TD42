import java.util.Scanner;

public class Max2So {
	public static void main(String[] args) {
//		Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int a = Integer.parseInt(scan.nextLine());
		System.out.println("Enter the second number: ");
		int b = Integer.parseInt(scan.nextLine());

//		Processing
//		if (a > b) {
//			System.out.println("The max:  " + a);
//		} 
//		else if (a < b) {
//			System.out.println("The max: " + b);
//		}
//		else {
//			System.out.println("The two numbers are equal");
//		}
		int max;
		max = b > a ? b : a;
		System.out.println("Số lớn nhất là: " + max);

//		Output
	}
}
