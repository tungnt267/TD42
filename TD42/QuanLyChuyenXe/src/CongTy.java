import java.util.LinkedList;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class CongTy {
	// 1. Thuộc tính
	private String tenCongTy;
	private LinkedList<ChuyenXe> dsChuyenXe;

	// 2. Khởi tạo
	public CongTy() {
		dsChuyenXe = new LinkedList<ChuyenXe>();
	}

	public CongTy(String tenCongTy, LinkedList<ChuyenXe> dsChuyenXe) {
		this.tenCongTy = tenCongTy;
		this.dsChuyenXe = dsChuyenXe;
	}

	// 3. get, set
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public LinkedList<ChuyenXe> getDsChuyenXe() {
		return dsChuyenXe;
	}

	public void setDsChuyenXe(LinkedList<ChuyenXe> dsChuyenXe) {
		this.dsChuyenXe = dsChuyenXe;
	}

	// 4. Nhập, xuất
	public void nhap() {

	}

	public void khoiTaoDuLieu() {
		ChuyenXe chuyen1 = new ChuyenXeNoiThanh("chuyen1", "A", "1234", 1000, 1, 10);
		ChuyenXe chuyen2 = new ChuyenXeNgoaiThanh("chuyen2", "B", "5678", 2000, "Củ Chi", 1);
		ChuyenXe chuyen3 = new ChuyenXeNoiThanh("chuyen3", "C", "3", 1000, 1, 10);
		ChuyenXe chuyen4 = new ChuyenXeNgoaiThanh("chuyen4", "D", "4", 2000, "Củ Chi", 1);
		ChuyenXe chuyen5 = new ChuyenXeNoiThanh("chuyen5", "E", "5", 1000, 1, 10);
		ChuyenXe chuyen6 = new ChuyenXeNgoaiThanh("chuyen6", "F", "6", 2000, "Củ Chi", 1);

		this.dsChuyenXe.add(chuyen1);
		this.dsChuyenXe.add(chuyen2);
		this.dsChuyenXe.add(chuyen3);
		this.dsChuyenXe.add(chuyen4);
		this.dsChuyenXe.add(chuyen5);
		this.dsChuyenXe.add(chuyen6);
	}

	public void xuat() {
		for (ChuyenXe chuyen : this.dsChuyenXe) {
			chuyen.xuat();
		}
	}

	// 5. Nghiệp vụ
	public double tinhTongDoanhThu() {
		double tong = 0;
		for (ChuyenXe chuyen : this.dsChuyenXe) {
			tong += chuyen.doanhThu;
		}
		return tong;
	}

	public double tinhTongDoanhThuNoiThanh() {
		double tong = 0;
		for (ChuyenXe chuyen : this.dsChuyenXe) {
			if (chuyen instanceof ChuyenXeNoiThanh) {
				tong += chuyen.doanhThu;
			}
		}
		return tong;
	}

	public double tinhTongDoanhThuNgoaiThanh() {
		double tong = 0;
		for (ChuyenXe chuyen : this.dsChuyenXe) {
			if (chuyen instanceof ChuyenXeNgoaiThanh) {
				tong += chuyen.doanhThu;
			}
		}
		return tong;
	}
}
