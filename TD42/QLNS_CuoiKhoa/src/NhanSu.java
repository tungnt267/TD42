import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public abstract class NhanSu {
	// 1. Thuộc tính
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgay;
	protected float luong1Ngay;

	// 2. Khởi tạo
	public NhanSu() {
		this.maSo = null;
		this.hoTen = null;
		this.soDienThoai = null;
		this.soNgay = 0;
		this.luong1Ngay = 0;
	}

	public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgay) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgay = soNgay;
//		this.luong1Ngay = 0;
	}

	// 3. get, set
	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	public float getLuong1Ngay() {
		return luong1Ngay;
	}

	public void setLuong1Ngay(float luong1Ngay) {
		this.luong1Ngay = luong1Ngay;
	}

	// 4. Nhập, xuất
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào mã số: ");
		this.maSo = scan.nextLine();
		System.out.print("Vui lòng nhập vào họ tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Vui lòng nhập vào số điện thoại: ");
		this.soDienThoai = scan.nextLine();
		System.out.print("Vui lòng nhập vào số ngày làm việc: ");
		do {
			this.soNgay = Integer.parseInt(scan.nextLine());
			if (this.soNgay < 0 || this.soNgay > 31) {
				System.out.println("Vui lòng nhập số ngày làm việc trong khoảng 1-31: ");
			}
		} while (this.soNgay < 0 || this.soNgay > 31);
	}

	public void xuat() {
		System.out.print("\n\nMã số: " + this.maSo);
		System.out.print("\nHọ tên: " + this.hoTen);
		System.out.print("\nSố điện thoại: " + this.soDienThoai);
		System.out.print("\nSố ngày làm việc: " + this.soNgay);
		System.out.print("\nLương 1 ngày: " + this.luong1Ngay);
	}

	// 5. Nghiệp vụ
	public abstract float tinhLuong();

	// Tách lấy tên
	public String tachLayTen() {
		String ten = null;
		int viTriKhoangTrangCuoi = deAccent(this.hoTen).trim().lastIndexOf(" ");
		ten = deAccent(this.hoTen).substring(viTriKhoangTrangCuoi + 1, deAccent(this.hoTen).length());
		return ten;
	}

	public static String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
