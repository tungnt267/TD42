import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachSinhVien {
	private List<SinhVien> danhSachSinhVien;

	public DanhSachSinhVien() {
		this.danhSachSinhVien = new ArrayList<SinhVien>();
	}

	public void themSinhVien(SinhVien sv) {
		this.danhSachSinhVien.add(sv);
	}

	public SinhVien svDiemTBCaoNhat() {
		SinhVien kq = this.danhSachSinhVien.get(0);
		header();
		for (SinhVien sv : this.danhSachSinhVien) {
			if (sv.getDiemTB() > kq.getDiemTB()) {
				kq = sv;
			}
		}
		return kq;
	}

	public void tatCaSVYeu() {
		int stt = 0;
		header();
		for (SinhVien sv : this.danhSachSinhVien) {
			if (sv.getDiemTB() < 5) {
				stt++;
				sv.xuatSinhVien(stt);
			}
		}
		if (stt == 0) {
			System.out.println("\t\t\tKhong co SV loai yeu!");
		}
	}

	public List<SinhVien> timSVTheoTen(String ten) {
		List<SinhVien> kq = new ArrayList<SinhVien>();
		header();
		for (SinhVien sv : this.danhSachSinhVien) {
			if (sv.getTenSV().toLowerCase().equals(ten.toLowerCase())) {
				kq.add(sv);
			}
		}
		return kq;
	}

	public SinhVien timSVTheoMa(int maSV) {
		SinhVien kq = null;
		for (SinhVien sv : this.danhSachSinhVien) {
			if (sv.getMaSV() == maSV) {
				kq = sv;
				break;
			}
		}
		return kq;
	}

	public void xoaMotSVTheoMa(int maSV) {
		Scanner scan = new Scanner(System.in);
		char chon;
		int stt = 0;
		for (SinhVien sv : this.danhSachSinhVien) {
			if (sv.getMaSV() == maSV) {
				stt++;
				System.out.println("Ban co chac chan muon xoa? Chon 'N' hoac 'N'");
				chon = scan.nextLine().charAt(0);
				switch (chon) {
				case 'Y':
					this.danhSachSinhVien.remove(sv);
					System.out.println("Ban da xoa SV co ma: " + maSV);
					break;
				case 'N':
					break;
				default:
					break;
				}
			}
		}
		if (stt == 0) {
			header();
			System.out.println("\t\t\t Khong tim thay SV de xoa!");
		}
	}

	public void xuatTatCaSinhVien() {
		int stt = 0;
		header();
		for (SinhVien sv : this.danhSachSinhVien) {
			stt++;
			sv.xuatSinhVien(stt);
		}
	}

	public void header() {
		System.out.println(
				"\n-------------------------------------------------------------THONG TIN SINH VIEN--------------------------------------------------------------\n");
		System.out.print("STT \t|");
		System.out.print("Ma sinh vien \t|");
		System.out.print("Ten sinh vien \t\t|");
		System.out.print("Diem Toan \t|");
		System.out.print("Diem Ly \t|");
		System.out.print("Diem Hoa \t|");
		System.out.print("Diem TB \t\t|");
		System.out.print("Xep loai \t");
		underline();
	}

	public void underline() {
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------------------------------------");
	}
}
