import java.util.Scanner;

public class SinhVien {
	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public Float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(Float diemToan) {
		this.diemToan = diemToan;
	}

	public Float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(Float diemLy) {
		this.diemLy = diemLy;
	}

	public Float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(Float diemHoa) {
		this.diemHoa = diemHoa;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	private int maSV;
	private String tenSV;
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	private float diemTB = 0;
	private String xepLoai = "Chua xep loai";

	public SinhVien() {

	}

	public SinhVien(int maSV, String tenSV, float diemToan, float diemLy, float diemHoa) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;

	}

	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}

	public void xepLoai() {
		if (this.diemTB <= 10 && this.diemTB >= 9) {
			this.xepLoai = "Xuat Sac";
		} else if (this.diemTB < 9 && this.diemTB >= 8) {
			this.xepLoai = "Gioi";
		} else if (this.diemTB < 8 && this.diemTB >= 7) {
			this.xepLoai = "Kha";
		} else if (this.diemTB < 7 && this.diemTB >= 6) {
			this.xepLoai = "Trung Binh Kha";
		} else if (this.diemTB < 6 && this.diemTB >= 5) {
			this.xepLoai = "Trung Binh";
		} else {
			this.xepLoai = "Yeu";
		}
	}

	public void nhapSinhVien(int stt) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap sinh vien thu: " + stt);
		System.out.println("\tNhap vao ma sinh vien: ");
		this.maSV = Integer.parseInt(scan.nextLine());

		System.out.println("\tNhap vao ten sinh vien: ");
		this.tenSV = scan.nextLine();

		this.diemToan = kiemTraDiemHopLe("toan");
		this.diemLy = kiemTraDiemHopLe("ly");
		this.diemHoa = kiemTraDiemHopLe("hoa");
	}

	public float kiemTraDiemHopLe(String monHoc) {
		Scanner scan = new Scanner(System.in);
		float diem;
		do {
			System.out.println("\tNhap diem " + monHoc + " tu 0 - 10: ");
			diem = Float.parseFloat(scan.nextLine());
			if (diem > 10 || diem < 0) {
				System.out.println("Diem khong hop le!");
			}
		} while (diem > 10 || diem < 0);
		return diem;
	}

	public void xuatSinhVien(int stt) {
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		System.out.print(stt + "\t|");
		System.out.print(this.maSV + "\t\t|");
		System.out.print(this.tenSV + "\t\t\t|");
		System.out.print(this.diemToan + "\t\t|");
		System.out.print(this.diemLy + "\t\t|");
		System.out.print(this.diemHoa + "\t\t|");
		System.out.print(this.diemTB + "\t\t\t|");
		System.out.print(this.xepLoai + "\t\t");
		dssv.underline();
	}
}
