import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		CongTy congTy = new CongTy();
		chonMenu();
	}

	public static void chonMenu() {
		Scanner scan = new Scanner(System.in);
		CongTy congTy = new CongTy();
		congTy.khoiTao();

		int n;
		String maSo;
		boolean thoat = false;
		do {
			inMenu();
			System.out.print("\nVui lòng chọn chức năng: ");
			n = Integer.parseInt(scan.nextLine());
			switch (n) {
			case 1:
				// Nhập thông tin công ty
				congTy.nhap();
				break;
			case 2:
				congTy.themNhanSu();
				break;
			case 3:
				boolean ketQuaXoa = false;
				ketQuaXoa = congTy.xoaMotNhanSu();
				if (ketQuaXoa) {
					System.out.print("Đã xóa nhân sự!");
					congTy.xuat();
				} else {
					System.out.println("Không tìm thấy nhân sự có mã như trên!");
				}
				break;
			case 4:
				congTy.xuat();
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			case 0:
				System.out.println("Chương trình đã kết thúc!");
				thoat = true;
				break;
			default:
				break;
			}
		} while (!thoat);
	}

	public static void inMenu() {
		System.out.println("\n\n---------------------------QUẢN LÝ NHÂN SỰ-------------------------------");
		System.out.println("1. Nhập thông tin công ty");
		System.out.println("2. Thêm một nhân sự");
		System.out.println("3. Xóa một nhân sự");
		System.out.println("4. Xuất danh sách nhân sự");
		System.out.println("5. Xuất tổng lương toàn công ty");
		System.out.println("6. Trưởng Phòng có lương cao nhất");
		System.out.println("7. Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("8. Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("9. Xuất tổng thu nhập của từng Giám Đốc");
		System.out.println("0. Thoát chương trình");
	}
}
