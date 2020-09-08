import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ThuVien thuVien = new ThuVien();
		thuVien.khoiTaoDuLieu();
		thucHien(thuVien);
	}

	public static void inMenu() {
		System.out.println("\n\n1. Thêm một sách");
		System.out.println("2. Xuất danh sách các loại sách");
		System.out.println("3. Tổng thành tiền cho từng loại sách");
		System.out.println("4. Trung bình cộng đơn giá các sách tham khảo");
		System.out.println("5. Xuất ra các sách giáo khoa của nhà xuất bản X");
		System.out.println("0. Thoát chương trình");
	}

	public static void thucHien(ThuVien thuVien) {
		Scanner scan = new Scanner(System.in);
		int chon;
		boolean thoat = false;
		do {
			inMenu();
			System.out.print("\nVui lòng chọn chức năng: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				thuVien.themSach();
				System.out.print("\nThêm sách thành công!");
				break;
			case 2:
				thuVien.xuat();
				break;
			case 3:
				System.out.println("Tổng thành tiền từng loại sách: ");
				System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tinhTongTienSachGiaoKhoa());
				System.out.println("Tổng thành tiền sách tham khảo: " + thuVien.tinhTongTienSachThamKhao());
				System.out.println("Tổng thành tiền tất cả sách: "
						+ (thuVien.tinhTongTienSachGiaoKhoa() + thuVien.tinhTongTienSachThamKhao()));
				break;
			case 4:
				if (thuVien.tinhTBCongDonGiaSTK() == -1) {
					System.out.println("Không có sách tham khảo nào trong danh sách!");
				} else {
					System.out.println("Trung bình cộng đơn giá các sách tham khảo: " + thuVien.tinhTBCongDonGiaSTK());
				}
				break;
			case 5:
				if (thuVien.timSGKNhaXuatBanX() == null) {
					System.out.println("Không có sách giáo khoa nào của nhã xuất bản X trong danh sách!");
				} else {
					System.out.print("\nDanh sách sách giáo khoa của nhà xuất bản X: ");
					thuVien.timSGKNhaXuatBanX().xuat();
				}
				break;
			case 6:

				break;
			case 0:
				thoat = true;
				System.out.println("Đã thoát chương trình!");
				break;
			default:
				System.out.println("Vui lòng chọn chức năng hợp lệ!");
				break;
			}
		} while (!thoat);
	}
}
