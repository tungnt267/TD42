import java.util.Scanner;

public class Bai2TriTuyetDoiCach2 {

	public static void main(String[] args) {
		// Đầu vào
		System.out.println("Số thứ nhất: ");
		float a = nhapSoThuc();
		System.out.println("Số thứ hai: ");
		float b = nhapSoThuc();
		System.out.println("Số thứ ba: ");
		float c = nhapSoThuc();

		// Xử lý
		a = triTuyetDoi(a);
		b = triTuyetDoi(b);
		c = triTuyetDoi(c);

		// Đầu ra
		xuat("a = ", a);
		xuat("b = ", b);
		xuat("c = ", c);
	}

	public static float nhapSoThuc() {
		Scanner scan = new Scanner(System.in);
		float n = Float.parseFloat(scan.nextLine());
		return n;
	}

	public static float triTuyetDoi(float x) {
		return Math.abs(x);
	}

	public static void xuat(String thongBao, float ketQua) {
		System.out.println(thongBao + ketQua);
	}
}
