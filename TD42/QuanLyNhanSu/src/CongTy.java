import java.util.LinkedList;
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
	private LinkedList<NhanSu> congTy; // chứa danh sách nhân sự trong công ty
	private String tenCongTy;
	private String maSoThue;
	private double doanhThu;

	// 2. Khởi tạo
	public CongTy() {
		this.congTy = new LinkedList<NhanSu>();
		this.tenCongTy = null;
		this.maSoThue = null;
		this.doanhThu = 0;
	}

	public CongTy(LinkedList<NhanSu> congTy, String tenCongTy, String maSoThue, double doanhThu) {
		this.congTy = congTy;
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThu = doanhThu;
	}

	// 3. get, set
	public LinkedList<NhanSu> getCongTy() {
		return congTy;
	}

	public void setCongTy(LinkedList<NhanSu> congTy) {
		this.congTy = congTy;
	}

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

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào tên công ty: ");
		this.tenCongTy = scan.nextLine();
		System.out.print("Vui lòng nhập vào mã số thuế: ");
		this.maSoThue = scan.nextLine();
		System.out.print("Vui lòng nhập doanh thu công ty: ");
		do {
			this.doanhThu = Double.parseDouble(scan.nextLine());
			if (this.doanhThu < 0) {
				System.out.print("Vui lòng nhập doanh thu không âm: ");
			}
		} while (this.doanhThu < 0);
	}

	public void xuat() {
		System.out.println("\nTên công ty: " + this.tenCongTy);
		System.out.println("Mã số thuế: " + this.maSoThue);
		System.out.println("Tổng doanh thu: " + this.doanhThu);
		header();
		int stt = 0;
		for (NhanSu ns : this.congTy) {
			stt++;
			ns.xuat(stt);
		}
	}

	public void header() {
		System.out.println(
				"\n-------------------------------------------------------------THÔNG TIN NHÂN SỰ--------------------------------------------------------------\n");
		System.out.print("STT \t|");
		System.out.print("Mã nhân sự \t|");
		System.out.print("Họ tên \t\t|");
		System.out.print("Số điện thoại \t|");
		System.out.print("Số ngày làm việc \t|");
		System.out.print("Chức vụ \t\t|");
		System.out.print("Mã TP quản lý \t|");
		System.out.print("Số NV dưới quyền \t|");
		System.out.print("Số cổ phần \t|");
		System.out.print("Lương tháng \t|");
		System.out.print("Tổng thu nhập");
		underline();
	}

	public void underline() {
		System.out.print(
				"\n----------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// 5. Nghiệp vụ
	// 1. Thêm một nhân sự
	public void themNhanSu() {
		Scanner scan = new Scanner(System.in);
		int chon;
		System.out.print("Vui lòng chọn loại nhân sự (1-Nhân viên thưởng, 2-Trưởng Phòng, 3-Giám Đốc): ");
		do {
			chon = Integer.parseInt(scan.nextLine());
			if (chon < 1 || chon > 3) {
				System.out.print("Vui lòng chọn 1 trong 3 loại nhân sự trên: ");
			}
		} while (chon < 1 || chon > 3);
		switch (chon) {
		case 1:
			NhanVienThuong nvt = new NhanVienThuong();
			nvt.nhap("nhân viên thường");
			this.congTy.add(nvt);
			break;
		case 2:
			TruongPhong tp = new TruongPhong();
			tp.nhap("Trưởng Phòng");
			this.congTy.add(tp);
			break;
		case 3:
			GiamDoc gd = new GiamDoc();
			gd.nhap("Giám Đốc");
			this.congTy.add(gd);
			break;
		default:
			break;
		}
	}

	// 2. Xóa một nhân sự
	public boolean xoaMotNhanSu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập vào mã nhân sự bạn muốn xóa: ");
		String maCanXoa = scan.nextLine();
		NhanSu ns = new NhanSu();
		ns = timNhanSuTheoMa(maCanXoa);
		if (ns.getMaSo() != null) {
			this.congTy.remove(ns);
			return true;
		}
		return false;

//		char chon;
//		int stt = 0;
//		for (NhanSu ns : this.congTy) {
//			if ( == maSV) {
//				stt++;
//				System.out.println("Ban co chac chan muon xoa? Chon 'N' hoac 'N'");
//				chon = scan.nextLine().charAt(0);
//				switch (chon) {
//				case 'Y':
//					this.danhSachSinhVien.remove(sv);
//					System.out.println("Ban da xoa SV co ma: " + maSV);
//					break;
//				case 'N':
//					break;
//				default:
//					break;
//				}
//			}
//		}
//		if (stt == 0) {
//			header();
//			System.out.println("\t\t\t Khong tim thay SV de xoa!");
//		}
	}

	// Tìm nhân sự theo mã
	public NhanSu timNhanSuTheoMa(String maNS) {
		NhanSu ketQua = null;
		for (NhanSu ns : this.congTy) {
			if (ns.getMaSo().equalsIgnoreCase(maNS)) {
				ketQua = ns;
				break;
			}
		}
		return ketQua;
	}

	public void khoiTao() {
		NhanVienThuong nvt1 = new NhanVienThuong("123", "nguyen Van A", "0123456789", 12, 1000000, "");
		NhanVienThuong nvt2 = new NhanVienThuong("1ab", "Nguyen Thi B", "0123456888", 15, 2000000, "abc");
		TruongPhong tp1 = new TruongPhong("4ts", "Nguyen Van C", "0123456666", 20, 5000000, 10);
		TruongPhong tp2 = new TruongPhong("5s", "Nguyen Thi D", "0123456555", 26, 8000000, 20);
		GiamDoc gd1 = new GiamDoc("789", "Nguyen Van E", "0123456555", 14, 5000000, 10.5f);
		GiamDoc gd2 = new GiamDoc("sas", "Nguyen Thi F", "0123456567", 16, 6000000, 20.5f);
		GiamDoc gd3 = new GiamDoc("001", "Nguyen Van G", "0123456987", 28, 9000000, 25.6f);

		this.congTy.add(nvt1);
		this.congTy.add(nvt2);
		this.congTy.add(tp1);
		this.congTy.add(tp2);
		this.congTy.add(gd1);
		this.congTy.add(gd2);
		this.congTy.add(gd3);
	}
}
