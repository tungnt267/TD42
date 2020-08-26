
public class Main {

	public static void main(String[] args) {
		HocSinh hs = new HocSinh();
		hs.nhap();
		hs.xuat();
		
		float diemTB = hs.tinhDiemTB();
		String xepLoai = hs.xepLoai();
		
		System.out.print("\nDiem TB: " + diemTB);
		System.out.print("\nXep loai: " + xepLoai);
	}

}
