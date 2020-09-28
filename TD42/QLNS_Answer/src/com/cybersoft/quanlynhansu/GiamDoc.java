package com.cybersoft.quanlynhansu;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	/* properties */
	private float soCoPhan;

	/* constructors */
	public GiamDoc(String maSo, String hoTen, String soDt, float soNgayLamViec, float luongMotNgay, float soCoPhan) {
		super(maSo, hoTen, soDt, soNgayLamViec, luongMotNgay);
		this.soCoPhan = soCoPhan;
	}

	public GiamDoc() {
		super();
		luongMotNgay = 300;
	}

	/* getter / setter */
	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

	@Override
	public String getChucVu() {
		return "Giám đốc";
	}

	@Override
	public String getThongTinThem() {
		return String.valueOf(soCoPhan);
	}
	
	@Override
	public void setThongTinThem(String thongTinThem) {
		thongTinThem = getThongTinThem();
	}

	/* methods */
	@Override
	public void nhapThongTin(Scanner scan) {
		super.nhapThongTin(scan);
		do {
			System.out.print("Nhập vào CỔ PHẦN của Giám Đốc: ");
			this.soCoPhan = Float.parseFloat(scan.nextLine());
			if (this.soCoPhan <= 0 || this.soCoPhan > 100) {
				System.out.println("Cổ phần không quá 100%, vui lòng nhập lại");
			}
		} while (this.soCoPhan <= 0 || this.soCoPhan > 100);
	}

	@Override
	public double tinhLuong() {
		return super.tinhLuong();
	}

	public void xuatMavaTen() {
		System.out.println("\tGiám đốc -- Mã: " + this.getMaSo() + "\t Tên: " + this.getHoTen());
	}

	public void xuatThongTinThuNhap(double thuNhap) {
		super.xuatThongTin();
		System.out.println("\tsố Cổ Phần: " + this.soCoPhan + "%" + "\tLương/Ngày: " + this.luongMotNgay
				+ "\tcó Lương tháng là: " + this.tinhLuong() + "\t tổng Thu Nhập là: " + thuNhap);
		System.out.println(" ");
	}

}
