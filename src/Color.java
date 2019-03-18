
public class Color {

	public enum color{RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA}
	
	private int r;
	
	private int g;
	
	private int b;
	
	private Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public static Color[] values() {
		
	}
	
	public static Color valueOf(String name) {
		
	}
	
	public int getR() {
		return r;
	}
	
	public int getG() {
		return g;
	}
	
	public int getB() {
		return b;
	}
}
