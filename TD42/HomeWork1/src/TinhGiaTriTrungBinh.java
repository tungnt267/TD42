import java.util.Scanner;

public class TinhGiaTriTrungBinh {

	public static void main(String[] args) {
//		Đầu vào
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số thực thứ nhất: ");
		double soThuNhat = Double.parseDouble(scan.nextLine());
		System.out.println("Số thứ hai: ");
		double soThuHai = Double.parseDouble(scan.nextLine());
		System.out.println("Số thứ ba: ");
		double soThuBa = Double.parseDouble(scan.nextLine());
		System.out.println("Số thứ tư: ");
		double soThuTu = Double.parseDouble(scan.nextLine());
		System.out.println("Số thứ năm: ");
		double soThuNam = Double.parseDouble(scan.nextLine());

//		Xử lý, tính toán
		double giaTriTB = (soThuNhat + soThuHai + soThuBa + soThuTu + soThuNam) / 5;

//		Đầu ra
		System.out.println("Giá trị trung bình của 5 số thực trên là: " + giaTriTB);

	}

}
