import java.util.Scanner;

public class Tong2KySo {

	public static void main(String[] args) {
//		Đầu vào
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào một số có 2 ký số: ");
		int n = Integer.parseInt(scan.nextLine());

//		Xử lý, tính toán
		int hangChuc = n / 10;
		int hangDonVi = n % 10;
		int tongKySo = hangChuc + hangDonVi;

//		Đầu ra
		System.out.println("Tổng hai ký số: " + tongKySo);
	}

}
