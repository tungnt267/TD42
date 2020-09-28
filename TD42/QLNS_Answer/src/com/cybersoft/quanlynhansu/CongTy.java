package com.cybersoft.quanlynhansu;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cybersoft.interfaceclass.IXuatNhap;

public class CongTy implements IXuatNhap {
	// VARIABLES
	final private int NV_THUONG = 1;
	final private int TRUONGPHONG = 2;
	final private int GIAMDOC = 3;

	/* PROPERTIERS */
	private String tenCongTy;
	private String tenVietTat; // CG -> CG20200001
	private String maSoThue;
	private double doanhThuThang;
	private double loiNhuan;
	private double tongLuongCongTy;
	private ArrayList<NhanSu> dsNhanSu;

	private int STT = 999;
	private Helper helper;

	/* CONSTRUCTORS */
	public CongTy() {
		this.tenCongTy = "";
		this.maSoThue = "";
		this.dsNhanSu = new ArrayList<NhanSu>();
		this.helper = new Helper();
	}

	public CongTy(String tenCongTy, String maSoThue) {
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.dsNhanSu = new ArrayList<NhanSu>();
		this.helper = new Helper();
	}

	public CongTy(String tenCongTy, String tenVietTat, String maSoThue, double doanhThuThang) {
		this.tenCongTy = tenCongTy;
		this.tenVietTat = tenVietTat;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
		this.dsNhanSu = new ArrayList<NhanSu>();
		this.helper = new Helper();
	}

	/* GETTER / SETTER */
	public String getTenCongTy() {
		return this.tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getTenVietTat() {
		return this.tenVietTat;
	}

	public void setTenVietTat(String tenVietTat) {
		this.tenVietTat = tenVietTat;
	}

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return this.doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	/* METHODS */

	// 1. Nhập thông tin công ty============================================ >>>
	@Override
	public void nhapThongTin() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Tên công ty: ");
		this.tenCongTy = sc.nextLine();
		System.out.print("Tên viết tắt: ");
		this.tenVietTat = sc.nextLine();
		System.out.print("Mã số thuế: ");
		this.maSoThue = sc.nextLine();
		System.out.print("Doanh thu tháng hiện tại: ");
		this.doanhThuThang = Double.parseDouble(sc.nextLine());
	}

	// 2. Phân bổ nhân viên vào trưởng phòng================================ >>>
	public void phanBoNhanVien(Scanner scanner) {
		ArrayList<NhanVien> dsNhanVienChuaPhanBo = new ArrayList<NhanVien>();
		ArrayList<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		int luaChon;

		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVien && ((NhanVien) ns).getTruongPhong() == null) {
				dsNhanVienChuaPhanBo.add((NhanVien) ns);
			} else if (ns instanceof TruongPhong) {
				dsTruongPhong.add((TruongPhong) ns);
			}
		}

		System.out.println("\tPHÂN BỔ NHÂN VIÊN: ");

		for (NhanVien nv : dsNhanVienChuaPhanBo) {
			System.out.println("Thông tin nhân viên: ");
			nv.xuatThongTin();

			System.out.println("Danh sách trưởng phòng: ");
			for (int i = 0; i < dsTruongPhong.size(); i++) {
				System.out.print((i + 1) + ". ");
				dsTruongPhong.get(i).xuatThongTin();
			}
			System.out.println("\t0. Không phân bổ");
			int a = 1, b = 3;

			System.out.print("Lựa chọn: ");
			luaChon = a + (int) (Math.random() * ((b - a) + 1));
			System.out.println(luaChon);

			// de-coupling code <> couple
			// micro optimize
			if (luaChon <= 0) {
				continue;
			}

			TruongPhong tp;
			tp = dsTruongPhong.get(luaChon - 1);
			nv.setTruongPhong(tp.getMaSo());
			tp.tangNhanVien();

		}
	}

	// 3. Thêm Nhân sự mới ============================================ >>>
	public boolean themNhanSu(NhanSu ns) {
		// 1. kiểm tra null
		// 2. kiểm tra tên rỗng
		// 3. kiểm tra trùng lặp
		// 4. thêm
		if (ns == null)
			return false;

		if ("".equals(ns.getHoTen()))
			return false;

		if (helper.daTonTaiNhanSu(ns))
			return false;

		ns.setMaSo(helper.generateId());
		dsNhanSu.add(ns);
		return true;
	}

	public void nhapNV(Scanner scan) {
		boolean thoat = false;
		boolean chonTiep = false;
		do {
			thoat = false;
			NhanSu nv;
			System.out.println("Chọn loại Nhân Viên muốn thêm vào");
			System.out.println(
					"1. Nhân Viên Thường \t 2. Trưởng Phòng \t 3. Giám Đốc \t 4. Cập nhật trưởng phòng \t 0. Trở về menu chính");
			System.out.print("Chọn >>> ");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case NV_THUONG: {
				nv = new NhanVien();
				nv.nhapThongTin(scan);
				nv.tinhLuong();
				themNhanSu(nv);
				chonTiep = true;
			}
				break;
			case TRUONGPHONG: {
				nv = new TruongPhong();
				nv.nhapThongTin(scan);
				nv.tinhLuong();
				themNhanSu(nv);
				chonTiep = true;
			}
				break;
			case GIAMDOC: {
				nv = new GiamDoc();
				nv.nhapThongTin(scan);
				nv.tinhLuong();
				themNhanSu(nv);
				chonTiep = true;
			}
				break;
			case 4: {
				List<NhanSu> dstp = this.LaydsNhanSu(TRUONGPHONG);
				if (dstp.size() != 0) {
					for (NhanSu tp : dstp) {
						((TruongPhong) tp).setSoNhanVien(0);
					}
					capNhatToanBoNV();
				} else {
					System.out.println("Hiện tại danh sách trưởng phòng đang rỗng! Yêu cầu nhập thêm trưởng phỏng!");
				}
				chonTiep = true;
			}
				break;
			case 0: {
				chonTiep = false;
				thoat = true;
			}
				break;
			default: {
				System.out.println("Mời bạn chọn lại!");
				chonTiep = false;
			}
			}

			if (chonTiep) {
				do {
					System.out.print("Tiếp tục thêm Nhân Viên? \t 1 - Có, 0 - Không : ");
					int tieptuc = Integer.parseInt(scan.nextLine());
					if (tieptuc == 1) {
						thoat = false;
						break;
					} else if (tieptuc == 0) {
						thoat = true;
						break;
					} else {
						System.out.println("Mời bạn chọn lại!");
					}
				} while (true);
			}
		} while (!thoat);
	}

	public void capNhatToanBoNV() {
		// Phân bổ nhân viên vào phòng ban
		// duyệt danh sách nhân viên thương và cập nhật trưởng phòng
		indsNhanSu(2);// in DS trưởng phòng
		System.out.println("Bắt đầu phân bổ nhân viên vào trưởng phòng: ");
		for (NhanSu nv : this.dsNhanSu) {
			if (nv instanceof NhanVien) {
				((NhanVien) nv).xuatMavaTen();
				this.capNhatTruongPhong(nv);
			}
		}
	}

	private void indsNhanSu(int loaiNV) {
		if (loaiNV == NV_THUONG) {
			System.out.println("Đây là danh sách nhân viên thường");
		} else if (loaiNV == TRUONGPHONG) {
			System.out.println("Đây là danh sách trưởng phòng");
		} else {
			System.out.println("Đây là danh sách giám đốc");
		}
		for (NhanSu nv : this.dsNhanSu) {
			if (loaiNV == NV_THUONG) {
				if (nv instanceof NhanVien) {
					((NhanVien) nv).xuatMavaTen();
				}
			} else if (loaiNV == TRUONGPHONG) {
				if (nv instanceof TruongPhong) {
					((TruongPhong) nv).xuatMavaTen();
				}
			} else {
				if (nv instanceof GiamDoc) {
					((GiamDoc) nv).xuatMavaTen();
				}
			}
		}
	}

	private void capNhatTruongPhong(NhanSu nv) {
		boolean thoat = false;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Nhập mã trưởng phòng mới cho nhân viên, enter nếu chưa ấn định:");
			String chon = scan.nextLine();
			TruongPhong truongPhong = timTPTheoMaTP(chon, this.dsNhanSu);
//			 ((NhanVien) nv).setMaSo((scan.nextLine())); //viết siêu tắt
			if (truongPhong != null) {
				((NhanVien) nv).setTruongPhong(chon);
				// cập nhật số lượng nhân viên cho trưởng phòng đang chọn
				truongPhong.tangNhanVien();
				thoat = true;
				System.out.println("Cập nhật thành công!");
			} else if (chon == "") {
				thoat = true;
			} else {
				System.out.println("Cập nhật thất bại!");
				System.out.println("Vui lòng chọn trưởng phòng có trong danh sách hoặc enter");
				thoat = false;
			}
			// count++;
		} while (!thoat);

	}

	@SuppressWarnings("unused")
	private NhanVien timNVThuongTheoMaNS(String ma, List<NhanSu> dsns) {
		for (NhanSu nv : dsns) {
			if (nv instanceof NhanVien) {
				if (((NhanVien) nv).getMaSo().equalsIgnoreCase(ma)) {
					return (NhanVien) nv;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	private TruongPhong timTPTheoMaNS(String ma, List<NhanSu> dsns) {
		for (NhanSu nv : dsns) {
			if (nv instanceof TruongPhong) {
				if (((TruongPhong) nv).getMaSo().equalsIgnoreCase(ma)) {
					return (TruongPhong) nv;
				}
			}
		}
		return null;
	}

	private TruongPhong timTPTheoMaTP(String ma, List<NhanSu> dsns) {
		for (NhanSu nv : dsns) {
			if (nv instanceof TruongPhong) {
				if (((TruongPhong) nv).getMaSo().equalsIgnoreCase(ma)) {
					return (TruongPhong) nv;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	private GiamDoc timGDTheoMaNS(String ma, List<NhanSu> dsns) {
		for (NhanSu nv : dsns) {
			if (nv instanceof GiamDoc) {
				if (((GiamDoc) nv).getMaSo().equalsIgnoreCase(ma)) {
					return (GiamDoc) nv;
				}
			}
		}
		return null;
	}

	// 4. Xóa thông tin nhân sự công ty ===============================>>>
	@SuppressWarnings("unused")
	private void inXoa() {
		System.out.println("Chọn loại Nhân sự cần xóa: ");
		System.out.println("1. Nhân Viên Thường \t 2. Trưởng Phòng \t 3. Giám Đốc \t 0. Trở về menu chính");
		System.out.print("Chọn >>> ");
	}

	private List<NhanSu> LaydsNhanSu(int loaiNV) {
		List<NhanSu> dsketQua = new ArrayList<NhanSu>();
		for (NhanSu nv : this.dsNhanSu) {
			if (loaiNV == NV_THUONG) {
				if (nv instanceof NhanVien) {
					dsketQua.add(nv);
				}
			} else if (loaiNV == TRUONGPHONG) {
				if (nv instanceof TruongPhong) {
					dsketQua.add(nv);
				}
			} else {
				if (nv instanceof GiamDoc) {
					dsketQua.add(nv);
				}
			}
		}
		return dsketQua;
	}

	private void indsNhanSu(int loaiNV, List<NhanSu> dsNhanSu) {
		if (loaiNV == NV_THUONG) {
			System.out.println("Đây là danh sách nhân viên thường: ");
		} else if (loaiNV == TRUONGPHONG) {
			System.out.println("Đây là danh sách trưởng phòng: ");
		} else {
			System.out.println("Đây là danh sách giám đốc: ");
		}
		for (NhanSu nv : dsNhanSu) {
			if (loaiNV == NV_THUONG) {
				if (nv instanceof NhanVien) {
					((NhanVien) nv).xuatMavaTen();
				}
			} else if (loaiNV == TRUONGPHONG) {
				if (nv instanceof TruongPhong) {
					((TruongPhong) nv).xuatMavaTen();
				}
			} else {
				if (nv instanceof GiamDoc) {
					((GiamDoc) nv).xuatMavaTen();
				}
			}
		}
	}

	private void XoaNVThuong(List<NhanSu> dsNhanSu) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		do {
			indsNhanSu(NV_THUONG, dsNhanSu);// in toàn bộ nhân viên
			System.out.print("Vui lòng chọn mã nhân viên thường cần xóa hoặc enter để thoát: ");
			String chonMa = scan.nextLine();
			if (chonMa == "") {
				break;
			}
			NhanVien nvThuong = timNVThuongTheoMaNS(chonMa, dsNhanSu);
			if (nvThuong != null) {
				if (nvThuong.getTruongPhong() != null) {
					TruongPhong tp = timTPTheoMaTP(nvThuong.getTruongPhong(), this.dsNhanSu);
					tp.giamNhanVien();
				}
				System.out.println("Đã xóa thành công nhân viên với mã: " + nvThuong.getMaSo());
				this.dsNhanSu.remove(nvThuong);
				break;
			} else {
				System.out.println("Không tìm thấy NV với mã vừa nhập !");
				break;
			}
		} while (true);
	}

	private void XoaTruongPhong(List<NhanSu> dsNhanSu) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		do {
			indsNhanSu(TRUONGPHONG, dsNhanSu);// in toàn bộ nhân viên
			System.out.print("Vui lòng chọn mã nhân viên của trưởng phòng cần xóa hoặc enter để thoát: ");
			String chonMa = scan.nextLine();
			if (chonMa == "") {
				break;
			}
			TruongPhong tp = timTPTheoMaNS(chonMa, dsNhanSu);
			if (tp != null) {
				for (NhanSu nv : this.dsNhanSu) {
					if (nv instanceof NhanVien) {
						if (((NhanVien) nv).getTruongPhong() == tp.getMaSo()) {
							((NhanVien) nv).setTruongPhong("");
						}
					}
				}
				System.out.println("Đã xóa thành công trưởng phòng với mã: " + tp.getMaSo());
				this.dsNhanSu.remove(tp);
				break;
			} else {
				System.out.println("Không tìm thấy Trưởng phòng với mã vừa nhập !");
				break;
			}
		} while (true);
	}

	private void XoaGiamDoc(List<NhanSu> dsNhanSu) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		do {
			indsNhanSu(GIAMDOC, dsNhanSu);// in toàn bộ nhân viên
			System.out.print("Vui lòng chọn mã nhân viên của giám đốc cần xóa hoặc enter để thoát: ");
			String chonMa = scan.nextLine();
			if (chonMa == "") {
				break;
			}
			GiamDoc giamDoc = timGDTheoMaNS(chonMa, dsNhanSu);
			if (giamDoc != null) {
				System.out.println("Đã xóa thành công nhân viên với mã: " + giamDoc.getMaSo());
				this.dsNhanSu.remove(giamDoc);
				break;
			} else {
				System.out.println("Không tìm thấy giám đốc với mã vừa nhập !");
				break;
			}
		} while (true);
	}

	// Xóa
	public void xoaNV(Scanner scan) {
		boolean thoat = false;
		if (this.dsNhanSu.size() != 0) {
			do {
				this.inXoa();
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case NV_THUONG: {
					List<NhanSu> dsNhanSu = LaydsNhanSu(1);
					if (dsNhanSu.size() != 0) {
						this.XoaNVThuong(dsNhanSu);
					} else {
						System.out.println("Hiện tại danh sách nhân viên thường đang rỗng!");
					}
				}
					break;
				case TRUONGPHONG: {
					List<NhanSu> dsNhanSu = LaydsNhanSu(2);
					if (dsNhanSu.size() != 0) {
						this.XoaTruongPhong(dsNhanSu);
					} else {
						System.out.println("Hiện tại danh sách Trưởng phòng đang rỗng!");
					}
				}
					break;
				case GIAMDOC: {
					List<NhanSu> dsNhanSu = LaydsNhanSu(3);
					if (dsNhanSu.size() != 0) {
						this.XoaGiamDoc(dsNhanSu);
					} else {
						System.out.println("Hiện tại danh sách Giám đốc đang rỗng!");
					}
				}
					break;
				case 0:
					thoat = true;
					break;
				}
				do {
					System.out.println("Bạn có muốn tiếp tục xóa nhân viên của công ty " + this.tenCongTy + " ?");
					System.out.println("1: có; 0: không");
					System.out.print("Chọn >>> ");
					int chonTiepTuc = Integer.parseInt(scan.nextLine());
					if (chonTiepTuc == 1) {
						break;
					} else if (chonTiepTuc == 0) {
						thoat = true;
						break;
					} else {
						System.out.println("Lựa chọn không hợp lệ! Yêu cầu chọn lại.");
					}
				} while (true);
			} while (!thoat);
		} else {
			System.out.println("Yêu cầu nhập thêm nhân viên để thực hiện xóa!");
		}
	}

	private void inSua() {
		System.out.println("Chọn loại Nhân Viên cần sửa thông tin: ");
		System.out.println("1. Nhân Viên Thường \t 2. Trưởng Phòng \t 3. Giám Đốc \t 0. Trở về menu chính");
		System.out.print("Chọn >>> ");
	}

	// 5. Sửa thông tin nhân sự công ty ===========================>>>
	public void suaNV(Scanner scan) {
		boolean thoat = false;
		if (this.dsNhanSu.size() != 0) {
			do {
				this.inSua();
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case NV_THUONG: {
					List<NhanSu> dsketQua = LaydsNhanSu(NV_THUONG);
					if (dsketQua.size() != 0) {
						this.suaThongTinNV(dsketQua, NV_THUONG);
					} else {
						System.out.println("Hiện tại danh sách nhân viên thường đang rỗng!");
					}
				}
					break;
				case TRUONGPHONG: {
					List<NhanSu> dsketQua = LaydsNhanSu(TRUONGPHONG);
					if (dsketQua.size() != 0) {
						this.suaThongTinNV(dsketQua, TRUONGPHONG);
					} else {
						System.out.println("Hiện tại danh sách Trưởng phòng đang rỗng!");
					}
				}
					break;
				case GIAMDOC: {
					List<NhanSu> dsketQua = LaydsNhanSu(GIAMDOC);
					if (dsketQua.size() != 0) {
						this.suaThongTinNV(dsketQua, GIAMDOC);
					} else {
						System.out.println("Hiện tại danh sách Giám đốc đang rỗng!");
					}
				}
					break;
				case 0:
					thoat = true;
					break;
				}
				do {
					System.out.println(
							"Bạn có muốn tiếp tục sửa thông tin nhân viên của công ty " + this.tenCongTy + " ?");
					System.out.println("1: có; 0: không");
					System.out.print("Chọn >> ");
					int chonTiepTuc = Integer.parseInt(scan.nextLine());
					if (chonTiepTuc == 1) {
						break;
					} else if (chonTiepTuc == 0) {
						thoat = true;
						break;
					} else {
						System.out.println("Lựa chọn không hợp lệ! Yêu cầu chọn lại.");
					}
				} while (true);
			} while (!thoat);
		} else {
			System.out.println("Yêu cầu nhập thêm nhân viên để thực hiện sửa thông tin!");
		}
	}

	private void inMenuSuaThongTin() {
		System.out.println("Nhập vào nội dung muốn sửa");
		System.out.println("1. Sửa mã nhân viên");
		System.out.println("2. Sửa tên nhân viên");
		System.out.println("3. Sửa Số điện thoại");
		System.out.println("4. Sửa số ngày làm việc");
		System.out.println("Để thoát chọn -1");
		System.out.print("Chọn >>> ");
	}

	private boolean suaThongTinChiTiet(int luaChon, NhanSu nv, String chucDanh) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		do {
			switch (luaChon) {
			case -1: {
				return true;
			}
			case 1: {
				System.out.println("Vui lòng nhập mã nhân viên mới cho " + chucDanh);
				System.out.print("Nhập: ");
				nv.setMaSo(scan.nextLine());
				System.out.println("Đã cập nhật mã nhân viên cho " + chucDanh + " thành công");
				return true;
			}
			case 2: {
				System.out.println("Vui lòng nhập tên mới cho " + chucDanh);
				System.out.print("Nhập: ");
				nv.setHoTen(scan.nextLine());
				System.out.println("Đã cập nhật tên " + chucDanh + " thành công");
				return true;
			}
			case 3: {
				System.out.println("Vui lòng nhập số điện thoại mới cho " + chucDanh);
				System.out.print("Nhập: ");
				nv.setSoDt(scan.nextLine());
				System.out.println("Đã cập nhật sđt cho " + chucDanh + " thành công");
				return true;
			}
			case 4: {
				System.out.println("Vui lòng nhập số ngày làm việc mới cho " + chucDanh);
				System.out.print("Nhập: ");
				nv.setSoNgayLamViec(Float.parseFloat(scan.nextLine()));
				nv.tinhLuong();
				System.out.println("Đã cập nhật số ngày làm việc cho " + chucDanh + " thành công");
				return true;
			}
			default:
				System.out.println("Bạn đã lựa chọn sai. Vui lòng chọn lại! từ 1 --> 4 hoặc -1 để thoát");
				return false;
			}
		} while (true);
	}

	public void suaThongTinNV(List<NhanSu> dsNhanSu, int loaiNV) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean thoat = false;
		String chucDanh = "";
		if (loaiNV == NV_THUONG) {
			chucDanh = "Nhân viên thường";
		} else if (loaiNV == TRUONGPHONG) {
			chucDanh = "Trưởng phòng";
		} else {
			chucDanh = "Giám đốc";
		}
		do {
			indsNhanSu(loaiNV, dsNhanSu);// in toàn bộ nhân viên
			System.out
					.println("Vui lòng chọn mã nhân viên của " + chucDanh + " cần sửa thông tin hoặc enter để thoát: ");
			System.out.print("Chọn >>> ");
			String chonMa = scan.nextLine();
			if (chonMa == "") {
				break;
			}

			NhanSu nhanSu;
			switch (loaiNV) {
			case NV_THUONG:
				nhanSu = timNVThuongTheoMaNS(chonMa, dsNhanSu);
				break;
			case TRUONGPHONG:
				nhanSu = timTPTheoMaNS(chonMa, dsNhanSu);
				break;
			default:
				nhanSu = timGDTheoMaNS(chonMa, dsNhanSu);
				break;
			}

			if (nhanSu != null) {
				thoat = false;
				do {
					inMenuSuaThongTin();
					int chon = Integer.parseInt(scan.nextLine());
					thoat = suaThongTinChiTiet(chon, nhanSu, chucDanh);
				} while (!thoat);
				break;
			} else {
				System.out.println("Không tìm thấy " + chucDanh + " với mã vừa nhập");
				break;
			}
		} while (true);
	}

	// 6. Xem danh sách nhân sự của Công Ty======================= >>>
	@Override
	public void xuatThongTin() {
		int num = 72;
		String ttCongTy = "THÔNG TIN CÔNG TY";
		String ttNhanSu = "DANH SÁCH NHÂN SỰ";

		System.out.println();
		System.out.println(String.format("%" + (num * 2 - ttCongTy.length()) / 2 + "s", "") + ttCongTy
				+ String.format("%" + (num * 2 - ttCongTy.length()) / 2 + "s", ""));
		System.out.println("Tên công ty: " + tenCongTy);
		System.out.println("Mã số thuế: " + maSoThue);
		System.out.println("Doanh thu: " + String.format("%20.2f", doanhThuThang));

		System.out.println();
		System.out.println(String.format("%" + (num * 2 - ttNhanSu.length()) / 2 + "s", "") + ttNhanSu
				+ String.format("%" + (num * 2 - ttNhanSu.length()) / 2 + "s", ""));
		helper.drawLine(num);
		System.out.println();
		System.out.println(String.format(" %10s  ", "Mã số") + String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại") + String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản") + String.format("%17s  ", "Lương")
				+ String.format("%16s", "Chức vụ") + String.format("%25s  ", "Số nhân viên/Cổ phần"));
		helper.drawLine(num);
		System.out.println();
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.xuatThongTin();
		}
		helper.drawLine(num);
		System.out.println();
		System.out.println(String.format(" %10s  ", "") + String.format("%16s  ", "") + String.format("%16s  ", "")
				+ String.format("%30s  ", "Tổng lương") + String.format("%17.2f  ", tinhTongLuong())
				+ String.format("%16s", "") + String.format("%25s  |", ""));
		helper.drawLine(num);
	}

	// 7. Xem tổng lương của toàn công ty======================== >>>
	public double tinhTongLuong() {
		double tongLuong = 0;
		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}

		return this.tongLuongCongTy = tongLuong;
	}

	// 8. Xem trưởng phòng có lương cao nhất======================= >>>
	public void timTruongPhongLuongMax() {
		if (this.dsNhanSu.size() != 0) {
			List<NhanSu> dstp = this.LaydsNhanSu(TRUONGPHONG);
			if (dstp.size() != 0) {
				for (NhanSu nv : dstp) {
					((TruongPhong) nv).tinhLuong();
				}
				List<TruongPhong> dstp_max = timTPLuongMax_ChiTiet(dstp);
				if (dstp_max.size() == 1) {
					System.out.println("Đã tìm ra trưởng phòng có lương cao nhất");
					dstp_max.get(0).xuatMavaTen();
					System.out.println("Với lương là: " + dstp_max.get(0).tinhLuong());
				} else {
					System.out.println("Đây là danh sách các trưởng phòng có lương cao nhất");
					for (TruongPhong tp : dstp_max) {
						tp.xuatMavaTen();
					}
					System.out.println("Với lương là: " + dstp_max.get(0).tinhLuong());
				}
			} else {
				System.out.println("Hiện tại danh sách trưởng phòng đang rỗng. Yêu cầu nhập thêm trưởng phòng");
			}
		} else {
			System.out.println("Danh sách nhân viên đang rỗng! yếu cầu nhập thêm nhân viên");
		}
	}

	private List<TruongPhong> timTPLuongMax_ChiTiet(List<NhanSu> dstp) {
		List<TruongPhong> dstp_max = new ArrayList<TruongPhong>();
		TruongPhong tp_max = null;
		if (dstp.size() == 1) {
			tp_max = ((TruongPhong) dstp.get(0));
			dstp_max.add(tp_max);
		} else {
			tp_max = ((TruongPhong) dstp.get(0));
			for (NhanSu tp : dstp) {
				if (tp_max.tinhLuong() < tp.tinhLuong()) {
					tp_max = (TruongPhong) tp;
				}
			}
			for (NhanSu tp : dstp) {
				if (tp.tinhLuong() == tp_max.tinhLuong()) {
					dstp_max.add((TruongPhong) tp);
				}
			}
		}
		return dstp_max;
	}

	// 9. Xem Nhân viên thường có lương cao nhất======================== >>>
	public NhanSu timNhanVienLuongMax() {
		NhanSu nhanVien = new NhanVien(); // new 1 NhanVien mới để set dữ liệu nào cần trả về thì mới trả về vào thằng
											// NhanVien mới
		int viTri = -1;

		int maxLength = dsNhanSu.size();

		// 1. tim nhan vien thuong dau tien
		for (int i = 0; i < maxLength; i++) {
			NhanSu ns = dsNhanSu.get(i);
			if (ns instanceof NhanVien) {
				nhanVien.setMaSo(ns.getMaSo());
				nhanVien.setHoTen(ns.getHoTen());
				nhanVien.setSoDt(ns.getSoDt());
				nhanVien.setSoNgayLamViec(ns.getSoNgayLamViec());
				nhanVien.setLuongMotNgay(ns.getLuongMotNgay());
				nhanVien.setThongTinThem(ns.getThongTinThem());
				viTri = i;
				break;
			}
		}

		for (int i = viTri; i < maxLength; i++) {
			NhanSu ns = dsNhanSu.get(i);

			if (!(ns instanceof NhanVien))
				continue;

			if (ns.tinhLuong() > nhanVien.tinhLuong()) {
				nhanVien.setMaSo(ns.getMaSo());
				nhanVien.setHoTen(ns.getHoTen());
				nhanVien.setSoDt(ns.getSoDt());
				nhanVien.setSoNgayLamViec(ns.getSoNgayLamViec());
				nhanVien.setLuongMotNgay(ns.getLuongMotNgay());
				nhanVien.setThongTinThem(ns.getThongTinThem());
			}
		}

		return nhanVien;
	}

	public void timNhanVienThuongLuongCaoNhat() { // gom về đây cho gọn code hàm main
		System.out.println("Nhân viên có lương cao nhất:");
		NhanSu nhanVien = timNhanVienLuongMax();
		inTable();
		nhanVien.xuatThongTin();
	}

	// 10. Xem trưởng phòng có nhiều nhân viên dưới quyền nhất================= >>>
	public NhanSu timTruongPhongQuanLyNhieuNhat() {
		NhanSu truongPhong = null;
		int viTri = 0;
		int maxLength = dsNhanSu.size();
		// tim ong truong phong dau tien
		for (int i = 0; i < maxLength; i++) {
			NhanSu ns = dsNhanSu.get(i);
			if (ns instanceof TruongPhong) {
				viTri = i;
				truongPhong = ns;
				break;
			}
		}

		// tim truong phong co so luong nhan vien duoi quyen nhieu nhat
		for (int i = viTri; i < maxLength; i++) {
			NhanSu ns = dsNhanSu.get(i);
			if (!(ns instanceof TruongPhong))
				continue;
			int maxSoNv = ((TruongPhong) truongPhong).getSoNhanVien();
			int soNv = ((TruongPhong) ns).getSoNhanVien();
			if (maxSoNv < soNv) {
				truongPhong = ns;
			}
		}

		return truongPhong;
	}

	public void timTruongPhongCoNhanVienDuoiQuyenNhieuNhat() { // gom code
		System.out.println("Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất:");
		NhanSu truongPhongNVDQMax = timTruongPhongQuanLyNhieuNhat();
		if (truongPhongNVDQMax != null) {
			inTable();
			truongPhongNVDQMax.xuatThongTin();
		}
	}

	// 11. Sắp xếp nhân sự toàn công ty theo thứ tự abc==================== >>>
	public void sapXepTheoThuTuABC() {
		Collections.sort(dsNhanSu, new Comparator<NhanSu>() {
			@Override
			public int compare(NhanSu o1, NhanSu o2) {
				// So sánh theo Alphabet (chữ cái).
				int value = o1.getHoTen().compareTo(o2.getHoTen());
				return value;
			}
		});

		System.out.println("Danh sách nhân viên sắp xếp theo thứ tự ABC: ");
		inTable();
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.xuatThongTin();
		}
		System.out.println("Sắp xếp thành công");
	}

	// 12. Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần========= >>>
	public void sapXepTheoLuongGiamDan() {
		Collections.sort(dsNhanSu, new Comparator<NhanSu>() {
			@Override
			public int compare(NhanSu o1, NhanSu o2) {
				return Double.compare(o2.tinhLuong(), o1.tinhLuong());
			}
		});

		System.out.println("Danh sách nhân viên sắp xếp theo lương giảm dần: ");
		inTable();
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.xuatThongTin();
		}
		System.out.println("Sắp xếp thành công");

	}

	// 13. Xem giám đốc có số lượng cổ phần nhiều nhất===================== >>>
	public List<GiamDoc> timGiamDocCoPhan_MaxChiTiet(List<NhanSu> dsgd) {
		GiamDoc gd_max = (GiamDoc) dsgd.get(0);
		List<GiamDoc> dsgd_max = new ArrayList<GiamDoc>();
		for (NhanSu gd : dsgd) {
			if (gd_max.getSoCoPhan() < ((GiamDoc) gd).getSoCoPhan()) {
				gd_max = ((GiamDoc) gd);
			}
		}
		for (NhanSu gd : dsgd) {
			if (gd_max.getSoCoPhan() == ((GiamDoc) gd).getSoCoPhan()) {
				dsgd_max.add((GiamDoc) gd);
			}
		}
		return dsgd_max;
	}

	public void timGiamDocCoPhanMax() {
		if (this.dsNhanSu.size() != 0) {
			List<NhanSu> dsgd = this.LaydsNhanSu(GIAMDOC);
			if (dsgd.size() != 0) {
				List<GiamDoc> dsgd_max = timGiamDocCoPhan_MaxChiTiet(dsgd);
				if (dsgd_max.size() != 0) {
					System.out.println("Đây là danh sách giám đốc có cổ phần cao nhất: ");
					for (GiamDoc gd : dsgd_max) {
						gd.xuatMavaTen();
					}
					System.out.println("Với số cổ phần là: " + dsgd_max.get(0).getSoCoPhan() + "%");
				}
			} else {
				System.out.println("Hiện tại danh sách giám đốc đang rỗng. Yêu cầu nhập thêm giám đốc");
			}
		} else {
			System.out.println("Danh sách nhân viên đang rỗng! yêu cầu nhập thêm nhân viên");
		}
	}

	// 14. Sửa lại doanh thu tháng của công ty============================= >>>
	public void suaDoanhThuThangCongTy(Scanner scanner) {
		System.out.print("Vui lòng nhập lại doanh thu tháng của công ty: ");
		setDoanhThuThang(Float.parseFloat(scanner.nextLine()));
	}

	// 15. Xem tổng thu nhập của từng giám đốc============================= >>>
	public void xuatTongThuNhapTungGiamDoc() {
		if (this.dsNhanSu.size() != 0) {
			List<NhanSu> dsgd = this.LaydsNhanSu(GIAMDOC);
			if (dsgd.size() != 0) {
				this.tinhLoiNhuanCty();
				// System.out.println(this.loiNhuan);
				System.out.println("Lợi nhuận của toàn cty là: " + this.loiNhuan);
				System.out.println("Đây là danh sách giám đốc đã đươc tính thu nhập.");
				inTable();
				for (NhanSu gd : dsgd) {
					double thuNhap = (gd.tinhLuong() + (((GiamDoc) gd).getSoCoPhan() / 100) * this.loiNhuan);
					((GiamDoc) gd).xuatThongTinThuNhap(thuNhap);
				}
			} else {
				System.out.println("Hiện tại danh sách giám đốc đang rỗng. Yêu cầu nhập thêm giám đốc");
			}
		} else {
			System.out.println("Danh sách nhân vien đang rỗng! yêu cầu nhập thêm nhân viên");
		}
	}

	public void tinhLoiNhuanCty() {
		this.tinhTongLuong();
		this.loiNhuan = this.doanhThuThang - this.tongLuongCongTy;
	}

	public void inTable() {
		System.out.println(String.format(" %10s  ", "Mã số") + String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại") + String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản") + String.format("%17s  ", "Lương")
				+ String.format("%16s", "Chức vụ") + String.format("%25s  ", "Số nhân viên/Cổ phần"));
		helper.drawLine(72);
		System.out.println();
	}

	// nested class
	private class Helper {
		public String generateId() {
			return tenVietTat + OffsetDateTime.now().getYear() + getStt(4);
		}

		public String getStt(int length) {
			String result = "";
			int i = 1;

			while (STT / (int) Math.pow(10, length - i) == 0) {
				result += "0";
				i++;
			}
			result += STT;
			STT++;

			return result;
		}

		public boolean daTonTaiNhanSu(NhanSu ns) {
			for (NhanSu nhanSu : dsNhanSu) {
				if (nhanSu.getSoDt().equalsIgnoreCase(ns.getSoDt()))
					return true;
			}
			return false;
		}

		private void drawLine(int num) {
			for (int i = 0; i < num; i++) {
				System.out.print("- ");
			}
		}
	}

}
