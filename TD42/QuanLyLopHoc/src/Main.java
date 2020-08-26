import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Nhap xuat
		LopHoc lopHoc = new LopHoc();
		lopHoc.khoiTaoDuLieu();
		lopHoc.xuat();

		// Diem TB Max
//		System.out.println("\nDiem TB Max la: " + lopHoc.timDiemTBMax());

//		// DS hoc sinh co diem TB Max
//		LinkedList<HocSinh> dsDiemTBMax = new LinkedList<HocSinh>();
//		dsDiemTBMax = lopHoc.timHocSinhCoDTBMax();
//		System.out.print("\nDanh sach hoc sinh co diem trung binh max: ");
//		lopHoc.xuat(dsDiemTBMax);
//
//		// DS hoc sinh co xep loai yeu
//		LinkedList<HocSinh> dsXepLoaiYeu = new LinkedList<HocSinh>();
//		dsXepLoaiYeu = lopHoc.timDSHocSinhYeu();
//		System.out.print("\nDanh sach hoc sinh co xep loai yeu: ");
//		lopHoc.xuat(dsXepLoaiYeu);

//		// Tim hoc sinh theo ten
//		LinkedList<HocSinh> dsTenTimThay = new LinkedList<HocSinh>();
//		dsTenTimThay = lopHoc.timHocSinhTheoTen();
//		lopHoc.xuat(dsTenTimThay);
//
		// Tim hoc sinh theo ma
//		HocSinh hsTimThay = new HocSinh();
//		hsTimThay = lopHoc.timHocSinhTheoMa();
//		if (hsTimThay.getMaHocSinh() == null) {
//			System.out.println("Khong tim thay hoc sinh nao co ma nhu tren!");
//		} else {
//			hsTimThay.xuat();
//		}

		// Xoa hoc sinh theo ma
		boolean ketQuaXoa = false;
		ketQuaXoa = lopHoc.xoaHocSinhTheoMa();
		if (ketQuaXoa) {
			System.out.print("Da xoa!");
			lopHoc.xuat();
		} else {
			System.out.println("Khong tim thay hoc sinh nao co ma nhu tren!");
		}
	}
}
