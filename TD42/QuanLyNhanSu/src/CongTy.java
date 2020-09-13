import java.util.Scanner;

/**
 * Lớp đối tượng công ty
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 28-08-2020
 */
public class CongTy {
	// 1. Thuộc tính
	private String tenCongTy;
	private String maSoThue;
	private float doanhThuThang;
	DanhSachNhanSu objectDSNS;

	// 2. Khởi tạo
	public CongTy() {
		this.tenCongTy = null;
		this.maSoThue = null;
		this.doanhThuThang = 0;
		objectDSNS = new DanhSachNhanSu();
	}

	public CongTy(String tenCongTy, String maSoThue, float doanhThuThang, DanhSachNhanSu objectDSNS) {
		super();
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
		this.objectDSNS = objectDSNS;
	}

	// 3. get, set
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public float getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(float doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	public DanhSachNhanSu getObjectDSNS() {
		return objectDSNS;
	}

	public void setObjectDSNS(DanhSachNhanSu objectDSNS) {
		this.objectDSNS = objectDSNS;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào tên công ty: ");
		this.tenCongTy = scan.nextLine();
		System.out.print("Vui lòng nhập vào mã số thuế: ");
		this.maSoThue = scan.nextLine();
		System.out.print("Vui lòng nhập doanh thu tháng của công ty: ");
		do {
			this.doanhThuThang = Float.parseFloat(scan.nextLine());
			if (this.doanhThuThang < 0) {
				System.out.print("Vui lòng nhập doanh thu không âm: ");
			}
		} while (this.doanhThuThang < 0);
	}

	public void xuat() {
		System.out.println("\n--------------------THÔNG TIN CÔNG TY--------------------");
		System.out.println("Tên công ty: " + this.tenCongTy);
		System.out.println("Mã số thuế: " + this.maSoThue);
		System.out.println("Doanh thu tháng: " + this.doanhThuThang);
	}

	public void thucHien() {
		this.objectDSNS.capNhatSoLuongNV();
		this.tinhTongThuNhapTungGD();
		Scanner scan = new Scanner(System.in);
		int chon;
		boolean thoat = false;
		do {
			this.inMenu();
			System.out.print("\nVui lòng chọn chức năng: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				this.nhap();
				this.xuat();
				this.tinhTongThuNhapTungGD();
				break;
			case 2:
				this.objectDSNS.phanBoNhanVienThuong();
				this.objectDSNS.capNhatSoLuongNV();
				break;
			case 3:
				this.objectDSNS.themNhanSu();
				break;
			case 4:
				this.objectDSNS.xoaNhanSu();
				break;
			case 5:
				header("DANH SÁCH NHÂN SỰ ");
				this.objectDSNS.xuat();
				underline();
				break;
			case 6:
				System.out.println("\nTổng lương tháng toàn công ty là: " + this.objectDSNS.tinhTongLuong());
				break;
			case 7:
				header("NHÂN VIÊN THƯỜNG CÓ LƯƠNG CAO NHẤT");
				this.objectDSNS.timNhanVienThuongLuongMax().xuat();
				underline();
				break;
			case 8:
				header("TRƯỞNG PHÒNG CÓ SỐ NHÂN VIÊN DƯỚI QUYỀN NHIỀU NHẤT");
				this.objectDSNS.timTPCoNhieuNVDQNhat().xuat();
				underline();
				break;
			case 9:
				header("DANH SÁCH NHÂN SỰ ĐÃ SẮP XẾP TÊN THEO THỨ TỰ ABC");
				this.objectDSNS.sapXepTenTheoAbc().xuat();
				underline();
				break;
			case 10:
				header("DANH SÁCH NHÂN SỰ ĐÃ SẮP XẾP LƯƠNG THÁNG THEO THỨ TỰ GIẢM DẦN ");
				this.objectDSNS.sapXepLuongGiamDan().xuat();
				underline();
				break;
			case 11:
				header("GIÁM ĐỐC CÓ SỐ LƯỢNG CỔ PHẦN NHIỀU NHẤT ");
				this.objectDSNS.timGiamDocCoPhanMax().xuat();
				underline();
				break;
			case 12:
				this.tinhTongThuNhapTungGD();
				header("TỔNG THU NHẬP CỦA TỪNG GIÁM ĐỐC ");
				this.xuatTongThuNhapGD().xuat();
				underline();
				break;
			case 0:
				System.out.println("Chương trình đã kết thúc!");
				thoat = true;
				break;
			default:
				System.out.print("Vui lòng chọn chức năng hợp lệ trong khoảng 0-12!");
				break;
			}
		} while (!thoat);
	}

	public void inMenu() {
		System.out.println("\n\n+------------------------------------------------------------------------+");
		System.out.println("|                           MENU QUẢN LÝ NHÂN SỰ                         |");
		System.out.println("|        1. Nhập thông tin công ty                                       |");
		System.out.println("|        2. Phân bổ nhân viên thường vào trưởng phòng                    |");
		System.out.println("|        3. Thêm một nhân sự                                             |");
		System.out.println("|        4. Xóa một nhân sự                                              |");
		System.out.println("|        5. Xuất danh sách nhân sự                                       |");
		System.out.println("|        6. Xuất tổng lương toàn công ty                                 |");
		System.out.println("|        7. Nhân viên thường có lương cao nhất                           |");
		System.out.println("|        8. Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất     |");
		System.out.println("|        9. Sắp xếp nhân sự toàn công ty theo thứ tự abc (từ họ đến tên) |");
		System.out.println("|        10. Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần     |");
		System.out.println("|        11. Giám Đốc có số lượng cổ phần nhiều nhất                     |");
		System.out.println("|        12. Xuất tổng thu nhập của từng Giám Đốc                        |");
		System.out.println("|    (*) 0. Thoát chương trình                                           |");
		System.out.println("+------------------------------------------------------------------------+");
	}

	public void header(String tieuDe) {
		tieuDe = String.format("%-" + ((171 - tieuDe.length()) / 2) + "s", "").replace(' ', '-') + tieuDe
				+ String.format("%-" + ((171 - tieuDe.length()) / 2) + "s", "").replace(' ', '-');
		System.out.println("\n" + tieuDe + "\n");
		System.out.print(String.format("%-4s", "STT") + "|");
		System.out.print(String.format("%-6s", "Mã số") + "|");
		System.out.print(String.format("%-21s", "Họ tên") + "|");
		System.out.print(String.format("%-14s", "Số điện thoại") + "|");
		System.out.print(String.format("%-17s", "Số ngày làm việc") + "|");
		System.out.print(String.format("%-15s", "Lương một ngày") + "|");
		System.out.print(String.format("%-13s", "Chức vụ") + "|");
		System.out.print(String.format("%-14s", "Mã TP quản lý") + "|");
		System.out.print(String.format("%-17s", "Số NV dưới quyền") + "|");
		System.out.print(String.format("%-11s", "Số cổ phần") + "|");
		System.out.print(String.format("%-12s", "Lương tháng") + "|");
		System.out.print(String.format("%-14s", "Tổng thu nhập") + "|");
		underline();
	}

	public void underline() {
		System.out.print(
				"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// 5. Nghiệp vụ
	// Tạo dữ liệu gỉả để test
	public void taoDuLieuGia() {
		NhanSu giamDoc1 = new GiamDoc("gd1", "Giám Đốc Tính", "123456789", 22, 12.5f);
		NhanSu giamDoc2 = new GiamDoc("gd2", "Giám Đốc Long", "987654321", 24, 9.5f);
		NhanSu giamDoc3 = new GiamDoc("gd3", "Giám Đốc Song", "999999999", 26, 12.5f);

		NhanSu truongPhong1 = new TruongPhong("tp1", "Trưởng Phòng Bảo", "11223344", 25);
		NhanSu truongPhong2 = new TruongPhong("tp2", "Trưởng Phòng Trung", "11112222", 26);
		NhanSu truongPhong3 = new TruongPhong("tp3", "Trưởng Phòng Hà", "33334444", 24);
		NhanSu truongPhong4 = new TruongPhong("tp4", "Trưởng Phòng Tú", "55556666", 23);

		NhanSu nhanVien1 = new NhanVienThuong("nv1", "Nhân Viên Nam", "xxxxxxxxx", 24, "tp1");
		NhanSu nhanVien2 = new NhanVienThuong("nv2", "Nhân Viên Hoàng", "yyyyyyyyy", 21, "tp1");
		NhanSu nhanVien3 = new NhanVienThuong("nv3", "Nhân Viên An", "zzzzzzzzz", 22, "tp2");
		NhanSu nhanVien4 = new NhanVienThuong("nv4", "Nhân Viên Ánh", "aaaaaaaaa", 23, "tp1");
		NhanSu nhanVien5 = new NhanVienThuong("nv5", "Nhân Viên Thảo", "bbbbbbbbb", 20, "tp3");
		NhanSu nhanVien6 = new NhanVienThuong("nv6", "Nhân Viên Dũng", "eeeeeeeee", 24, "tp3");

		this.objectDSNS.getDsNhanSu().add(giamDoc1);
		this.objectDSNS.getDsNhanSu().add(giamDoc2);
		this.objectDSNS.getDsNhanSu().add(giamDoc3);

		this.objectDSNS.getDsNhanSu().add(truongPhong1);
		this.objectDSNS.getDsNhanSu().add(truongPhong2);
		this.objectDSNS.getDsNhanSu().add(truongPhong3);
		this.objectDSNS.getDsNhanSu().add(truongPhong4);

		this.objectDSNS.getDsNhanSu().add(nhanVien1);
		this.objectDSNS.getDsNhanSu().add(nhanVien2);
		this.objectDSNS.getDsNhanSu().add(nhanVien3);
		this.objectDSNS.getDsNhanSu().add(nhanVien4);
		this.objectDSNS.getDsNhanSu().add(nhanVien5);
		this.objectDSNS.getDsNhanSu().add(nhanVien6);

		// Khởi tạo dữ liệu doanh thu tháng => test
		this.setDoanhThuThang(100000);
	}

	// Tính tổng thu nhập của từng Giám Đốc
	public void tinhTongThuNhapTungGD() {
		// Tính lợi nhuận công ty
		float loiNhuanCTy = this.doanhThuThang - this.objectDSNS.tinhTongLuong();

		// Tính thu nhập của Giám Đốc
		for (NhanSu gd : this.objectDSNS.getDsNhanSu()) {
			if (gd instanceof GiamDoc) {
				float tongThuNhapGD = gd.tinhLuong() + loiNhuanCTy * ((GiamDoc) gd).getSoCoPhan() / 100;
				((GiamDoc) gd).setTongThuNhap(tongThuNhapGD);
			}
		}
	}

	// Xuất tổng thu nhập từng giám đốc
	public DanhSachNhanSu xuatTongThuNhapGD() {
		DanhSachNhanSu dsKetQuaGD = new DanhSachNhanSu();
		for (NhanSu gd : this.objectDSNS.getDsNhanSu()) {
			if (gd instanceof GiamDoc) {
				dsKetQuaGD.getDsNhanSu().add(gd);
			}
		}
		return dsKetQuaGD;
	}
}
