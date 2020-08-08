import java.util.Scanner;

public class Bai10ToaDoSinhVien {

	public static final double X_TRUONG = 0;
	public static final double Y_TRUONG = 0;

	public static void main(String[] args) {
//		Input
		String ten1 = nhapTen(1);
		double x1 = nhapToaDoX(1);
		double y1 = nhapToaDoY(1);

		String ten2 = nhapTen(2);
		double x2 = nhapToaDoX(2);
		double y2 = nhapToaDoY(2);

		String ten3 = nhapTen(3);
		double x3 = nhapToaDoX(3);
		double y3 = nhapToaDoY(3);

//		Process
		double khoangCach1 = tinhKhoangCach(x1, y1);
		double khoangCach2 = tinhKhoangCach(x2, y2);
		double khoangCach3 = tinhKhoangCach(x3, y3);
		double max = timMax3So(khoangCach1, khoangCach2, khoangCach3);

//		Output
		if(max == khoangCach1) {
			xuat(ten1);
		} else if(max == khoangCach2) {
			xuat(ten2);
		} else {
			xuat(ten3);
		}
	}

	public static String nhapTen(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên SV thứ " + i + " : ");
		String ten = scan.nextLine();
		return ten;
	}

	public static double nhapToaDoX(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tọa độ X của SV thứ " + i + " : ");
		double x = Double.parseDouble(scan.nextLine());
		return x;
	}

	public static double nhapToaDoY(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tọa độ Y của SV thứ " + i + " : ");
		double y = Double.parseDouble(scan.nextLine());
		return y;
	}

	public static void xuat(String ten) {
		System.out.println("Sinh viên xa trường nhất là: " + ten);
	}

	public static double timMax3So(double a, double b, double c) {
		double max = c > (a > b ? a : b) ? c : ((a > b) ? a : b);
		return max;
	}

	public static double tinhKhoangCach(double x, double y) {
		return Math.sqrt(Math.pow((x - X_TRUONG), 2) + Math.pow((y - Y_TRUONG), 2));
	}
}
