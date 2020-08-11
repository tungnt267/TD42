import java.util.Scanner;

public class Bai1QuanLyTuyenSinh {

	// VARIABLE
	public static float diemChuan, diemMon1, diemMon2, diemMon3, diemTongKet;;
	public static String khuVuc;
	public static int doiTuong;

	// CONST
	public static final float DIEM_KHU_VUC_A = 2;
	public static final float DIEM_KHU_VUC_B = 1;
	public static final float DIEM_KHU_VUC_C = 0.5f;
	public static final float DIEM_KHU_VUC_X = 0;

	public static final float DIEM_DOI_TUONG_1 = 2.5f;
	public static final float DIEM_DOI_TUONG_2 = 1.5f;
	public static final float DIEM_DOI_TUONG_3 = 1;
	public static final float DIEM_DOI_TUONG_0 = 0;

	public static void main(String[] args) {
		String chonLua;
		Scanner scan = new Scanner(System.in);
		do {
			// Input
			nhapDiemThi();
			// Process
			tinhDiemTongKet();
			// Output
			kiemTraTrungTuyen();
			System.out.println("\nBạn có muốn tiếp tục không? 'y' để tiếp: ");
			chonLua = scan.nextLine();
		} while (chonLua.equalsIgnoreCase("y"));
	}

	public static void nhapDiemThi() {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Nhập điểm chuẩn của hội đồng: ");
			diemChuan = Float.parseFloat(scan.nextLine());
			if (diemChuan < 0 || diemChuan > 34.5) {
				System.out.println("Điểm chuẩn nhập vào không hợp lệ! ");
			}
		} while (diemChuan < 0 || diemChuan > 34.5);
		do {
			System.out.println("Nhập điểm môn thứ nhất: ");
			diemMon1 = Float.parseFloat(scan.nextLine());
			if (diemMon1 < 0 || diemMon1 > 10) {
				System.out.println("Điểm thi phải trong khoảng 0-10 ! ");
			}
		} while (diemMon1 < 0 || diemMon1 > 10);
		do {
			System.out.println("Nhập điểm môn thứ hai: ");
			diemMon2 = Float.parseFloat(scan.nextLine());
			if (diemMon2 < 0 || diemMon2 > 10) {
				System.out.println("Điểm thi phải trong khoảng 0-10 ! ");
			}
		} while (diemMon2 < 0 || diemMon2 > 10);
		do {
			System.out.println("Nhập điểm môn thứ ba: ");
			diemMon3 = Float.parseFloat(scan.nextLine());
			if (diemMon3 < 0 || diemMon3 > 10) {
				System.out.println("Điểm thi phải trong khoảng 0-10 ! ");
			}
		} while (diemMon3 < 0 || diemMon3 > 10);
		do {
			System.out.println("Nhập khu vực: ");
			khuVuc = scan.nextLine();
			if (!"A".equalsIgnoreCase(khuVuc) && !"B".equalsIgnoreCase(khuVuc) && !"C".equalsIgnoreCase(khuVuc)
					&& !"X".equalsIgnoreCase(khuVuc)) {
				System.out.println("Khu vực không hợp lệ! ");
			}
		} while (!"A".equalsIgnoreCase(khuVuc) && !"B".equalsIgnoreCase(khuVuc) && !"C".equalsIgnoreCase(khuVuc)
				&& !"X".equalsIgnoreCase(khuVuc));
		do {
			System.out.println("Nhập đối tượng: ");
			doiTuong = Integer.parseInt(scan.nextLine());
			if (doiTuong != 1 && doiTuong != 2 && doiTuong != 3 && doiTuong != 0) {
				System.out.println("Đối tượng không hợp lệ! ");
			}
		} while (doiTuong != 1 && doiTuong != 2 && doiTuong != 3 && doiTuong != 0);
	}

	public static float tinhDiemTongKet() {
		float diemUuTien = 0;

		if (khuVuc.equalsIgnoreCase("A")) {
			if (doiTuong == 1) {
				diemUuTien = DIEM_KHU_VUC_A + DIEM_DOI_TUONG_1;
			} else if (doiTuong == 2) {
				diemUuTien = DIEM_KHU_VUC_A + DIEM_DOI_TUONG_2;
			} else if (doiTuong == 3) {
				diemUuTien = DIEM_KHU_VUC_A + DIEM_DOI_TUONG_3;
			} else {
				diemUuTien = DIEM_KHU_VUC_A + DIEM_DOI_TUONG_0;
			}
		}

		if (khuVuc.equalsIgnoreCase("B")) {
			if (doiTuong == 1) {
				diemUuTien = DIEM_KHU_VUC_B + DIEM_DOI_TUONG_1;
			} else if (doiTuong == 2) {
				diemUuTien = DIEM_KHU_VUC_B + DIEM_DOI_TUONG_2;
			} else if (doiTuong == 3) {
				diemUuTien = DIEM_KHU_VUC_B + DIEM_DOI_TUONG_3;
			} else {
				diemUuTien = DIEM_KHU_VUC_B + DIEM_DOI_TUONG_0;
			}
		}

		if (khuVuc.equalsIgnoreCase("C")) {
			if (doiTuong == 1) {
				diemUuTien = DIEM_KHU_VUC_C + DIEM_DOI_TUONG_1;
			} else if (doiTuong == 2) {
				diemUuTien = DIEM_KHU_VUC_C + DIEM_DOI_TUONG_2;
			} else if (doiTuong == 3) {
				diemUuTien = DIEM_KHU_VUC_C + DIEM_DOI_TUONG_3;
			} else {
				diemUuTien = DIEM_KHU_VUC_C + DIEM_DOI_TUONG_0;
			}
		}

		if (khuVuc.equalsIgnoreCase("X")) {
			if (doiTuong == 1) {
				diemUuTien = DIEM_KHU_VUC_X + DIEM_DOI_TUONG_1;
			} else if (doiTuong == 2) {
				diemUuTien = DIEM_KHU_VUC_X + DIEM_DOI_TUONG_2;
			} else if (doiTuong == 3) {
				diemUuTien = DIEM_KHU_VUC_X + DIEM_DOI_TUONG_3;
			} else {
				diemUuTien = DIEM_KHU_VUC_X + DIEM_DOI_TUONG_0;
			}
		}

		diemTongKet = diemMon1 + diemMon2 + diemMon3 + diemUuTien;
		return diemTongKet;
	}

	public static void kiemTraTrungTuyen() {
		if (diemTongKet < diemChuan) {
			System.out.println("Điểm 3 môn lần lượt là: " + diemMon1 + "\t" + diemMon2 + "\t" + diemMon3);
			System.out.println("Khu vực: " + khuVuc.toUpperCase() + "\tĐối tượng: " + doiTuong);
			System.out.println("Điểm tổng kết: " + diemTongKet);
			System.out.println("Điểm chuẩn hội đồng: " + diemChuan);
			System.out.println("Thí sinh đã rớt!");
		} else {
			if (diemMon1 == 0 || diemMon2 == 0 || diemMon3 == 0) {
				System.out.println("Điểm 3 môn lần lượt là: " + diemMon1 + "\t" + diemMon2 + "\t" + diemMon3);
				System.out.println("Khu vực: " + khuVuc.toUpperCase() + "\tĐối tượng: " + doiTuong);
				System.out.println("Điểm tổng kết: " + diemTongKet);
				System.out.println("Điểm chuẩn hội đồng: " + diemChuan);
				System.out.println("Thí sinh đã rớt vì có điểm liệt!");
			} else {
				System.out.println("Điểm 3 môn lần lượt là: " + diemMon1 + "\t" + diemMon2 + "\t" + diemMon3);
				System.out.println("Khu vực: " + khuVuc.toUpperCase() + "\tĐối tượng: " + doiTuong);
				System.out.println("Điểm tổng kết: " + diemTongKet);
				System.out.println("Điểm chuẩn hội đồng: " + diemChuan);
				System.out.println("Thí sinh đã đậu!");
			}
		}
	}
}
