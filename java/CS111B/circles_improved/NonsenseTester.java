package circles_improved;

public class NonsenseTester {
	public static void main(String args[]) {
		String s = "Sunrise, sunset."; for (int i = 0; i < s.length(); i += 2) { if (Character.isWhitespace(s.charAt(i))) System.out.println("***"); else System.out.println(s.charAt(i)); }
	}
}
