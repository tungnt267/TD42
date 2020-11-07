import java.util.Scanner;

public class Bai3CachDocSo {

	public static int soHangTram, soHangChuc, soHangDonVi;

	public static void main(String[] args) {
		// Đầu vào
		int n = nhap();

		// Xử lý
		layThanhPhanSo(n);
		String hangTram = inHangTram(soHangTram);
		String hangChuc = inHangChuc(soHangChuc);
		String hangDonVi = inHangDV(soHangDonVi);

		// Đầu ra
		xuat("Cách đọc số trên là: ", hangTram + hangChuc + hangDonVi);
	}

	public static int nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào số có 3 chữ số: ");
		int x = Integer.parseInt(scan.nextLine());
		return x;
	}

	public static void layThanhPhanSo(int x) {
		soHangTram = x / 100;
		soHangChuc = (x % 100) / 10;
		soHangDonVi = x % 10;
	}

	public static void xuat(String thongBao, String ketQua) {
		System.out.println(thongBao + ketQua);
	}

	public static String inHangTram(int x) {
		String ketQua = "";
		switch (x) {
		case 0:
			ketQua = "";
			break;
		case 1:
			ketQua = "Một trăm ";
			break;
		case 2:
			ketQua = "Hai trăm ";
			break;
		case 3:
			ketQua = "Ba trăm ";
			break;
		case 4:
			ketQua = "Bốn trăm ";
			break;
		case 5:
			ketQua = "Năm trăm ";
			break;
		case 6:
			ketQua = "Sáu trăm ";
			break;
		case 7:
			ketQua = "Bảy trăm ";
			break;
		case 8:
			ketQua = "Tám trăm ";
			break;
		case 9:
			ketQua = "Chín trăm ";
			break;
		default:
			ketQua = "";
			break;
		}
		return ketQua;
	}

	public static String inHangChuc(int x) {
		String ketQua = "";
		switch (x) {
		case 0:
			if (soHangDonVi == 0) {
				ketQua = "";
			} else {
				ketQua = "linh ";
			}
			break;
		case 1:
			ketQua = "mười ";
			break;
		case 2:
			ketQua = "hai mươi ";
			break;
		case 3:
			ketQua = "ba mươi ";
			break;
		case 4:
			ketQua = "bốn mươi ";
			break;
		case 5:
			ketQua = "năm mươi ";
			break;
		case 6:
			ketQua = "sáu mươi ";
			break;
		case 7:
			ketQua = "bảy mươi ";
			break;
		case 8:
			ketQua = "tám mươi ";
			break;
		case 9:
			ketQua = "chín mươi ";
			break;
		default:
			ketQua = "";
			break;
		}
		return ketQua;
	}

	public static String inHangDV(int x) {
		String ketQua = "";
		switch (x) {
		case 0:
			ketQua = "";
			break;
		case 1:
			if (soHangChuc == 0 || soHangChuc == 1) {
				ketQua = "một";
			} else {
				ketQua = "mốt";
			}
			break;
		case 2:
			ketQua = "hai";
			break;
		case 3:
			ketQua = "ba";
			break;
		case 4:
			ketQua = "bốn";
			break;
		case 5:
			if (soHangChuc == 0) {
				ketQua = "năm";
			} else {
				ketQua = "lăm";
			}
			break;
		case 6:
			ketQua = "sáu";
			break;
		case 7:
			ketQua = "bảy";
			break;
		case 8:
			ketQua = "tám";
			break;
		case 9:
			ketQua = "chín";
			break;
		default:
			ketQua = "";
			break;
		}
		return ketQua;
	}

}
