import java.util.Scanner;

public class Bai9CanBoNamTreNhat {

	public static void main(String[] args) {
//		Input
		String ten1 = nhapTen(1);
		int nam1 = nhapNamSinh(1);
		String gioiTinh1 = nhapGioiTinh(1);

		String ten2 = nhapTen(2);
		int nam2 = nhapNamSinh(2);
		String gioiTinh2 = nhapGioiTinh(2);

		String ten3 = nhapTen(3);
		int nam3 = nhapNamSinh(3);
		String gioiTinh3 = nhapGioiTinh(3);

//		Process
		int maxNamSinh = 0;

		if (maxNamSinh < nam1 && gioiTinhNam(gioiTinh1)) {
			maxNamSinh = nam1;
		} else {
			maxNamSinh = maxNamSinh;
		}

		if (maxNamSinh < nam2 && gioiTinhNam(gioiTinh2)) {
			maxNamSinh = nam2;
		} else {
			maxNamSinh = maxNamSinh;
		}

		if (maxNamSinh < nam3 && gioiTinhNam(gioiTinh3)) {
			maxNamSinh = nam3;
		} else {
			maxNamSinh = maxNamSinh;
		}
		
//		Output
		if (maxNamSinh == nam1) {
			xuat(ten1);
		} else if (maxNamSinh == nam2) {
			xuat(ten2);
		} else {
			xuat(ten3);
		}
	}

	public static String nhapTen(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên cán bộ thứ " + i + " : ");
		String ten = scan.nextLine();
		return ten;
	}

	public static int nhapNamSinh(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập năm sinh cán bộ thứ " + i + " : ");
		int namSinh = Integer.parseInt(scan.nextLine());
		return namSinh;
	}

	public static String nhapGioiTinh(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập giới tính cán bộ thứ " + i + " : ");
		String gioiTinh = scan.nextLine();
		return gioiTinh;
	}

	public static void xuat(String ten) {
		System.out.println("Cán bộ nam trẻ nhất là: " + ten);
	}

	public static boolean gioiTinhNam(String gioiTinh) {
		if (gioiTinh.equalsIgnoreCase("nam")) {
			return true;
		} else {
			return false;
		}
	}
}
