import java.util.Scanner;

public class TinhTongSoDuong {

	public static void main(String[] args) {
		int sum = tinhTong();
		System.out.println("Tổng là: " + sum);
	}
	
	public static int tinhTong() {
		int sum = 0, n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số: ");
		n = Integer.parseInt(scan.nextLine());
		while (n > 0) {
			sum += n;
			System.out.println("Nhập số: ");
			n = Integer.parseInt(scan.nextLine());
		}
		// Cach 2
		do {
			System.out.println("Nhập số nguyên: ");
			if (n <= 0)
				break;
			sum += n;
		} while(true);
		
		return sum;
	}
}
