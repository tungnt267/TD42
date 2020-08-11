import java.util.Scanner;

public class TinhDiemTB {

	public static float diemToan, diemVan;
	public static String hoTen;

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
			// Nhập dữ liệu
			nhap();
			// Xử lý
			float diemTB = tinhDiemTrungBinh();
			String xLoai = xepLoai();
			// In kết quả
			xuat(diemTB, xLoai);
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
	}

	public static void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập họ tên: ");
		hoTen = scan.nextLine();
		do {
			System.out.println("Nhập điểm toán: ");
			diemToan = Float.parseFloat(scan.nextLine());
		} while (diemToan < 0 || diemToan > 10);
		do {
			System.out.println("Nhập điểm văn: ");
			diemVan = Float.parseFloat(scan.nextLine());
		} while (diemVan < 0 || diemVan > 10);
	}

	public static float tinhDiemTrungBinh() {
		return (diemToan + diemVan) / 2;
	}

	public static String xepLoai() {
		String xepLoai = null;
		float diemTrungBinh = tinhDiemTrungBinh();
		if (diemTrungBinh < 5) {
			xepLoai = "Yếu";
		} else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
			xepLoai = "Trung Bình";
		} else if (diemTrungBinh >= 7 && diemTrungBinh < 8.5) {
			xepLoai = "Khá";
		} else {
			xepLoai = "Giỏi";
		}
		return xepLoai;
	}

	public static void xuat(float diemTB, String xLoai) {
		System.out.println("---------------------------------------------------------");
		System.out.print("Họ tên");
		System.out.print("\t" + "|" + "\tĐiểm trung bình");
		System.out.print("\t\tXếp loại");
		System.out.println("");
		System.out.print(hoTen);
		System.out.print("\t" + "|" + "\t" + diemTB);
		System.out.print("\t\t\t" + xLoai);
		System.out.print("\n---------------------------------------------------------");
	}

}
