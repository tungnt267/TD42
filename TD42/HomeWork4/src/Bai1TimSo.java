import java.util.Scanner;

public class Bai1TimSo {

	public static final int NUM_COMPARE = 5000;

	public static void main(String[] args) {
//		Input
		int n;
//		Process
		n = timSo();
//		Output
		xuatSo(n);
	}

	public static int timSo() {

		int total = 0;
		int n = 1;
		while (true) {
			total += n;
			if (total > NUM_COMPARE) {
				break;
			}
			n++;
		}
		return n;
	}

	public static void xuatSo(int n) {
		System.out.println("Số nguyên dương n phải tìm là: " + n);
	}

}
