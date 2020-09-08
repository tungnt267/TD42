import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class ThuVien {
	// 1. Thuộc tính
	private LinkedList<Sach> dsSach;

	// 2. Khởi tạo
	public ThuVien() {
		this.dsSach = new LinkedList<Sach>();
	}

	public ThuVien(LinkedList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	// 3. Get, set
	public LinkedList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(LinkedList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	// 4. Nhập, xuất
	public void khoiTaoDuLieu() {
		Sach sgk1 = new SachGiaoKhoa("sgk1", "05-09-2020", 20000, 15, "Y", "Mới");
		Sach sgk2 = new SachGiaoKhoa("sgk2", "02-09-2020", 50000, 10, "X", "Cũ");
		Sach sgk3 = new SachGiaoKhoa("sgk3", "03-09-2020", 30000, 20, "X", "Mới");
		Sach sgk4 = new SachGiaoKhoa("sgk4", "01-09-2020", 10000, 5, "Z", "Cũ");
		Sach stk1 = new SachThamKhao("stk1", "04-09-2020", 30000, 15, "X", 5000);
		Sach stk2 = new SachThamKhao("stk2", "05-09-2020", 60000, 15, "Y", 3000);
		Sach stk3 = new SachThamKhao("stk3", "31-08-2020", 10000, 15, "Z", 1000);

		this.dsSach.add(sgk1);
		this.dsSach.add(sgk2);
		this.dsSach.add(sgk3);
		this.dsSach.add(sgk4);
		this.dsSach.add(stk1);
		this.dsSach.add(stk2);
		this.dsSach.add(stk3);
	}

	public void xuat() {
		for (Sach sach : this.dsSach) {
			sach.xuat();
		}
	}

	// 5. Nghiệp vụ
	// Thêm một sách
	public void themSach() {
		Scanner scan = new Scanner(System.in);
		String chontiepTuc = null;
		do {
			String loai = null;
			System.out.print("sgk: Nhập thông tin sách giáo khoa - stk: Nhập thông sách tham khảo: ");
			System.out.print("\nvui lòng nhập loại cần nhập: ");
			do {
				loai = scan.nextLine();
				if (!loai.equalsIgnoreCase("sgk") && !loai.equalsIgnoreCase("stk")) {
					System.out.print("Loại sách không hợp lệ! Vui lòng nhập lại: ");
				}
			} while (!loai.equalsIgnoreCase("sgk") && !loai.equalsIgnoreCase("stk"));

			Sach sach = null;
			if (loai.equalsIgnoreCase("sgk")) {
				sach = new SachGiaoKhoa();
			} else if (loai.equalsIgnoreCase("stk")) {
				sach = new SachThamKhao();
			}
			sach.nhap();
			this.dsSach.add(sach);

			System.out.print("Bạn có muốn nhập tiếp không? Nhấn 'y' để tiếp: ");
			chontiepTuc = scan.nextLine();
		} while (chontiepTuc.equalsIgnoreCase("y"));
	}

	// Tính tổng thành tiền sách giáo khoa
	public double tinhTongTienSachGiaoKhoa() {
		double tongTienSGK = 0;
		for (Sach sach : this.dsSach) {
			if (sach instanceof SachGiaoKhoa) {
				tongTienSGK += ((SachGiaoKhoa) sach).tinhTienSach();
			}
		}
		return tongTienSGK;
	}

	// Tính tổng thành tiền sách tham khảo
	public double tinhTongTienSachThamKhao() {
		double tongTienSTK = 0;
		for (Sach sach : this.dsSach) {
			if (sach instanceof SachThamKhao) {
				tongTienSTK += ((SachThamKhao) sach).tinhTienSach();
			}
		}
		return tongTienSTK;
	}

	// Tính trung bình cộng đơn giá của các sách tham khảo
	public double tinhTBCongDonGiaSTK() {
		double trungBinhCong;
		int demSTK = 0;
		double tongDongia = 0;
		for (Sach sach : this.dsSach) {
			if (sach instanceof SachThamKhao) {
				demSTK++;
				tongDongia += sach.getDonGia();
			}
		}
		if (demSTK == 0) {
			trungBinhCong = -1;
		} else {
			trungBinhCong = tongDongia / demSTK;
		}
		return trungBinhCong;
	}

	// Tìm sách giáo khoa của nhà xuất bản X
	public ThuVien timSGKNhaXuatBanX() {
		int demSGKX = 0;
		ThuVien dsKetQua = new ThuVien();
		for (Sach sach : this.dsSach) {
			if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase("x")) {
				demSGKX++;
				dsKetQua.getDsSach().add(sach);
			}
		}
		if (demSGKX == 0) {
			return null;
		}
		return dsKetQua;
	}
}
