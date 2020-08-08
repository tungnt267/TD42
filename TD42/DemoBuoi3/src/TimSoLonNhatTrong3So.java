import java.util.Scanner;

public class TimSoLonNhatTrong3So {

	public static void main(String[] args) {
		// Nhập dữ liệu
		int a = nhap("Nhập vào số thứ nhất: ");
		int b = nhap("Nhập vào số thứ hai: ");
		int c = nhap("Nhập vào số thứ ba: ");
		// Xử lý
		int max = timSoLonNhat(a, b, c);
		int sum = tinhTong(a, b, c);
		// In kết quả
		xuatKetQua("Số lớn nhất trong 3 số là: ", max);
		xuatKetQua("Tổng 3 số là: ", sum);
	}

	public static int nhap(String thongBao) {
		Scanner scan = new Scanner(System.in);
		System.out.println(thongBao);
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static int timSoLonNhat(int a, int b, int c) {

		return ((a > b) ? a : b) > c ? ((a > b) ? a : b) : c;

//		int max = a;
//		if(b > max) {
//			max = b;
//		} else {
//			max = max;
//		}
//		if(c > max) {
//			max = c;
//		} else {
//			max = max;
//		}
//		return max;
	}
	
	public static int tinhTong(int a, int b, int c) {
		return a + b + c;
	}

	public static void xuatKetQua(String thongBao, int ketQua) {
		System.out.println(thongBao + ketQua);
	}

}
