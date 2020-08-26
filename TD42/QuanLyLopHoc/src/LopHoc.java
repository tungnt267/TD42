import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung Ngay tao: 23-08-2020
 *
 */
public class LopHoc {
	// 1. Thuoc tinh
	private String maLop;
	private String tenLop;
	private LinkedList<HocSinh> dsHocSinh;

	// 2. Khoi tao
	public LopHoc() {
		dsHocSinh = new LinkedList<HocSinh>();
	}

	public LopHoc(String maLop, String tenLop, LinkedList<HocSinh> dsHocSinh) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.dsHocSinh = dsHocSinh;
	}

	// 3. get, set
	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public LinkedList<HocSinh> getDsHocSinh() {
		return dsHocSinh;
	}

	public void setDsHocSinh(LinkedList<HocSinh> dsHocSinh) {
		this.dsHocSinh = dsHocSinh;
	}

	// 4. nhap, xuat
	public void nhap() {

	}

	public void khoiTaoDuLieu() {
		HocSinh hs1 = new HocSinh("hs1", "Hoc sinh 1", 1.0f, 2.0f);
		HocSinh hs2 = new HocSinh("hs2", "Hoc sinh 2", 3.0f, 4.0f);
		HocSinh hs3 = new HocSinh("hs3", "Hoc sinh 2", 6.0f, 5.0f);
		HocSinh hs4 = new HocSinh("hs4", "Hoc sinh 4", 7.0f, 8.0f);
		HocSinh hs5 = new HocSinh("hs5", "Hoc sinh 5", 9.0f, 8.0f);
		HocSinh hs6 = new HocSinh("hs6", "Hoc sinh 6", 8.0f, 9.0f);

		this.dsHocSinh.add(hs1);
		this.dsHocSinh.add(hs2);
		this.dsHocSinh.add(hs3);
		this.dsHocSinh.add(hs4);
		this.dsHocSinh.add(hs5);
		this.dsHocSinh.add(hs6);
	}

	public void xuat() {
		// cach 1 - for i
		for (int i = 0; i < this.dsHocSinh.size(); i++) {
			this.dsHocSinh.get(i).xuat();
		}
		// cach 2 - foreach
		for (HocSinh hs : this.dsHocSinh) {
			hs.xuat();
		}
	}

	// OverLoad
	public void xuat(LinkedList<HocSinh> danhSach) {
		for (HocSinh hs : danhSach) {
			hs.xuat();
		}
	}

	// 5. nghiep vu
	// Tim diem trung binh max
	public float timDiemTBMax() {
		float diemTBMax = this.dsHocSinh.get(0).tinhDiemTB();
		for (int i = 0; i < this.dsHocSinh.size(); i++) {
			if (this.dsHocSinh.get(i).tinhDiemTB() > diemTBMax) {
				diemTBMax = this.dsHocSinh.get(i).tinhDiemTB();
			}
		}
		return diemTBMax;
	}

	// Tim hoc sinh co diem TB max
	public LinkedList<HocSinh> timHocSinhCoDTBMax() {
		LinkedList<HocSinh> dsDiemTBMax = new LinkedList<HocSinh>();
		for (HocSinh hs : this.dsHocSinh) {
			if (hs.tinhDiemTB() == this.timDiemTBMax()) {
				dsDiemTBMax.add(hs);
			}
		}
		return dsDiemTBMax;
	}

	// Tim danh sach hoc sinh co xep loai yeu
	public LinkedList<HocSinh> timDSHocSinhYeu() {
		LinkedList<HocSinh> dsXepLoaiYeu = new LinkedList<HocSinh>();
		for (HocSinh hs : this.dsHocSinh) {
			if (hs.xepLoai().equalsIgnoreCase("Yeu")) {
				dsXepLoaiYeu.add(hs);
			}
		}
		return dsXepLoaiYeu;
	}

	// Tim hoc sinh theo ten
	public LinkedList<HocSinh> timHocSinhTheoTen() {
		// Nhap ten
		Scanner scan = new Scanner(System.in);
		System.out.print("\nNhap ten can tim: ");
		String tenCanTim = scan.nextLine();
		// Tim theo ten
		int count = 0;
		LinkedList<HocSinh> dsKetQua = new LinkedList<HocSinh>();
		for (HocSinh hs : this.dsHocSinh) {
			if (hs.getHoTenHocSinh().equalsIgnoreCase(tenCanTim)) {
				dsKetQua.add(hs);
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Khong tim thay hoc sinh nao co ten nhu tren!");
		}
		return dsKetQua;
	}

	// Tim hoc sinh theo ma
	public HocSinh timHocSinhTheoMa() {
		// Nhap ma
		Scanner scan = new Scanner(System.in);
		System.out.print("\nNhap ma hoc sinh can tim: ");
		String maCanTim = scan.nextLine();
		// Tim theo ma
		HocSinh ketQua = new HocSinh();
		for (HocSinh hs : this.dsHocSinh) {
			if (hs.getMaHocSinh().equalsIgnoreCase(maCanTim)) {
				ketQua = hs;
				return ketQua;
			}
		}
		return ketQua;
	}

	// Xoa hoc sinh theo ma
	public boolean xoaHocSinhTheoMa() {
		HocSinh hs = new HocSinh();
		hs = timHocSinhTheoMa();
		if (hs.getMaHocSinh() != null) {
			this.dsHocSinh.remove(hs);
			return true;
		}
		return false;
	}
}
