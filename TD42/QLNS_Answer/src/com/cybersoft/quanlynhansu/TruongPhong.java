package com.cybersoft.quanlynhansu;

public class TruongPhong extends NhanSu {
	/* properties */
	private int soNhanVien;
	private final int PHUCAP = 100;

	// constructors
	public TruongPhong(String maSo, String hoTen, String soDt, float soNgayLamViec, float luongMotNgay,
			int soNhanVien) {
		super(maSo, hoTen, soDt, soNgayLamViec, luongMotNgay);
		this.soNhanVien = soNhanVien;
	}

	public TruongPhong() {
		super();
		luongMotNgay = 200;
	}

	// getter / setter
	public int getSoNhanVien() {
		return this.soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	@Override
	public String getChucVu() {
		return "Trưởng phòng";
	}

	@Override
	public String getThongTinThem() {
		return String.valueOf(soNhanVien);
	}
	
	@Override
	public void setThongTinThem(String thongTinThem) {
		thongTinThem = getThongTinThem();
	}

	/* methods */
	@Override
	public double tinhLuong() {
		double luong = this.luongMotNgay * this.soNgayLamViec + PHUCAP * this.soNhanVien;
		return luong;
	}

	public void tangNhanVien() {
		this.soNhanVien++;
	}

	public void giamNhanVien() {
		this.soNhanVien--;
	}

	public void xuatMavaTen() {
		System.out.println("\tTrưởng phòng -- MãNV: " + this.getMaSo() + "\t Tên: " + this.getHoTen());
	}
}
