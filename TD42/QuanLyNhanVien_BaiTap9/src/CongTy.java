import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 29-08-2020
 */
public class CongTy {
	// 1. Thuộc tính
	private LinkedList<NhanVien> dsNhanVien;

	// 2. Khởi tạo
	public CongTy() {
		this.dsNhanVien = new LinkedList<NhanVien>();
	}

	public CongTy(LinkedList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	// 3. get, set
	public LinkedList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(LinkedList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	// 4. Nhập, xuất
	public void khoiTaoDuLieu() {
		NhanVien nv1 = new NhanVien("123", "Nguyen Van A", "01/01/1990", "Ha Noi", 1.5d);
		NhanVien nv2 = new NhanVien("789", "Nguyen Van B", "11/11/1991", "Sai Gon", 1);
		NhanVien nv3 = new NhanVien("003", "Nguyen Van C", "02/02/1992", "Sai Gon", 2);
		NhanVien nv4 = new NhanVien("004", "Nguyen Van D", "03/03/1993", "Ha Noi", 1.5);
		NhanVien nv5 = new NhanVien("005", "Nguyen Van E", "04/04/1994", "Sai Gon", 2d);
		NhanVien nv6 = new NhanVien("006", "Nguyen Van F", "05/05/1995", "Ha Noi", 1.5d);

		this.dsNhanVien.add(nv1);
		this.dsNhanVien.add(nv2);
		this.dsNhanVien.add(nv3);
		this.dsNhanVien.add(nv4);
		this.dsNhanVien.add(nv5);
		this.dsNhanVien.add(nv6);
	}

	public void xuat(LinkedList<NhanVien> danhSach) {
		for (NhanVien nv : danhSach) {
			nv.xuat();
		}
	}

	// 5. Nghiệp vụ
	private void inMenu() {
		System.out.println("+-----------------------------------------------+");
		System.out.println("|                      Menu                     |");
		System.out.println("|  1. Thêm một nhân viên                        |");
		System.out.println("|  2. Xuất danh sách nhân viên	                |");
		System.out.println("|  3. Tính tổng tiền lương của tất cả nhân viên |");
		System.out.println("|  4. Xuất nhân viên có lương cao nhất          |");
		System.out.println("|  0. Thoát chương trình                        |");
		System.out.println("+-----------------------------------------------+");
	}

	public void thucHien() {
		Scanner scan = new Scanner(System.in);
		boolean thoat = false;
		int luaChon;
		this.khoiTaoDuLieu();
		do {
			this.inMenu();
			System.out.print("Vui lòng chọn chức năng: ");
			luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				this.themNhanVien();
				break;
			case 2:
				System.out.println("---------------Danh sách nhân viên---------------");
				this.xuat(dsNhanVien);
				break;
			case 3:
				System.out.println("\nTổng lương của tất cả nhân viên là: " + this.tinhTongLuongNhanVien());
				break;
			case 4:
				LinkedList<NhanVien> dsKetQua = new LinkedList<NhanVien>();
				dsKetQua = this.timNVLuongMax();
				System.out.println("\nNhân viên có lương cao nhất là: ");
				this.xuat(dsKetQua);
				break;
			case 0:
				thoat = true;
				System.out.println("Chương trình kết thúc!");
				break;
			default:
				System.out.println("Vui lòng lựa chọn từ 0 - 4!");
			}
		} while (!thoat);
	}

	// Thêm một nhân viên
	public void themNhanVien() {
		NhanVien nv = new NhanVien();
		nv.nhap();
		this.dsNhanVien.add(nv);
		System.out.println("Đã thêm thành công!");
	}

	// Tính tổng lương của tất cả nhân viên
	public double tinhTongLuongNhanVien() {
		double tongLuong = 0;
		for (NhanVien nv : this.dsNhanVien) {
			tongLuong += nv.tinhLuongNhanVien();
		}
		return tongLuong;
	}

	// Tìm lương cao nhất
	public double timLuongMax() {
		double maxLuong = this.dsNhanVien.get(0).tinhLuongNhanVien();
		for (NhanVien nv : this.dsNhanVien) {
			if (nv.tinhLuongNhanVien() > maxLuong) {
				maxLuong = nv.tinhLuongNhanVien();
			}
		}
		return maxLuong;
	}

	// Tìm nhân viên có lương cao nhất
	public LinkedList<NhanVien> timNVLuongMax() {
		LinkedList<NhanVien> dsKetQua = new LinkedList<NhanVien>();
		for (NhanVien nv : this.dsNhanVien) {
			if (nv.tinhLuongNhanVien() == this.timLuongMax()) {
				dsKetQua.add(nv);
			}
		}
		return dsKetQua;
	}
}
