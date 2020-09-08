import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		CongTy cTy = new CongTy();
		cTy.khoiTaoDuLieu();
		cTy.phanBoNhanVien();
		cTy.capNhatSoLuongNV();
		cTy.xuat();

//		System.out.println("\nTổng lương toàn công ty là: " + cTy.tinhTongLuongToanCongTy());
//		System.out.print("\nNhân viên thường có lương cao nhất: ");
//		cTy.timNVThuongCoLuongMax().xuat();

		// Xóa trưởng phòng
//		boolean kqXoaTruongPhong = cTy.xoaTruongPhong();
//		if (kqXoaTruongPhong) {
//			System.out.println("Đã xóa trưởng phòng");
//			System.out.print("\nDanh sách nhân sự trong công ty sau khi xóa");
//			cTy.xuat();
//		} else {
//			System.out.println("Không tìm thấy mã trưởng phòng cần xóa");
//		}

//		Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
//		System.out.print("\nTrưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất là: ");
//		cTy.timTruongPhongNhieuNVNhat().xuat();

		// Sắp xếp nhân sự theo thứ tự abc
//		LinkedList<NhanSu> dsSapXepAbc = cTy.sapXepAbc();
//		cTy.xuat(dsSapXepAbc);
		
	}

}
