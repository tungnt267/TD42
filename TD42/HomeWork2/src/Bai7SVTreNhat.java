import java.util.Scanner;

public class Bai7SVTreNhat {

	public static void main(String[] args) {
//		Input
		String ten1 = nhapTen(1);
		int nam1 = nhapNamSinh(1);

		String ten2 = nhapTen(2);
		int nam2 = nhapNamSinh(2);

		String ten3 = nhapTen(3);
		int nam3 = nhapNamSinh(3);

//		Process
//		Output
		int max = timMax3So(nam1, nam2, nam3);
		if (max == nam1) {
			xuat(ten1, nam1);
		} else if (max == nam2) {
			xuat(ten2, nam2);
		} else {
			xuat(ten3, nam3);
		}
	}

	public static String nhapTen(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên SV thứ " + i + " : ");
		String ten = scan.nextLine();
		return ten;
	}

	public static int nhapNamSinh(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập năm sinh SV thứ " + i + " : ");
		int namSinh = Integer.parseInt(scan.nextLine());
		return namSinh;
	}

	public static void xuat(String ten, int namSinh) {
		System.out.println("Sinh viên trẻ nhất là: " + ten + " sinh năm " + namSinh);
	}

	public static int timMax3So(int a, int b, int c) {
		int max = c > (a > b ? a : b) ? c : ((a > b) ? a : b);
		return max;
	}
}
