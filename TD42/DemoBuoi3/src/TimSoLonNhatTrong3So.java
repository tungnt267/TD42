import java.util.Scanner;

public class TimSoLonNhatTrong3So {

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
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
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
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
