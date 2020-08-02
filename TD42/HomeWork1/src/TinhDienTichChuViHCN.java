import java.util.Scanner;

public class TinhDienTichChuViHCN {

	public static void main(String[] args) {
//		Đầu vào
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào chiểu dài HCN: ");
		double chieuDai = Double.parseDouble(scan.nextLine());
		System.out.println("Nhập vào chiểu rộng HCN: ");
		double chieuRong = Double.parseDouble(scan.nextLine());

//		Xử lý, tính toán
		double chuVi = (chieuDai + chieuRong) * 2;
		double dienTich = chieuDai * chieuRong;

//		Đầu ra
		System.out.println("Chu vi HCN: " + chuVi);
		System.out.println("Diện tích HCN: " + dienTich);
	}

}
