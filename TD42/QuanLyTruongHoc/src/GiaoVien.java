import java.time.LocalDate;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung
 *
 */
public class GiaoVien extends Nguoi {

	// 1. Thuoc tinh
	private int namBatDau;
	private String chuyenMon;

	// 2. Khoi tao
	public GiaoVien() {
		super();
		this.namBatDau = 0;
		this.chuyenMon = null;
	}

	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi, int namBatDau, String chuyenMon) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.namBatDau = namBatDau;
		this.chuyenMon = chuyenMon;
	}

	// 3. Get, set
	public int getNamBatDau() {
		return namBatDau;
	}

	public void setNamBatDau(int namBatDau) {
		this.namBatDau = namBatDau;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	// 4. Nhap, xuat
	@Override
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		super.nhap();
		System.out.print("Vui lòng nhập vào năm bắt đầu: ");
		this.namBatDau = Integer.parseInt(scan.nextLine());
		System.out.print("Vui lòng nhập vào chuyen môn: ");
		this.chuyenMon = scan.nextLine();
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Năm bắt đầu: " + this.namBatDau);
		System.out.println("Chuyên môn: " + this.chuyenMon);
	}

	// 5. Tính thâm niên
	public int tinhThamNien() {
		LocalDate currentDate = LocalDate.now();
		int thamNien = currentDate.getYear() - this.namBatDau;
		return thamNien;
	}
}
