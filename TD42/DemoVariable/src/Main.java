import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Input
		int theFirstNum, theSecondNum;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		theFirstNum = Integer.parseInt(input.nextLine());

		System.out.print("Enter the second number: ");
		theSecondNum = Integer.parseInt(input.nextLine());

		// Processing
		int sum = theFirstNum + theSecondNum;
		int diff = theFirstNum - theSecondNum;
		int mul = theFirstNum * theSecondNum;
		int modul = theFirstNum % theSecondNum;
		float div = (float) theFirstNum / theSecondNum;

		// Output
		System.out.println("The sum of two numbers: " + sum);
		System.out.println("The difference of two numbers: " + diff);
		System.out.println("The multiplication of two numbers: " + mul);
		System.out.println("The division of two numbers: " + div);
		System.out.println("The modulus of two numbers: " + modul);

	}
}
