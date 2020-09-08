import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class CongTy {
	// 1. Thuoc tinh
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;
	private LinkedList<NhanSu> dsNhanSu;

	// 2. Khoi tao
	public CongTy() {
		this.tenCongTy = null;
		this.maSoThue = null;
		this.doanhThuThang = 0;
		this.dsNhanSu = new LinkedList<NhanSu>();
	}

	public CongTy(String tenCongTy, String maSoThue, double doanhThuThang, LinkedList<NhanSu> dsNhanSu) {
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
		this.dsNhanSu = dsNhanSu;
	}

	// 3. get, set
	public LinkedList<NhanSu> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDsNhanSu(LinkedList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}

	// 4. Nhap, xuat
	public void nhap() {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Vui lòng nhập tên công ty: ");
//		this.tenCongTy = scan.nextLine();
//		System.out.print("Vui lòng nhập mã số thuế: ");
//		this.maSoThue = scan.nextLine();
//		System.out.print("Vui lòng nhập doanh thu tháng: ");
//		this.doanhThuThang = Double.parseDouble(scan.nextLine());
	}

	public void khoiTaoDuLieu() {
		NhanSu giamDoc1 = new GiamDoc("gd1", "Giam Doc Tính", "123456789", 26, 12);
		NhanSu giamDoc2 = new GiamDoc("gd2", "Giam Doc Long", "987654321", 27, 15);

		NhanSu truongPhong1 = new TruongPhong("tp1", "Truong Phong Đức", "11223344", 25);
		NhanSu truongPhong2 = new TruongPhong("tp2", "Truong Phong Trung", "11112222", 26);
		NhanSu truongPhong3 = new TruongPhong("tp3", "Truong Phong Hà", "33334444", 24);
		NhanSu truongPhong4 = new TruongPhong("tp4", "Truong Phong Tú", "55556666", 23);

		NhanSu nhanVien1 = new NhanVien("nv1", "Nhan Vien Nam", "xxxxxxxxx", 24, "tp1");
		NhanSu nhanVien2 = new NhanVien("nv2", "Nhan Vien Hoàng", "yyyyyyyyy", 21, "tp2");
		NhanSu nhanVien3 = new NhanVien("nv3", "Nhan Vien An", "zzzzzzzzz", 22, null);
		NhanSu nhanVien4 = new NhanVien("nv4", "Nhan Vien Ánh", "aaaaaaaaa", 23, null);
		NhanSu nhanVien5 = new NhanVien("nv5", "Nhan Vien Dũng", "bbbbbbbbb", 24, null);

		this.dsNhanSu.add(giamDoc1);
		this.dsNhanSu.add(giamDoc2);

		this.dsNhanSu.add(truongPhong1);
		this.dsNhanSu.add(truongPhong2);
		this.dsNhanSu.add(truongPhong3);
		this.dsNhanSu.add(truongPhong4);

		this.dsNhanSu.add(nhanVien1);
		this.dsNhanSu.add(nhanVien2);
		this.dsNhanSu.add(nhanVien3);
		this.dsNhanSu.add(nhanVien4);
		this.dsNhanSu.add(nhanVien5);

//		this.capNhatSoLuongNV();
	}

	public void xuat() {
		for (NhanSu nhanSu : this.dsNhanSu) {
			nhanSu.xuat();
		}
	}

	public void xuat(LinkedList<NhanSu> ds) {
		for (NhanSu nhanSu : ds) {
			nhanSu.xuat();
		}
	}

	// 5. Nghiep vu
	// Tính tổng lương cho toàn công ty
	public float tinhTongLuongToanCongTy() {
		float tongLuong = 0;
		for (NhanSu nhanSu : this.dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		return tongLuong;
	}

	// Tìm Nhân viên thường có lương cao nhất
	public CongTy timNVThuongCoLuongMax() {
		// B1:
		float luongMaxNVT = 0;
		for (NhanSu nhanSu : this.dsNhanSu) {
			if (nhanSu instanceof NhanVien) {
				if (nhanSu.tinhLuong() > luongMaxNVT) {
					luongMaxNVT = nhanSu.tinhLuong();
				}
			}
		}

		// B2:
		CongTy dsKetQua = new CongTy();
		for (NhanSu nhanSu : this.dsNhanSu) {
			if (nhanSu instanceof NhanVien) {
				if (nhanSu.tinhLuong() == luongMaxNVT) {
					dsKetQua.getDsNhanSu().add(nhanSu);
				}
			}
		}
		return dsKetQua;
	}

	// Cập nhật số lượng nhân viên của từng Trưởng Phòng
	public void capNhatSoLuongNV() {
		for (NhanSu nv : this.dsNhanSu) {
			if (nv instanceof NhanVien) {
				for (NhanSu tp : this.dsNhanSu) {
					if (tp instanceof TruongPhong) {
						if (((NhanVien) nv).getMaTruongPhong() != null) {
							if (tp.getMaSo().equalsIgnoreCase(((NhanVien) nv).getMaTruongPhong())) {
								((TruongPhong) tp).setSoNhanVien(((TruongPhong) tp).getSoNhanVien() + 1);
							}
						}
					}
				}
			}
		}
	}

	// Xóa trưởng phòng
	public boolean xoaTruongPhong() {
		boolean ketQua = false;
		// B1: Nhập mã trưởng phòng cần xóa
		Scanner scan = new Scanner(System.in);
		System.out.print("\nVui lòng nhập mã trưởng phòng cần xóa: ");
		String maTpCanXoa = scan.nextLine();

		// B2: Duyệt dsns, tìm mã tp cần xóa
		// B2.1: Nếu tìm thấy thì xóa vào thoát khỏi vòng lặp
		// Cách 1:
		TruongPhong tp = new TruongPhong();
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof TruongPhong) {
				if (ns.getMaSo().equalsIgnoreCase(maTpCanXoa)) {
					tp = (TruongPhong) ns;
					ketQua = true;
					break;
				}
			}
		}
		if (ketQua) {
			this.dsNhanSu.remove(tp);
			// B3: Cập nhật mã tp của từng nv
			// B3.1: Tìm nv có mã tp bằng với mã tp cần xóa
			// B3.2 Tiền hành cập nhật lai mã tp đó là null
			for (NhanSu nhanSu : dsNhanSu) {
				if (nhanSu instanceof NhanVien) {
					if (((NhanVien) nhanSu).getMaTruongPhong().equalsIgnoreCase(maTpCanXoa)) {
						((NhanVien) nhanSu).setMaTruongPhong(null);
					}
				}
			}
		}
		// Cách 2:
//		int viTri = -1;
//		for (int i = 0; i < this.dsNhanSu.size(); i++) {
//			if (this.dsNhanSu.get(i) instanceof TruongPhong) {
//				if (this.dsNhanSu.get(i).getMaSo().equalsIgnoreCase(maTpCanXoa)) {
//					viTri = i;
//					break;
//				}
//			}
//		}
//		if (ketQua) {
//			this.dsNhanSu.remove(viTri);
//		}
		return ketQua;
	}

	// Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
	public CongTy timTruongPhongNhieuNVNhat() {
		// B1:
		int soNhanVienMax = 0;
		for (NhanSu nhanSu : this.dsNhanSu) {
			if (nhanSu instanceof TruongPhong) {
				if (((TruongPhong) nhanSu).getSoNhanVien() > soNhanVienMax) {
					soNhanVienMax = ((TruongPhong) nhanSu).getSoNhanVien();
				}
			}
		}

		// B2:
		CongTy dsKetQua = new CongTy();
		for (NhanSu nhanSu : this.dsNhanSu) {
			if (nhanSu instanceof TruongPhong) {
				if (((TruongPhong) nhanSu).getSoNhanVien() == soNhanVienMax) {
					dsKetQua.getDsNhanSu().add(nhanSu);
				}
			}
		}
		return dsKetQua;
	}

	// Sắp xếp họ tên nhân sự theo thứ tự abc
	public LinkedList<NhanSu> sapXepAbc() {
		LinkedList<NhanSu> dsKetQua = new LinkedList<NhanSu>();
		dsKetQua = this.dsNhanSu;
		for (int i = 0; i < this.dsNhanSu.size() - 1; i++) {
			for (int j = i + 1; j < this.dsNhanSu.size(); j++) {
				if (dsKetQua.get(i).tachLayTen().compareToIgnoreCase(dsKetQua.get(j).tachLayTen()) > 0) {
					NhanSu nsTemp = dsKetQua.get(i);
					dsKetQua.set(i, dsKetQua.get(j));
					dsKetQua.set(j, nsTemp);
				}
			}
		}
		return dsKetQua;
	}

	// Phân bổ nhân viên vào Trưởng Phòng
	public void phanBoNhanVien() {
		// B1: Duyệt hết tất cả nv
		for (NhanSu nv : this.dsNhanSu) {
			if (nv instanceof NhanVien) {
				// B2: Cho người dùng chọn trưởng phòng của từng nhân viên
				Scanner scan = new Scanner(System.in);
				System.out.print("\nVui lòng nhập mã trưởng phòng: ");
				String maTruongPhong = scan.nextLine();
				if (kiemTraMaTP(maTruongPhong)) {
					// B3: Cập nhật lại mã tp của từng nv đó
					((NhanVien) nv).setMaTruongPhong(maTruongPhong);
				}
			}
		}
	}

	public boolean kiemTraMaTP(String maTruongPhong) {
		for (NhanSu tp : this.dsNhanSu) {
			if (tp.getMaSo().equalsIgnoreCase(maTruongPhong)) {
				return true;
			}
		}
		return false;
	}
}
