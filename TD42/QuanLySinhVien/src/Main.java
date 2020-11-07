import java.util.List;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		chonMenu(dssv);

	}

	public static void chonMenu(DanhSachSinhVien dssv) {
		Scanner scan = new Scanner(System.in);
		int n, stt = 0, maSV;
		boolean thoat = false;
		do {
			thongBao();
			n = Integer.parseInt(scan.nextLine());
			switch (n) {
			case 1:
				stt++;
				// Nhap SV
				SinhVien sv = new SinhVien();
				sv.nhapSinhVien(stt);
				// Tinh diem TB
				sv.tinhDiemTB();
				// Xep loai
				sv.xepLoai();
				dssv.themSinhVien(sv);
				break;
			case 2:
				// Xuat SV
				dssv.xuatTatCaSinhVien();
				break;
			case 3:
				// Tim sv co diem TB cao nhat
				dssv.svDiemTBCaoNhat().xuatSinhVien(1);
				break;
			case 4:
				// In tat ca sinh vien yeu
				dssv.tatCaSVYeu();
				break;
			case 5:
				stt = 0;
				// Tim SV theo ma
				System.out.println("Vui long nhap vao ten SV can tim: ");
				String ten = scan.nextLine();
				List<SinhVien> dssvTimDuoc = dssv.timSVTheoTen(ten);
				for (SinhVien svTimDuoc : dssvTimDuoc) {
					stt++;
					svTimDuoc.xuatSinhVien(stt);
				}
				if (stt == 0) {
					System.out.println("\t\t\t Khong tim thay SV!");
				}
				break;
			case 6:
				// Tim SV theo ma
				System.out.println("Vui long nhap vao ma SV can tim: ");
				maSV = Integer.parseInt(scan.nextLine());
				dssv.header();
				if (dssv.timSVTheoMa(maSV) != null) {
					dssv.timSVTheoMa(maSV).xuatSinhVien(1);
				} else {
					System.out.println("\t\t\t Khong tim thay SV!");
				}
				break;
			case 7:
				// Xoa 1 SV
				System.out.println("Vui long nhap vao ma SV can xoa: ");
				maSV = Integer.parseInt(scan.nextLine());
				dssv.xoaMotSVTheoMa(maSV);
				break;
			case 0:
				System.out.println("Chuong trinh da ket thuc!");
				thoat = true;
				break;
			default:
				break;
			}
		} while (!thoat);
	}

	public static void thongBao() {
		System.out.print("\n Vui long chon tinh nang: \n" + "\t1. Nhap vao sinh vien\n" + "\t2. Xuat sinh vien\n"
				+ "\t3. SV co diem TB cao nhats\n" + "\t4. In ra tat ca sinh vien yeu\n" + "\t5. Tim SV theo ten\n"
				+ "\t6. Tim SV theo ma\n" + "\t7. Xoa mot SV\n" + "\t0. Thoat chuong trinh\n");
	}
}
