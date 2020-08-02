
public class DemoString {

	public static void main(String[] args) {
		String text = String.format("%20s", "Cyberlearn");
		System.out.println(text);
		String text1 = String.format("%-20s", "Cyberlearn");
		System.out.println(text1);
		String text2 = String.format("%-20s", "Cyberlearn") + "Dev";
		System.out.println(text2);
		String text3 = String.format("%-20s", "Cyberlearn").replace(' ', '.') + "Dev";
		System.out.println(text3);
	}

}