import java.util.Scanner;

public class Bai4KiemTraTamGiac {

	public static double canhThuNhat, canhThuHai, canhThuBa;

	public static void main(String[] args) {
		// Input
		canhThuNhat = nhapCanh(1);
		canhThuHai = nhapCanh(2);
		canhThuBa = nhapCanh(3);

		// Process

		String ketQua = kiemTraTamGiac(canhThuNhat, canhThuHai, canhThuBa);
		// Output
		xuat(ketQua);
	}

	public static double nhapCanh(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào cạnh thứ " + i + " : ");
		double n = Double.parseDouble(scan.nextLine());
		return n;
	}

	public static void xuat(String ketQua) {
		System.out.println(ketQua);
	}

	public static String kiemTraTamGiac(double a, double b, double c) {

		String ketQua = "";
		if (a > 0 && b > 0 && c > 0) {

			if ((a + b > c) && (a + c > b) && (b + c > a)) {

				if (tamGiacDeu(a, b, c)) {
					ketQua = " tam giác đều";
				} else {
					if (tamGiacCan(a, b, c)) {
						if (tamGiacVuong(a, b, c)) {
							ketQua = " tam giác vuông cân";
						} else {
							ketQua = " tam giác cân";
						}
					} else if (tamGiacVuong(a, b, c)) {
						ketQua = " tam giác vuông";
					} else {
						ketQua = " tam giác thường";
					}
				}
			} else {
				ketQua = "Các cạnh nhập vào không tạo thành tam giác";
			}
		} else {
			ketQua = "Các cạnh nhập vào phải là số dương!";
		}
		return ketQua;
	}

	public static boolean tamGiacCan(double a, double b, double c) {
		if ((a == b) || (b == c) || (c == a)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean tamGiacDeu(double a, double b, double c) {
		if ((a == b) && (b == c) && (c == a)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean tamGiacVuong(double a, double b, double c) {
		if ((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == b * b + a * a)) {
			return true;
		} else {
			return false;
		}
	}
}
