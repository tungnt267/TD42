import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TruongHoc truong = new TruongHoc();
		truong.khoiTaoGiuLieu();
		thucHien(truong);
	}

	public static void thucHien(TruongHoc truong) {
		Scanner scan = new Scanner(System.in);
		int chon;
		boolean thoat = false;
		do {
			inMenu();
			System.out.print("\nVui lòng chọn chức năng: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				// Thêm người
				truong.nhap();
				break;
			case 2:
				// Giáo viên có thâm niên cao nhất
				System.out.print("\nGiáo viên có nhân viên cao nhất: ");
				truong.timGiaoVienThamNienMax().xuat();
				break;
			case 3:
				// Giáo viên có thâm niên > 5 năm và có chuyên môn thuộc khối tự nhiên
				System.out.print("\nGiáo viên có thâm niên > 5 năm và có chuyên môn thuộc khối tự nhiên: ");
				truong.timGV5TuNhien().xuat();
				break;
			case 4:
				// Điểm trung bình cao nhất
				System.out.print("\nĐiểm trung bình cao nhất: " + truong.timDTBMax());
				break;
			case 5:
				// Học sinh có điểm TB cao nhất
				System.out.print("\nHọc sinh có điểm trung bình cao nhất: ");
				truong.timHSCoDTBMax().xuat();
				break;
			case 6:
				// Học sinh có xếp loại yếu
				System.out.print("\nHọc sinh có xếp loại yếu: ");
				truong.timDanhSachHSYeu().xuat();
				break;
			case 0:
				thoat = true;
				System.out.print("Chương trình kết thúc.");
				break;
			default:
				System.out.println("Vui lòng chọn chức năng hợp lệ!");
				break;
			}
		} while (!thoat);

	}

	public static void inMenu() {
		System.out.println("\n---------------Menu---------------");
		System.out.println("1. Thêm người");
		System.out.println("2. Giáo viên có thâm niên cao nhất");
		System.out.println("3. Giáo viên có thâm niên > 5 năm và có chuyên môn thuộc khối tự nhiên");
		System.out.println("4. Điểm trung bình cao nhất");
		System.out.println("5. Học sinh có điểm trung bình cao nhất");
		System.out.println("6. Học sinh có xếp loại yếu");
		System.out.println("0. Thoát chương trình");
	}
}
