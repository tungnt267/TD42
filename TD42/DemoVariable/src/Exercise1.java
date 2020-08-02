import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
//		Input
		double a, b, c;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào cạnh góc vuông thứ nhất: ");
		a = Double.parseDouble(input.nextLine());
		System.out.println("Nhập vào cạnh góc vuông thứ hai: ");
		b = Double.parseDouble(input.nextLine());
//		Processing
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
//		Output
		System.out.println("Cạnh huyền tam giác là: " + c);
	}
}
