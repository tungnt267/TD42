import java.util.Scanner;

public class XepLoaiDiemTB {
	public static void main(String[] args) {
		// Input
		Scanner scan = new Scanner(System.in);
		String xepLoai = "";
		System.out.println("Họ tên: ");
		String hoTen = scan.nextLine();
		System.out.println("Điểm Toán: ");
		float diemToan = Float.parseFloat(scan.nextLine());
		System.out.println("Điểm Lý: ");
		float diemLy = Float.parseFloat(scan.nextLine());
		System.out.println("Điểm Hóa: ");
		float diemHoa = Float.parseFloat(scan.nextLine());
			 
		// Processing
		float diemTB = (diemToan + diemLy + diemHoa) / 3;
		if (diemTB >= 8.5) {
			xepLoai = "Giỏi";
		} else if (diemTB >= 6.5 && diemTB < 8.5) {
			xepLoai = "Khá";
		} else if (diemTB >= 5 && diemTB < 6.5) {
			xepLoai = "Trung Bình";
		} else {
			xepLoai = "Yếu";
		}
		// Output
		System.out.println("Điểm trung bình: " + diemTB);
		System.out.println("Loại: " + xepLoai);
	}
}
