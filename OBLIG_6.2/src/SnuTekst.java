import java.util.Scanner;

public class SnuTekst {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		String userInput = validerString("Skriv inn en tekststreng");
		
		baklengs(userInput);
	}
	
	public static void baklengs(String tekst) {
		int length = tekst.length() - 1;
		if (length >= 0) {
			System.out.print(tekst.charAt(length));
			baklengs(tekst.substring(0, length));
		} else
			System.out.println();
	}
	
	public static String validerString(String prompt) {

		String respons = "";

		while (respons == null || respons.equals("")) {
			System.out.println(prompt);

			try {

				respons = in.nextLine();

			} catch (Exception ex) {

				System.out.println("Skriv inn en gyldig respons.");
			}
		}
		return respons;
	}
}