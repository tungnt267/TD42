import java.util.Scanner;

public class caseStudyTree {

	public static void main(String[] args) {
		// Đầu vào
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào chiều dài sân: ");
		double chieuDaiSan = Double.parseDouble(scan.nextLine());
		System.out.println("Nhập vào bán kính của một cây phát triền đầy đủ: ");
		double banKinhCay = Double.parseDouble(scan.nextLine());
		System.out.println("Không gian cần thiết giữa mỗi cây: ");
		double khongGianCan = Double.parseDouble(scan.nextLine());

		// Xử lý
		int soLuongCay = (int) (chieuDaiSan / (khongGianCan + 2 * banKinhCay));
		double tongKhongGianCay = Math.PI * Math.pow(banKinhCay, 2) * soLuongCay;

		// Đầu ra
		System.out.println("Số lượng cây có thể trồng được: " + soLuongCay);
		System.out.println("Tổng không gian được chiếm bởi cây được trồng: " + tongKhongGianCay);
	}

}