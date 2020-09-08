import java.util.LinkedList;
import java.util.Scanner;

/**
 *  Lớp đối tượng danh sách nhân sự
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 03-09-2020
 */
public class DanhSachNhanSu {
	// 1. Thuộc tính
	private LinkedList<NhanSu> dsNhanSu;

	// 2. Khởi tạo
	public DanhSachNhanSu() {
		dsNhanSu = new LinkedList<NhanSu>();
	}

	public DanhSachNhanSu(LinkedList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}

	// 3. Get, set
	public LinkedList<NhanSu> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDsNhanSu(LinkedList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}

	// 4. Nhập, xuất
	public void xuat() {
		int stt = 0;
		for (NhanSu ns : this.dsNhanSu) {
			stt++;
			ns.xuat(stt);
		}
	}

	// 5. Nghiệp vụ

	// Thêm một nhân sự
	public void themNhanSu() {
		Scanner scan = new Scanner(System.in);
		String chonTiepTuc = null;
		do {
			String loaiNhanSu = null;
			System.out.print(
					"\nnvt: Nhập thông tin nhân viên thường - tp: Nhập thông tin trưởng phòng - gd: Nhập thông tin giám đốc: ");
			System.out.print("\nVui lòng nhập loại nhân sự cần thêm: ");
			do {
				loaiNhanSu = scan.nextLine();
				if (!loaiNhanSu.equalsIgnoreCase("nvt") && !loaiNhanSu.equalsIgnoreCase("tp")
						&& !loaiNhanSu.equalsIgnoreCase("gd")) {
					System.out.print("Loại nhân sự không hợp lệ! Vui lòng nhập lại: ");
				}
			} while (!loaiNhanSu.equalsIgnoreCase("nvt") && !loaiNhanSu.equalsIgnoreCase("tp")
					&& !loaiNhanSu.equalsIgnoreCase("gd"));

			NhanSu ns = null;
			if (loaiNhanSu.equalsIgnoreCase("nvt")) {
				ns = new NhanVienThuong();
				ns.nhap("nhân viên thường");
			} else if (loaiNhanSu.equalsIgnoreCase("tp")) {
				ns = new TruongPhong();
				ns.nhap("trưởng phòng");
			} else if (loaiNhanSu.equalsIgnoreCase("gd")) {
				ns = new GiamDoc();
				ns.nhap("giám đốc");
			}
			this.dsNhanSu.add(ns);
			System.out.print("Thêm nhân sự thành công!");
			System.out.print("\nBạn có muốn nhập tiếp không? Nhấn 'y' để tiếp: ");
			chonTiepTuc = scan.nextLine();
		} while (chonTiepTuc.equalsIgnoreCase("y"));
	}

	// Xóa nhân sự
	public void xoaNhanSu() {
		Scanner scan = new Scanner(System.in);
		String loaiNhanSu = null;
		System.out.print("\nnvt: Chọn xóa nhân viên thường - tp: Chọn xóa trưởng phòng - gd: Chọn xóa giám đốc: ");
		System.out.print("\nVui lòng nhập loại nhân sự cần xóa: ");
		do {
			loaiNhanSu = scan.nextLine();
			if (!loaiNhanSu.equalsIgnoreCase("nvt") && !loaiNhanSu.equalsIgnoreCase("tp")
					&& !loaiNhanSu.equalsIgnoreCase("gd")) {
				System.out.print("Loại nhân sự cần xóa không hợp lệ! Vui lòng nhập lại: ");
			}
		} while (!loaiNhanSu.equalsIgnoreCase("nvt") && !loaiNhanSu.equalsIgnoreCase("tp")
				&& !loaiNhanSu.equalsIgnoreCase("gd"));

		if (loaiNhanSu.equalsIgnoreCase("nvt")) {
			this.xoaNhanVienThuong();
			System.out.println("\nĐã xóa nhân viên.");
		} else if (loaiNhanSu.equalsIgnoreCase("tp")) {
			this.xoaTruongPhong();
			System.out.print("\nĐã xóa trưởng phòng.");
		} else if (loaiNhanSu.equalsIgnoreCase("gd")) {
			this.xoaGiamDoc();
			System.out.print("\nĐã xóa giám đốc.");
		}
	}

	// Cập nhật số lượng nhân viên của từng Trưởng Phòng
	public void capNhatSoLuongNV() {
		for (NhanSu nvt : this.dsNhanSu) {
			if (nvt instanceof NhanVienThuong) {
				for (NhanSu tp : this.dsNhanSu) {
					if (tp instanceof TruongPhong) {
						if (((NhanVienThuong) nvt).getMaTruongPhongQuanLy() != null) {
							if (tp.getMaSo().equalsIgnoreCase(((NhanVienThuong) nvt).getMaTruongPhongQuanLy())) {
								((TruongPhong) tp).setSoNVDuoiQuyen(((TruongPhong) tp).getSoNVDuoiQuyen() + 1);
							}
						}
					}
				}
			}
		}
	}

	// Phân bổ nhân viên vào trưởng phòng
	public void phanBoNhanVienThuong() {
		for (NhanSu tp : this.dsNhanSu) {
			if (tp instanceof TruongPhong) {
				((TruongPhong) tp).setSoNVDuoiQuyen(0);
			}
		}
		// B1: Duyệt hết tất cả nv thường
		for (int i = 0; i < this.dsNhanSu.size(); i++) {
			if (this.dsNhanSu.get(i) instanceof NhanVienThuong) {
				// B2: Cho người dùng chọn trưởng phòng của từng nhân viên
				Scanner scan = new Scanner(System.in);
				System.out.print("Vui lòng nhập mã trưởng phòng quản lý cho nhân viên có mã "
						+ this.dsNhanSu.get(i).maSo + ": ");
				String maTruongPhong;
				do {
					maTruongPhong = scan.nextLine();
					if (!kiemTraMaTP(maTruongPhong)) {
						System.out.print("Không có mã trưởng phòng trên trong danh sách! Vui lòng nhập lại: ");
					}
				} while (!kiemTraMaTP(maTruongPhong));

				if (kiemTraMaTP(maTruongPhong)) {
					// B3: Cập nhật lại mã tp của từng nv đó
					((NhanVienThuong) this.dsNhanSu.get(i)).setMaTruongPhongQuanLy(maTruongPhong);
				}
			}
		}
		System.out.println("\nĐã phân bổ trưởng phòng cho các nhân viên.");
	}

	// Kiểm tra mã trưởng phòng có tồn tại không
	public boolean kiemTraMaTP(String maTruongPhong) {
		for (NhanSu tp : this.dsNhanSu) {
			if (tp instanceof TruongPhong) {
				if (tp.getMaSo().equalsIgnoreCase(maTruongPhong)) {
					return true;
				}
			}
		}
		return false;
	}

	// Xóa trưởng phòng
	public boolean xoaTruongPhong() {
		boolean ketQua = false;
		// Nhập mã trưởng phòng cần xóa
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập mã trưởng phòng cần xóa: ");
		String maTpCanXoa;
		do {
			maTpCanXoa = scan.nextLine();
			if (!kiemTraMaTP(maTpCanXoa)) {
				System.out.print("Không có trưởng phòng nào có mã trên trong danh sách! Vui lòng nhập lại: ");
			}
		} while (!kiemTraMaTP(maTpCanXoa));

		// Kiểm tra tồn tại
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
			// B3: Cập nhật mã tp của từng nv
			// B3.1: Tìm nv có mã tp bằng với mã tp cần xóa
			// B3.2 Tiền hành cập nhật lai mã tp đó là null
			for (NhanSu nvt : this.dsNhanSu) {
				if (nvt instanceof NhanVienThuong && ((NhanVienThuong) nvt).getMaTruongPhongQuanLy() != null) {
					if (((NhanVienThuong) nvt).getMaTruongPhongQuanLy().equalsIgnoreCase(maTpCanXoa)) {
						((NhanVienThuong) nvt).setMaTruongPhongQuanLy(null);
					}
				}
			}
			this.dsNhanSu.remove(tp);
		}
		return ketQua;
	}

	// Kiểm tra mã nhân viên thường có tồn tại không
	public boolean kiemTraMaNV(String maNhanVien) {
		for (NhanSu nvt : this.dsNhanSu) {
			if (nvt instanceof NhanVienThuong) {
				if (nvt.getMaSo().equalsIgnoreCase(maNhanVien)) {
					return true;
				}
			}
		}
		return false;
	}

	// Xóa nhân viên thường
	public boolean xoaNhanVienThuong() {
		boolean ketQua = false;
		// Nhập mã nhân viên thường cần xóa
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập mã nhân viên cần xóa: ");
		String maNvCanXoa;
		do {
			maNvCanXoa = scan.nextLine();
			if (!kiemTraMaNV(maNvCanXoa)) {
				System.out.print("Không có nhân viên nào có mã trên trong danh sách! Vui lòng nhập lại: ");
			}
		} while (!kiemTraMaNV(maNvCanXoa));

		// Kiểm tra tồn tại
		NhanVienThuong nvt = new NhanVienThuong();
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof NhanVienThuong) {
				if (ns.getMaSo().equalsIgnoreCase(maNvCanXoa)) {
					nvt = (NhanVienThuong) ns;
					ketQua = true;
					break;
				}
			}
		}

		if (ketQua) {
			this.dsNhanSu.remove(nvt);
			// B3: Cập nhật lại số nv dưới quyền cho từng trưởng phòng
			// B3.1: Tìm tp có mã bằng với mã tp quản lý của nv cần xóa
			// B3.2 Tiền hành cập nhật lai số nv dưới quyền
			for (NhanSu tp : dsNhanSu) {
				if (tp instanceof TruongPhong) {
					if (((TruongPhong) tp).getMaSo().equalsIgnoreCase(nvt.getMaTruongPhongQuanLy())) {
						((TruongPhong) tp).setSoNVDuoiQuyen(((TruongPhong) tp).getSoNVDuoiQuyen() - 1);
					}
				}
			}
		}
		return ketQua;
	}

	// Kiểm tra mã giám đốc có tồn tại không
	public boolean kiemTraMaGD(String maGiamDoc) {
		for (NhanSu gd : this.dsNhanSu) {
			if (gd instanceof GiamDoc) {
				if (gd.getMaSo().equalsIgnoreCase(maGiamDoc)) {
					return true;
				}
			}
		}
		return false;
	}

	// Xóa giám đốc
	public boolean xoaGiamDoc() {
		boolean ketQua = false;
		// Nhập mã giám đốc cần xóa
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập mã giám đốc cần xóa: ");
		String maGdCanXoa;
		do {
			maGdCanXoa = scan.nextLine();
			if (!kiemTraMaGD(maGdCanXoa)) {
				System.out.print("Không có giám đốc nào có mã trên trong danh sách! Vui lòng nhập lại: ");
			}
		} while (!kiemTraMaGD(maGdCanXoa));

		// Kiểm tra tồn tại
		GiamDoc gd = new GiamDoc();
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof GiamDoc) {
				if (ns.getMaSo().equalsIgnoreCase(maGdCanXoa)) {
					gd = (GiamDoc) ns;
					ketQua = true;
					break;
				}
			}
		}

		if (ketQua) {
			this.dsNhanSu.remove(gd);
		}
		return ketQua;
	}

	// Tính tổng lương tháng cho toàn công ty
	public float tinhTongLuong() {
		float tongLuong = 0;
		for (NhanSu ns : dsNhanSu) {
			tongLuong += ns.tinhLuong();
		}
		return tongLuong;
	}

	// Tìm nhân viên thường có lương cao nhất
	public DanhSachNhanSu timNhanVienThuongLuongMax() {

		// Tìm lương cao nhất trong các nhân viên thường
		double luongMax = 0;
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVienThuong) {
				if (ns.tinhLuong() > luongMax) {
					luongMax = ns.tinhLuong();
				}
			}
		}

		// Tìm những nvt có lương cao nhất
		DanhSachNhanSu dsKetQua = new DanhSachNhanSu();
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVienThuong) {
				if (ns.tinhLuong() == luongMax) {
					dsKetQua.getDsNhanSu().add(ns);
				}
			}
		}

		return dsKetQua;
	}

	// Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
	public DanhSachNhanSu timTPCoNhieuNVDQNhat() {

		// Tìm số lượng nv dưới quyền nhiều nhất
		int maxNVDQ = 0;
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof TruongPhong) {
				if (((TruongPhong) ns).getSoNVDuoiQuyen() > maxNVDQ) {
					maxNVDQ = ((TruongPhong) ns).getSoNVDuoiQuyen();
				}
			}
		}

		// Tìm Trưởng Phòng có số lượng nvdq nhiều nhất
		DanhSachNhanSu dsKetQua = new DanhSachNhanSu();
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof TruongPhong) {
				if (((TruongPhong) ns).getSoNVDuoiQuyen() == maxNVDQ) {
					dsKetQua.getDsNhanSu().add(ns);
				}
			}
		}

		return dsKetQua;
	}

	// Đổi chỗ 2 nhân sự
	public void swapNhanSu(LinkedList<NhanSu> dsns, int i, int j) {
		NhanSu temp = dsns.get(i);
		dsns.set(i, dsns.get(j));
		dsns.set(j, temp);
	}

	// Sắp xếp tên nhân sự toàn công ty theo thứ tự abc
	public DanhSachNhanSu sapXepTenTheoAbc() {
		DanhSachNhanSu dsKetQua = new DanhSachNhanSu();
		dsKetQua.setDsNhanSu(this.dsNhanSu);
		for (int i = 0; i < dsKetQua.getDsNhanSu().size() - 1; i++) {
			for (int j = i + 1; j < dsKetQua.getDsNhanSu().size(); j++) {
				if (dsKetQua.getDsNhanSu().get(i).tachLayTen()
						.compareToIgnoreCase(dsKetQua.getDsNhanSu().get(j).tachLayTen()) > 0) {
					swapNhanSu(dsKetQua.getDsNhanSu(), i, j);
				}
			}
		}
		return dsKetQua;
	}

	// Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần
	public DanhSachNhanSu sapXepLuongGiamDan() {
		DanhSachNhanSu dsKetQua = new DanhSachNhanSu();
		dsKetQua.setDsNhanSu(this.dsNhanSu);
		for (int i = 0; i < dsKetQua.getDsNhanSu().size() - 1; i++) {
			for (int j = i + 1; j < dsKetQua.getDsNhanSu().size(); j++) {
				if (dsKetQua.getDsNhanSu().get(i).tinhLuong() < dsKetQua.getDsNhanSu().get(j).tinhLuong()) {
					swapNhanSu(dsKetQua.getDsNhanSu(), i, j);
				}
			}
		}
		return dsKetQua;
	}

	// Tìm Giám Đốc có số lượng cổ phần nhiều nhất
	public DanhSachNhanSu timGiamDocCoPhanMax() {
		// Tìm số cổ phần lớn nhất của các Giám Đốc
		double maxCoPhan = 0;
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof GiamDoc) {
				if (((GiamDoc) ns).getSoCoPhan() > maxCoPhan) {
					maxCoPhan = ((GiamDoc) ns).getSoCoPhan();
				}
			}
		}

		// Tìm Giám Đốc có số lượng cổ phần nhiều nhất
		DanhSachNhanSu dsKetQua = new DanhSachNhanSu();
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof GiamDoc) {
				if (((GiamDoc) ns).getSoCoPhan() == maxCoPhan) {
					dsKetQua.getDsNhanSu().add(ns);
				}
			}
		}

		return dsKetQua;
	}
}