import java.util.Scanner;

/**
 * 
 */

/**
 * @author thanhtung Ngay tao: 22-08-2020
 * 
 */
public class HinhTron {
	// 1. Thuoc tinh - attributes
	private float banKinh;

	// 2. Khoi tao - constructors
	public HinhTron() {

	}

	public HinhTron(float banKinh) {
		this.banKinh = banKinh;
	}
	// 3. get, set

	// 4. nhap, xuat - Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ban kinh hinh tron: ");
		this.banKinh = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		System.out.print("\nBan kinh: " + this.banKinh);
	}

	// 5. nghiep vu - bussiness methods
	public float tinhChuVi() {
		return 2 * (float) Math.PI * this.banKinh;
	}

	public float tinhDienTich() {
		return (float) Math.PI * (float) Math.pow(this.banKinh, 2);
	}
}
