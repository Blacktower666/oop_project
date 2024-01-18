import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	private static Scanner input = new Scanner(System.in);

	public static void main() {

	}

	private static String readLine(String a) {
		System.out.print(a);
		// Scanner input =new Scanner(System.in);
		String s = input.nextLine();
		return s;

	}

	private static int readPosInt(String a) {
		while (true) {
			int i;
			while (true) {
				System.out.print(a);
				try {
					i = input.nextInt();// read the integers
					break;
				} catch (InputMismatchException e) {
					System.out.println("You must type an integer!");
				} finally {
					String s = input.nextLine();
				}
			}
			if (i >= 0)
				return i;
			else
				System.out.println("Positive integers only!");
		}
	}
	public static void main(String[] args) {
		String str1 = readLine("Type some text: ");
		System.out.println("Text read is: " + str1);
		int i = readPosInt("Type an integer: ");
		System.out.println("Integer read is: " + i);
		String str2 = readLine("Type some text again: ");
		System.out.println("Text read is: " + str2);
		}

}
