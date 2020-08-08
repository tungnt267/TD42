import java.util.Scanner;

public class Bai8DemSoChanLe {

	public static void main(String[] args) {
//		Input
		int a = nhap(1);
		int b = nhap(2);
		int c = nhap(3);

//		Process
//		Output
		demSo(a, b, c);

	}

	public static int nhap(int i) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số thứ " + i + " : ");
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static void demSo(int a, int b, int c) {
		int soLe = 0, soChan = 0;

		if (a % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}

		if (b % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}

		if (c % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}

		System.out.println("Có " + soChan + " số chẵn và " + soLe + " số lẻ.");
	}
}
