import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class TruongHoc {
	// 1. Thuộc tính
	private LinkedList<Nguoi> dsNguoi;

	// 2. Khởi tạo
	public TruongHoc() {
		this.dsNguoi = new LinkedList<Nguoi>();
	}

	public TruongHoc(LinkedList<Nguoi> dsNguoi) {
		this.dsNguoi = dsNguoi;
	}

	// 3. get, set
	public LinkedList<Nguoi> getDsNguoi() {
		return dsNguoi;
	}

	public void setDsNguoi(LinkedList<Nguoi> dsNguoi) {
		this.dsNguoi = dsNguoi;
	}

	// 4. Nhập, xuất
	public void khoiTaoGiuLieu() {
		Nguoi gv1 = new GiaoVien("Le Van A", 1980, "Hà Nội", "Hà Nội", 2005, "Tự nhiên");
		Nguoi gv2 = new GiaoVien("Nguyen Van C", 1975, "Hà Nội", "Hà Nội", 2002, "Xã hội");
		Nguoi gv3 = new GiaoVien("Nguyen Van B", 1976, "Sài Gòn", "Sài Gòn", 2006, "Xã hội");
		Nguoi gv4 = new GiaoVien("Cao Van D", 1978, "Sài Gòn", "Sài Gòn", 2002, "Tự nhiên");
		Nguoi gv5 = new GiaoVien("Nguyen Thi H", 1992, "Sài Gòn", "Sài Gòn", 2016, "Tự nhiên");
		Nguoi hs1 = new HocSinh("Nguyen Van E", 2006, "Sài Gòn", "Sài Gòn", 8.5f, 7.5f, 9.0f);
		Nguoi hs4 = new HocSinh("Tran Van K", 2006, "Hà Nội", "Hà Nội", 8.5f, 7.5f, 9.0f);
		Nguoi hs2 = new HocSinh("Dang Van F", 2007, "Hà Nội", "Hà Nội", 8.0f, 6.5f, 8.0f);
		Nguoi hs3 = new HocSinh("Hoang Van G", 2008, "Hà Nội", "Sài Gòn", 9.5f, 7.0f, 8.0f);
		Nguoi hs5 = new HocSinh("Dao Van P", 2008, "Sài Gòn", "Hà Nội", 3.5f, 3.0f, 4.0f);
		Nguoi hs6 = new HocSinh("Ly Van Q", 2008, "Sài Gòn", "Sài Gòn", 2.5f, 4.0f, 3.5f);

		this.dsNguoi.add(gv1);
		this.dsNguoi.add(gv2);
		this.dsNguoi.add(gv3);
		this.dsNguoi.add(gv4);
		this.dsNguoi.add(gv5);
		this.dsNguoi.add(hs1);
		this.dsNguoi.add(hs2);
		this.dsNguoi.add(hs3);
		this.dsNguoi.add(hs4);
		this.dsNguoi.add(hs5);
		this.dsNguoi.add(hs6);
	}

	public void nhap() {
		Scanner scan = new Scanner(System.in);
		String chontiepTuc = null;
		do {
			String loai = null;
			System.out.print("\ngv: Nhập thông tin giáo viên - hs: Nhập thông tin học sinh: ");
			System.out.print("\nvui lòng nhập loại cần nhập: ");
			loai = scan.nextLine();

			Nguoi nguoi = new Nguoi();
			if (loai.equalsIgnoreCase("gv")) {
				nguoi = new GiaoVien();
			} else if (loai.equalsIgnoreCase("hs")) {
				nguoi = new HocSinh();
			}
			nguoi.nhap();
			this.dsNguoi.add(nguoi);

			System.out.print("Bạn có muốn nhập tiếp không? Nhấn 'y' để tiếp: ");
			chontiepTuc = scan.nextLine();
		} while (chontiepTuc.equalsIgnoreCase("y"));
	}

	public void xuat() {
		for (Nguoi nguoi : this.dsNguoi) {
			nguoi.xuat();
		}
	}

	// 5. Nghiệp vụ

	// Tìm thâm niên cao nhất trong các giáo viên
	public int timThamNienMax() {
		int thamNienMax = 0;
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof GiaoVien) {
				if (((GiaoVien) nguoi).tinhThamNien() > thamNienMax) {
					thamNienMax = ((GiaoVien) nguoi).tinhThamNien();
				}
			}
		}
		return thamNienMax;
	}

	// Tìm giáo viên có thâm niên cao nhất
	public TruongHoc timGiaoVienThamNienMax() {
		TruongHoc dsKetQua = new TruongHoc();
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof GiaoVien) {
				if (((GiaoVien) nguoi).tinhThamNien() == this.timThamNienMax()) {
					dsKetQua.getDsNguoi().add(nguoi);
				}
			}
		}
		return dsKetQua;
	}

	// Tìm giáo viên có thâm niên > 5 và có chuyên môn khối tự nh thuộc
	public TruongHoc timGV5TuNhien() {
		TruongHoc dsKetQua = new TruongHoc();
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof GiaoVien) {
				if (((GiaoVien) nguoi).tinhThamNien() > 5
						&& ((GiaoVien) nguoi).getChuyenMon().equalsIgnoreCase("tự nhiên")) {
					dsKetQua.getDsNguoi().add(nguoi);
				}
			}
		}
		return dsKetQua;
	}

	// Tìm điểm TB cao nhất
	public float timDTBMax() {
		float diemTBMax = 0;
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof HocSinh) {
				if (((HocSinh) nguoi).tinhDiemTB() > diemTBMax) {
					diemTBMax = ((HocSinh) nguoi).tinhDiemTB();
				}
			}
		}
		return diemTBMax;
	}

	// Tìm học sinh có DTB cao nhất
	public TruongHoc timHSCoDTBMax() {
		TruongHoc dsKetQua = new TruongHoc();
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof HocSinh) {
				if (((HocSinh) nguoi).tinhDiemTB() == this.timDTBMax()) {
					dsKetQua.getDsNguoi().add(nguoi);
				}
			}
		}
		return dsKetQua;
	}

	// Tìm danh sách học sinh xếp loại yếu
	public TruongHoc timDanhSachHSYeu() {
		TruongHoc dsKetQua = new TruongHoc();
		for (Nguoi nguoi : this.dsNguoi) {
			if (nguoi instanceof HocSinh) {
				if (((HocSinh) nguoi).xepLoai().equalsIgnoreCase("yếu")) {
					dsKetQua.getDsNguoi().add(nguoi);
				}
			}
		}
		return dsKetQua;
	}
}
