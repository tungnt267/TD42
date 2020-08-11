import java.util.Scanner;

public class QuyDoiTien {

	public static void main(String[] args) {
//		Đầu vào
		final double TI_GIA_USD = 23500;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số tiền USD cần đổi: ");
		double tienUSD = Double.parseDouble(scan.nextLine());

//		Xử lý, tính toán
		double tienVND = tienUSD * TI_GIA_USD;

//		Đầu ra
		System.out.println("Số tiền sau quy đổi: " + tienVND + " VND");

	}

}
