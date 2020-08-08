import java.util.Scanner;

public class CaseStudy1 {
	public static void main(String[] args) {
//		Input
		System.out.println("Chiều dài căn phòng: ");
		float daiPhong = nhap();
		System.out.println("Chiều rộng căn phòng: ");
		float rongPhong = nhap();
		System.out.println("Chiều cao căn phòng: ");
		float caoPhong = nhap();

		System.out.println("Số cánh cửa: ");
		int soCanhCua = nhapInt();
		System.out.println("Chiều dài cánh cửa: ");
		float daiCanhCua = nhap();
		System.out.println("Chiều rộng cánh cửa: ");
		float rongCanhCua = nhap();

		System.out.println("Số cửa sổ: ");
		int soCuaSo = nhapInt();
		System.out.println("Chiều dài cửa sổ: ");
		float daiCuaSo = nhap();
		System.out.println("Chiều rộng cửa sổ: ");
		float rongCuaSo = nhap();

		System.out.println("Lượng sơn để bao phủ 1 mét vuông (lít/m2): ");
		float sonBaoPhu = nhap();

//		Process
		// Tính số sơn cần thiết để sơn trần nhà.
		float sonTranNha = dienTichHCN(daiPhong, rongPhong) * sonBaoPhu;

		// Tính số sơn cần thiết để sơn tường.
		float sonTuong, tongDienTichCua, tongDienTichTuong;
		// Tổng diện tích các cánh cửa và cửa sổ
		tongDienTichCua = (float) soCanhCua * dienTichHCN(daiCanhCua, rongCanhCua)
				+ (float) soCuaSo * dienTichHCN(daiCuaSo, rongCuaSo);
		// Tổng diện tích 4 mặt tường
		tongDienTichTuong = 2 * dienTichHCN(daiPhong, caoPhong) + 2 * dienTichHCN(rongPhong, caoPhong);
		// Tổng sơn cần thiết để sơn tường
		sonTuong = (tongDienTichTuong - tongDienTichCua) * sonBaoPhu;

//		Output
		xuat("Số sơn cần thiết để sơn tường (lít) là: ", sonTuong);
		xuat("Số sơn cần thiết để sơn trần nhà (lít) là: ", sonTranNha);
	}

	public static int nhapInt() {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static float nhap() {
		Scanner scan = new Scanner(System.in);
		float n = Float.parseFloat(scan.nextLine());
		return n;
	}

	public static void xuat(String thongBao, float ketQua) {
		System.out.println(thongBao + ketQua);
	}

	public static float dienTichHCN(float a, float b) {
		return a * b;
	}
}