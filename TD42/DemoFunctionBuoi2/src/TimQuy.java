import java.util.Scanner;

public class TimQuy {

	public static void main(String[] args) {
//		input
		int thang = nhap();
//		processing
		int quy = timQuy(thang);
//		output
		xuat(quy);
	}
	public static int nhap() {
		int thang;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tháng: ");
		thang = Integer.parseInt(scan.nextLine());
		return thang;
	}
	public static int timQuy(int thang) {
		int quy = 0;
		if (thang > 0 && thang < 4) {
			quy = 1;
		} else if (thang >= 4 && thang < 7) {
			quy = 2;
		} else if (thang >= 7 && thang < 10) {
			quy = 3;
		} else {
			quy = 4;
		}
		return quy;
	}
	public static void xuat(int ketQua) {
		System.out.println("Quý:" + ketQua);
	}
	
}
