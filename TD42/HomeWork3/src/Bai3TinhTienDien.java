import java.util.Scanner;

public class Bai3TinhTienDien {

	public static int soDien;

	public static final int KW_DAU_50 = 500;
	public static final int KW_2_50 = 650;
	public static final int KW_3_100 = 850;
	public static final int KW_4_150 = 1100;
	public static final int KW_CON_LAI = 1300;

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
			// Input
			nhapThongTin();
			// Process
			int tienDien = tinhTienDien();
			// Output
			inHoaDon(tienDien);
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
	}

	public static void nhapThongTin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên: ");
		String ten = scan.nextLine();

		do {
			System.out.println("Nhập số Kw điện: ");
			soDien = Integer.parseInt(scan.nextLine());
			if (soDien < 0) {
				System.out.println("Số Kw điện phải không âm! ");
			}
		} while (soDien < 0);
	}

	public static int tinhTienDien() {
		int tienDien;
		if (soDien <= 50) {
			tienDien = soDien * KW_DAU_50;
		} else if (soDien > 50 && soDien <= 100) {
			tienDien = 50 * KW_DAU_50 + (soDien - 50) * KW_2_50;
		} else if (soDien > 100 && soDien <= 200) {
			tienDien = 50 * KW_DAU_50 + 50 * KW_2_50 + (soDien - 100) * KW_3_100;
		} else if (soDien > 200 && soDien <= 350) {
			tienDien = 50 * KW_DAU_50 + 50 * KW_2_50 + 100 * KW_3_100 + (soDien - 200) * KW_4_150;
		} else {
			tienDien = 50 * KW_DAU_50 + 50 * KW_2_50 + 100 * KW_3_100 + 150 * KW_4_150 + (soDien - 350) * KW_CON_LAI;
		}
		return tienDien;
	}

	public static void inHoaDon(int tienDien) {
		System.out.println("Số tiền điện phải trả là: " + tienDien);
	}

}
