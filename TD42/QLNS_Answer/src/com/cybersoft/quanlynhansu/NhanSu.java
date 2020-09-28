package com.cybersoft.quanlynhansu;

import java.util.Scanner;

public abstract class NhanSu {
	/* properties */
	protected String maSo;
	protected String hoTen;
	protected String soDt;
	protected float soNgayLamViec;
	protected float luongMotNgay;
	protected double luongThang;

	/* constructor */
	public NhanSu(String maSo, String hoTen, String soDt, float soNgayLamViec, float luongMotNgay) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDt = soDt;
		this.soNgayLamViec = soNgayLamViec;
		this.luongMotNgay = luongMotNgay;
	}

	public NhanSu() {
		this.maSo = "";
		this.hoTen = "";
		this.soDt = "";
	}

	/* getters, setters */
	public String getMaSo() {
		return this.maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getSoDt() {
		return this.soDt;
	}

	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	public double getLuongThang() {
		return luongThang = tinhLuong();
	}

	public void setLuongThang(double luongThang) {
		this.luongThang = luongThang;
	}

	public String getThongTinThem() {
		return "";
	}

	public void setThongTinThem(String thongTinThem) {
		thongTinThem = this.getThongTinThem();
	}

	/* methods */
	public void nhapThongTin(Scanner scan) {
		System.out.print("Nhập vào MÃ nhân viên: ");
		this.maSo = scan.nextLine();
		System.out.print("Nhập vào HỌ TÊN nhân viên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Nhập vào SỐ ĐIỆN THOẠI nhân viên: ");
		this.soDt = scan.nextLine();
		System.out.print("Nhập vào SỐ NGÀY LÀM VIỆC của nhân viên: ");
		this.soNgayLamViec = Float.parseFloat(scan.nextLine());
	}

	public void xuatThongTin() {
		System.out.println(String.format("%10s |", maSo) + String.format("%16s |", hoTen)
				+ String.format("%16s |", soDt) + String.format("%12.2f |", soNgayLamViec)
				+ String.format("%16.2f |", luongMotNgay) + String.format("%17.2f |", tinhLuong())
				+ String.format("%16s |", getChucVu()) + String.format("%25s |", getThongTinThem()));
	}

	public double tinhLuong() {
		return this.luongThang = (this.soNgayLamViec * this.luongMotNgay);
	}

	public String getChucVu() {
		return "Nhân sự";
	}

}
