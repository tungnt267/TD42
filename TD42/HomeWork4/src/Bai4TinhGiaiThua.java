import java.util.Scanner;

public class Bai4TinhGiaiThua {

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
			// Input
			int n = nhapSo();
			// Process
			long giaiThua = tinhGiaiThua(n);
			// Output
			xuatGiaiThua(giaiThua);;
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
	}

	public static int nhapSo() {
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhập số: ");
			n = Integer.parseInt(scan.nextLine());
			if (n < 0) {
				System.out.println("Nhập vào một số không âm! ");
			}
		} while (n < 0);
		return n;
	}

	public static long tinhGiaiThua(int n) {
		long giaiThua = 1;
		if (n == 0) {
			giaiThua = 1;
		} else {
			while (n > 0) {
				giaiThua *= n;
				n--;
			}
		}
		return giaiThua;
	}
	public static void xuatGiaiThua(long giaiThua) {
		System.out.println("Kết quả: " + giaiThua);
	}

}
