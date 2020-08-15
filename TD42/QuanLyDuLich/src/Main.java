import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xuLyMenu();
	}

	public static void xuLyMenu() {
		Scanner scan = new Scanner(System.in);
		QuanLyChuyenXe quanLyChuyenXe = new QuanLyChuyenXe();
		boolean isExit = false;
		int chon;
		do {
			thongBao();
			System.out.println("Vui long chon chuc nang: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				// Nhap xe noi thanh
				ChuyenXe chuyenXeNoiThanh = new ChuyenXeNoiThanh();
				chuyenXeNoiThanh.nhap();
				chuyenXeNoiThanh.tinhDoanhThu();
				quanLyChuyenXe.themChuyenXe(chuyenXeNoiThanh);
				break;
			case 2:
				// Nhap xe ngoai thanh
				ChuyenXe chuyenXeNgoaiThanh = new ChuyenXeNgoaiThanh();
				chuyenXeNgoaiThanh.nhap();
				chuyenXeNgoaiThanh.tinhDoanhThu();
				quanLyChuyenXe.themChuyenXe(chuyenXeNgoaiThanh);
				break;
			case 3:
				// Tong doanh thu tung loai xe
				quanLyChuyenXe.xuatCacChuyenXe();
				break;
			case 4:
				// Tong doanh thu
				quanLyChuyenXe.tinhDoanhThuChuyenXeNoiThanh();
				quanLyChuyenXe.tinhDoanhThuChuyenXeNgoaiThanh();
				break;
			case 5:
				// Tong doanh thu
				quanLyChuyenXe.tinhTongDoanhThu();
				break;
			case 0:
				isExit = true;
				System.out.println("Da thoat chuong trinh");
				break;
			default:
				System.out.println("Vui long chon dung chuc nang!");
				break;
			}
		} while (!isExit);
	}

	public static void thongBao() {
		System.out.println("---------------------------QUAN LY NHA XE-------------------------------");
		System.out.println("1. Nhap cac chuyen xe noi thanh");
		System.out.println("2. Nhap cac chuyen xe ngoai thanh");
		System.out.println("3. Xuat danh sach cac chuyen xe");
		System.out.println("4. Xuat tong doanh thu cho tung loai xe");
		System.out.println("5. Xuat tong doanh thu");
		System.out.println("0. Thoat chuong trinh");

	}
}
