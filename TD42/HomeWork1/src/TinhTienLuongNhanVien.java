import java.util.Scanner;

public class TinhTienLuongNhanVien {

	public static void main(String[] args) {

		// Đầu vào
		final double LUONG_MOT_NGAY = 100000;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số ngày làm: ");
		int soNgay = Integer.parseInt(scan.nextLine());

		// Xử lý, tính toán
		double luongNhanVien = (double) LUONG_MOT_NGAY * soNgay;

		// Đầu ra
		System.out.println("Tiền lương nhân viên: " + luongNhanVien);
	}

}
