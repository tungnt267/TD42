package com.cybersoft.xuly;

import java.util.Scanner;

import com.cybersoft.quanlynhansu.CongTy;
import com.cybersoft.quanlynhansu.GiamDoc;
import com.cybersoft.quanlynhansu.NhanSu;
import com.cybersoft.quanlynhansu.NhanVien;
import com.cybersoft.quanlynhansu.TruongPhong;

public class XuLy {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		CongTy congTy = new CongTy("CyberSoft Group", "CG", "0286236876", 1_000_000_000);
		themDummyData(congTy); // <=== thêm trước dữ liệu để test

		congTy.xuatThongTin();
		System.out.println();

		int luaChon;

		do {
			luaChon = inMenu(scanner); // xuất menu quản lý nhân sự
			switch (luaChon) {
			case 1: // 1. Nhập thông tin công ty
				congTy.nhapThongTin();
				break;

			case 2: // 2. Phân bổ nhân viên vào trưởng phòng
				congTy.phanBoNhanVien(scanner);
				break;

			case 3: // 3. Thêm Nhân sự mới
				congTy.nhapNV(scanner);
				break;

			case 4: // 4. Xóa thông tin nhân sự công ty
				congTy.xoaNV(scanner);
				break;

			case 5: // 5. Sửa thông tin nhân sự công ty
				congTy.suaNV(scanner);
				break;

			case 6: // 6. Xem danh sách nhân sự của Công Ty
				congTy.xuatThongTin();
				break;

			case 7: // 7. Xem tổng lương của toàn công ty
				System.out.println("Tổng lương cả công ty là: " + congTy.tinhTongLuong());
				break;

			case 8: // 8. Xem trưởng phòng có lương cao nhất
				congTy.timTruongPhongLuongMax();
				break;

			case 9: // 9. Xem Nhân viên thường có lương cao nhất
				congTy.timNhanVienThuongLuongCaoNhat();
				break;

			case 10: // 10. Xem trưởng phòng có nhiều nhân viên dưới quyền nhất
				congTy.timTruongPhongCoNhanVienDuoiQuyenNhieuNhat();
				break;

			case 11: // 11. Sắp xếp nhân sự toàn công ty theo thứ tự abc
				congTy.sapXepTheoThuTuABC();
				break;

			case 12: // 12. Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần
				congTy.sapXepTheoLuongGiamDan();
				break;

			case 13: // 13. Xem giám đốc có số lượng cổ phần nhiều nhất
				congTy.timGiamDocCoPhanMax();
				break;

			case 14: // 14. Sửa lại doanh thu tháng của công ty
				congTy.suaDoanhThuThangCongTy(scanner);
				break;

			case 15: // 15. Xem tổng thu nhập của từng giám đốc
				congTy.xuatTongThuNhapTungGiamDoc();
				break;

			case 0: // 0. Thoát
				System.out.println("Kết thúc chương trình.");
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 15!");
				break;

			}
		} while (luaChon != 0);

	}

	static int inMenu(Scanner sc) {
		int spaceNum = 20;
		System.out.println(String.format("\t%" + spaceNum + "s", "") + "QUẢN LÝ NHÂN SỰ"
				+ String.format("%" + spaceNum + "s", ""));
		System.out.println("+============================== Menu ===============================+");
		System.out.println("|\t1.  Nhập thông tin công ty                                  |");
		System.out.println("|\t2.  Phân bổ nhân viên vào trưởng phòng                      |");
		System.out.println("|\t3.  Thêm Nhân sự mới                                        |");
		System.out.println("|\t4.  Xóa thông tin nhân sự công ty                           |");
		System.out.println("|\t5.  Sửa thông tin nhân sự công ty                           |");
		System.out.println("|\t6.  Xem danh sách nhân sự của Công Ty                       |");
		System.out.println("|\t7.  Xem tổng lương của toàn công ty                         |");
		System.out.println("|\t8.  Xem trưởng phòng có lương cao nhất                      |");
		System.out.println("|\t9.  Xem Nhân viên thường có lương cao nhất                  |");
		System.out.println("|\t10. Xem trưởng phòng có nhiều nhân viên dưới quyền nhất     |");
		System.out.println("|\t11. Sắp xếp nhân sự toàn công ty theo thứ tự abc            |");
		System.out.println("|\t12. Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần |");
		System.out.println("|\t13. Xem giám đốc có số lượng cổ phần nhiều nhất             |");
		System.out.println("|\t14. Sửa lại doanh thu tháng của công ty                     |");
		System.out.println("|\t15. Xem tổng thu nhập của từng giám đốc                     |");
		System.out.println("|\t0. Thoát                                                    |");
		System.out.println("+===================================================================+");
		System.out.print("Lựa chọn: ");
		return Integer.parseInt(sc.nextLine());
	}

	static void themDummyData(CongTy cty) {
		cty.themNhanSu(new NhanVien("", "Tuấn", "0369296613", 25, 100));
		cty.themNhanSu(new NhanVien("", "Lâm", "0369296614", 21, 100));
		cty.themNhanSu(new NhanVien("", "Trần", "0369296615", 26, 100));
		cty.themNhanSu(new NhanVien("", "Khang", "0369296213", 21, 100));
		cty.themNhanSu(new NhanVien("", "An", "0369296663", 20, 100));
		cty.themNhanSu(new NhanVien("", "Khánh", "0369766613", 22, 100));
		cty.themNhanSu(new NhanVien("", "Phong", "0369216614", 27, 100));
		cty.themNhanSu(new NhanVien("", "Thanh", "0369896619", 21, 100));
		cty.themNhanSu(new NhanVien("", "Chí", "0369200611", 29, 100));
		cty.themNhanSu(new NhanVien("", "Tuấn", "0369226777", 20, 100));
		cty.themNhanSu(new NhanVien("", "Trí", "0369296578", 19, 100));
		cty.themNhanSu(new NhanVien("", "Nguyên", "0369896634", 23, 100));
		cty.themNhanSu(new NhanVien("", "Mẫn", "0369200612", 29, 100));
		cty.themNhanSu(new NhanVien("", "Cường", "0369226698", 30, 100));
		cty.themNhanSu(new NhanVien("", "Nam", "0369296566", 31, 100));

		cty.themNhanSu(new TruongPhong("", "Lê", "0909001002", 25, 200, 0));
		cty.themNhanSu(new TruongPhong("", "Hoàng", "0909001003", 29, 200, 0));
		cty.themNhanSu(new TruongPhong("", "Tứ", "0909001004", 27, 200, 0));

		cty.themNhanSu(new GiamDoc("", "Vượng", "0900000001", 15, 300, 75));
		cty.themNhanSu(new GiamDoc("", "Oanh", "0900000009", 17, 300, 25));

	}
}
