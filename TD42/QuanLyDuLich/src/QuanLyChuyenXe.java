import java.util.ArrayList;
import java.util.List;

public class QuanLyChuyenXe {

	private List<ChuyenXe> danhSachChuyenXe;
	private float tongDoanhThu = 0;
	private float tongDoanhThuNoiThanh = 0;
	private float tongDoanhThuNgoaiThanh = 0;

	public List<ChuyenXe> getDanhSachChuyenXe() {
		return danhSachChuyenXe;
	}

	public void setDanhSachChuyenXe(List<ChuyenXe> danhSachChuyenXe) {
		this.danhSachChuyenXe = danhSachChuyenXe;
	}

	public float getTongDoanhThu() {
		return tongDoanhThu;
	}

	public void setTongDoanhThu(float tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}

	public float getTongDoanhThuNoiThanh() {
		return tongDoanhThuNoiThanh;
	}

	public void setTongDoanhThuNoiThanh(float tongDoanhThuNoiThanh) {
		this.tongDoanhThuNoiThanh = tongDoanhThuNoiThanh;
	}

	public float getTongDoanhThuNgoaiThanh() {
		return tongDoanhThuNgoaiThanh;
	}

	public void setTongDoanhThuNgoaiThanh(float tongDoanhThuNgoaiThanh) {
		this.tongDoanhThuNgoaiThanh = tongDoanhThuNgoaiThanh;
	}

	public QuanLyChuyenXe() {
		// TODO Auto-generated constructor stub
		this.danhSachChuyenXe = new ArrayList<ChuyenXe>();

	}

	public QuanLyChuyenXe(List<ChuyenXe> _danhSachChuyenXe) {
		this.danhSachChuyenXe = _danhSachChuyenXe;
	}

	public void themChuyenXe(ChuyenXe xe) {
		this.danhSachChuyenXe.add(xe);
	}

	public void tinhDoanhThuChuyenXeNoiThanh() {
		for (ChuyenXe chuyenXe : this.danhSachChuyenXe) {
			if (chuyenXe instanceof ChuyenXeNoiThanh) {
				this.tongDoanhThuNoiThanh += chuyenXe.tinhDoanhThu();
			}
		}
		System.out.println("Tong doanh thu xe noi thanh: " + this.tongDoanhThuNoiThanh);

	}

	public void tinhDoanhThuChuyenXeNgoaiThanh() {
		for (ChuyenXe chuyenXe : this.danhSachChuyenXe) {
			if (chuyenXe instanceof ChuyenXeNgoaiThanh) {
				this.tongDoanhThuNgoaiThanh += chuyenXe.tinhDoanhThu();
			}
		}
		System.out.println("Tong doanh thu xe ngoai thanh: " + this.tongDoanhThuNgoaiThanh);

	}

	public void tinhTongDoanhThu() {
		for (ChuyenXe chuyenXe : this.danhSachChuyenXe) {
			this.tongDoanhThu += chuyenXe.tinhDoanhThu();
		}
		System.out.println("Tong doanh thu: " + this.tongDoanhThu);

	}

	public void xuatCacChuyenXe() {
		header("NOI THANH", "So tuyen \t|", "So km \t|");
		for (ChuyenXe chuyenXe : this.danhSachChuyenXe) {
			if (chuyenXe instanceof ChuyenXeNoiThanh) {
				chuyenXe.xuat();
			}
		}

		header("NGOAI THANH", "Noi den \t|", "So ngay di duoc \t|");
		for (ChuyenXe chuyenXe : this.danhSachChuyenXe) {
			if (chuyenXe instanceof ChuyenXeNgoaiThanh) {
				chuyenXe.xuat();
			}
		}
	}

	public void header(String chuyenXe, String thongTin1, String thongTin2) {
		System.out.println(
				"----------------------------THONG TIN CHUYEN XE " + chuyenXe + "----------------------------------");
		System.out.print("Ma chuyen xe \t|");
		System.out.print("Ten tai xe \t\t|");
		System.out.print("Bien so xe \t|");
		System.out.println(thongTin1);
		System.out.println(thongTin2);
	}
}
