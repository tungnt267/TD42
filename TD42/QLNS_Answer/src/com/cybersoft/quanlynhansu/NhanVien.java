package com.cybersoft.quanlynhansu;

public class NhanVien extends NhanSu {
	/* properties */
	private String truongPhong;

	/* constructors */
	public NhanVien(String maSo, String hoTen, String soDt, float soNgayLam, float luongMotNgay) {
		super(maSo, hoTen, soDt, soNgayLam, luongMotNgay);
	}

	public NhanVien() {
		super();
		luongMotNgay = 100;
	}

	/* getter/setter */
	public String getTruongPhong() {
		return this.truongPhong;
	}

	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}

	@Override
	public String getChucVu() {
		return "Nhân viên";
	}

	@Override
	public String getThongTinThem() {
		return this.truongPhong;
	}
	
	@Override
	public void setThongTinThem(String thongTinThem) {
		thongTinThem = getThongTinThem();
	}

	/* methods */
	public void xuatMavaTen() {
		System.out.println("\tNhân Viên thường -- Mã: " + this.getMaSo() + "\t Tên: " + this.getHoTen());
	}

}
