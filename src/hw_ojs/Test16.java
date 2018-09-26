package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *
 */
public class Test16 {

	public Test16() {
		// TODO Auto-generated constructor stub
	}
	
	static int x = 0, y = 0;
	static int distance = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String moveStr = scanner.nextLine();
		    String[] moveArray = moveStr.split(";");
		    getLoaction(moveArray);
		    x = 0;
		    y = 0;
		    distance = 0;
		}
		scanner.close();
	}
	
	private static void getLoaction(String[] moves) {
		for (String string : moves) {
			if (!isStringOK(string)) {
				continue;
			}
			if (string.startsWith("A")) {
				distance = Integer.parseInt(string.substring(1));
				x = x - distance;
			}
			if (string.startsWith("D")) {
				distance = Integer.parseInt(string.substring(1));
				x = x + distance;
			}
			if (string.startsWith("W")) {
				distance = Integer.parseInt(string.substring(1));
				y = y + distance;
			}
			if (string.startsWith("S")) {
				distance = Integer.parseInt(string.substring(1));
				y = y - distance;
			}
			distance = 0;
		}
		System.out.println(x + "," + y);
	}
	
	private static boolean isStringOK(String input) {
		if (input.length() < 2 || input.length() > 3) {
			return false;
		}
		input = input.substring(1);
		for (char temp : input.toCharArray()) {
			if (temp > '9' || temp < '0') {
				return false;
			}
		}
		return true;
	}
	
	

}
