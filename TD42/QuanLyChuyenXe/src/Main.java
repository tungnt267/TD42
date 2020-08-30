
public class Main {

	public static void main(String[] args) {
		CongTy ct = new CongTy();
		ct.khoiTaoDuLieu();
		System.out.println("\nTổng doanh thu chuyến xe: " + ct.tinhTongDoanhThu());
		System.out.println("\nTổng doanh thu chuyến xe nội thành: " + ct.tinhTongDoanhThuNoiThanh());
		System.out.println("\nTổng doanh thu chuyến xe ngoại thành: " + ct.tinhTongDoanhThuNgoaiThanh());
	}

}
