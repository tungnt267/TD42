import java.util.Scanner;

public class Bai1TriTuyetDoiCach1 {

	public static void main(String[] args) {
		// Đầu vào
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số thứ nhất: ");
		float a = Float.parseFloat(scan.nextLine());
		System.out.println("Nhập vào số thứ hai: ");
		float b = Float.parseFloat(scan.nextLine());
		System.out.println("Nhập vào số thứ ba: ");
		float c = Float.parseFloat(scan.nextLine());

		// Xử lý
		if (a < 0) {
			a = -a;
		} else {
			a = a;
		}
		if (b < 0) {
			b = -b;
		} else {
			b = b;
		}
		if (c < 0) {
			c = -c;
		} else {
			c = c;
		}

		// Đầu ra
		System.out.println("a = " + a + " b = " + b + " c = " + c);
	}

}
