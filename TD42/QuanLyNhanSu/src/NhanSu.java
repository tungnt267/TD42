import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Lớp đối tượng nhân sự
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 28-08-2020
 */
public abstract class NhanSu {
	// 1. Thuộc tính
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected float luongMotNgay;

	// 2. Khởi tạo
	public NhanSu() {
		this.maSo = null;
		this.hoTen = null;
		this.soDienThoai = null;
		this.soNgayLamViec = 0;
		this.luongMotNgay = 0;
	}

	public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
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

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	// 4. Nhập, xuất
	public void nhap(String chucVu) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào mã số " + chucVu + ": ");
		this.maSo = scan.nextLine();
		System.out.print("Vui lòng nhập vào họ tên " + chucVu + ": ");
		this.hoTen = scan.nextLine();
		System.out.print("Vui lòng nhập vào số điện thoại " + chucVu + ": ");
		this.soDienThoai = scan.nextLine();
		System.out.print("Vui lòng nhập vào số ngày làm việc " + chucVu + ": ");
		do {
			this.soNgayLamViec = Integer.parseInt(scan.nextLine());
			if (this.soNgayLamViec < 0 || this.soNgayLamViec > 31) {
				System.out.print("Vui lòng nhập số ngày làm việc trong khoảng 0-31: ");
			}
		} while (this.soNgayLamViec < 0 || this.soNgayLamViec > 31);
	}

	public void xuat(int stt) {
		System.out.print("\n" + String.format("%-4s", stt) + "|");
		System.out.print(String.format("%-12s", this.maSo) + "|");
		System.out.print(String.format("%-25s", this.hoTen) + "|");
		System.out.print(String.format("%-14s", this.soDienThoai) + "|");
		System.out.print(String.format("%-17s", this.soNgayLamViec) + "|");
		System.out.print(String.format("%-15s", this.luongMotNgay) + "|");
	}

	// 5. Nghiệp vụ
	// Tính lương tháng
	public abstract float tinhLuong();

	// Tách lấy tên
	public String tachLayTen() {
		String ten = null;
		int viTriKhoangTrangCuoi = deAccent(this.hoTen).trim().lastIndexOf(" ");
		ten = deAccent(this.hoTen).substring(viTriKhoangTrangCuoi + 1, deAccent(this.hoTen).length());
		return ten;
	}

	// Chuyển đổi chuỗi String tiếng Việt có dấu thành không dấu
	public static String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
