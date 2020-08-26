import java.util.Scanner;

/**
 * Lop hinh chu nhat co chieu dai va chieu rong
 */

/**
 * @author thanhtung
 * Ngay tao: 22-08-2020
 * Phien ban: 1.0
 */
public class HinhChuNhat {
	// 1. Thuoc tinh - attributes
	private float chieuDai;
	private float chieuRong;
	// 2. Khoi tao - constructors
	public HinhChuNhat() {
		this.chieuDai = 1;
		this.chieuDai = 1;
	}
	public HinhChuNhat(float chieuDai, float chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	// 3. get, set
	
	// 4. nhap, xuat - Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap chieu dai HCN: ");
		this.chieuDai = Float.parseFloat(scan.nextLine());
		System.out.print("Nhap chieu rong HCN: ");
		this.chieuRong = Float.parseFloat(scan.nextLine());
	}
	
	public void xuat() {
		System.out.print("\nChieu dai: " + this.chieuDai);
		System.out.print("\nChieu rong: " + this.chieuRong);
	}
	// 5. nghiep vu - bussiness methods
	public float tinhChuVi() {
		return (this.chieuDai + this.chieuRong) * 2;
	}
	public float tinhDienTich() {
		return this.chieuDai * this.chieuRong;
	}
}
