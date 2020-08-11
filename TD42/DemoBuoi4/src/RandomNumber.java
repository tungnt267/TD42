import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		String chon;
		Scanner scan = new Scanner(System.in);
		int soNguoiDungNhap;
		int soNgauNhien = phatSinhSoNgauNhien(0, 10);;
		do {
			soNguoiDungNhap = nhap();
			if (soNguoiDungNhap == soNgauNhien) {
				System.out.println("Chuc mung!");
			} else if (soNguoiDungNhap > soNgauNhien){
				System.out.println("Sai! Nhỏ hơn");
			} else {
				System.out.println("Sai! Lớn hơn");
			}
			System.out.println("Ban co muon tiep khong? nhan 'y' de tiep: ");
			chon = scan.nextLine();
		} while(chon.equalsIgnoreCase("y"));
	}
	
	public static int nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap 1 so trong khoang 1-10: ");
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static int phatSinhSoNgauNhien(int min, int max) {
		return (int) (min + Math.random() * max + 1);
	}
	
}
