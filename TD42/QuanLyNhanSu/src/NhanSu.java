import java.util.Scanner;

/**
 * Lớp đối tượng nhân sự
 */

/**
 * @author thanhtung
 *
 *         Ngày tạo: 28-08-2020
 */
public class NhanSu {
	// 1. Thuộc tính
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected double luongThang;

	// 2. Khởi tạo
	public NhanSu() {
		this.maSo = null;
		this.hoTen = null;
		this.soDienThoai = null;
		this.soNgayLamViec = 0;
		this.luongThang = 0;
	}

	public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double luongThang) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
		this.luongThang = luongThang;
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

	public double getLuongThang() {
		return luongThang;
	}

	public void setLuongThang(double luongThang) {
		this.luongThang = luongThang;
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
				System.out.println("Vui lòng nhập số ngày làm việc trong khoảng 1-31: ");
			}
		} while (this.soNgayLamViec < 0 || this.soNgayLamViec > 31);
	}

	public void xuat(int stt) {
		System.out.print("\n" + stt + "\t|");
		System.out.print(this.maSo + "\t\t|");
		System.out.print(this.hoTen + "\t\t|");
		System.out.print(this.soDienThoai + "\t|");
		System.out.print(this.soNgayLamViec + "\t\t\t|");
	}

	// 5. Nghiệp vụ
	public double tinhLuong() {
		this.luongThang = 0;
		return this.luongThang;
	}

}
