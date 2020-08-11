import java.util.Scanner;

public class Bai6TroChoiDoanSo {

	public static int soNguoiDungNhap;
	public static int soNgauNhien;
	public static int dem = 0; // số lần đoán

	public static void main(String[] args) {

		// Input
		// Process
		soNgauNhien = phatSinhSoNgauNhien(0, 1000);
		// Output
		do {
			nhap();
			kiemTraSo();
		} while (soNguoiDungNhap != soNgauNhien);
	}

	public static int nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào 1 số trong khoảng 1-1000: ");
		soNguoiDungNhap = Integer.parseInt(scan.nextLine());
		return soNguoiDungNhap;
	}

	public static int phatSinhSoNgauNhien(int min, int max) {
		return (int) (min + Math.random() * max + 1);
	}

	public static void kiemTraSo() {
		if (soNguoiDungNhap == soNgauNhien) {
			System.out.println("Chuc mung! Bạn đã đoán trúng số bí mật.");
			dem++;
			System.out.println("Bạn đã đoán trúng số ở lần thứ " + dem);
		} else if (soNguoiDungNhap < soNgauNhien) {
			System.out.println("Sai! Số bạn vừa nhập nhỏ hơn số bí mật");
			dem++;
		} else {
			System.out.println("Sai! Số bạn vừa nhập lớn hơn số bí mật");
			dem++;
		}
	}
}
