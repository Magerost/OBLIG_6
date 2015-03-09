import java.util.Scanner;

public class TowerOfHanoi {

	private static Scanner input = new Scanner(System.in);
	private static long count = 1;
	private static long callCount = 1;

	public static void main(String[] args) {
		System.out.print("Skriv inn antall skiver: ");
		int n = input.nextInt();

		System.out.println("Trekkene er:");
		flyttBrikker(n, 'A', 'B', 'C');

		System.out.printf("\nAntall tegn ble: %5d\n", count);
		System.out.printf("\nAntall call til metoden ble: %5d\n", callCount);
	}

	public static void flyttBrikker(int n, char fromTower, char toTower,
			char auxTower) {
		callCount++;

		if (n == 1) {
			System.out.printf(
					"Trekk nummer: %5d Flytt skiven %2d fra %c til %c\n", count,
					n, fromTower, toTower);
			count++;
		} else {
			flyttBrikker(n - 1, fromTower, auxTower, toTower);
			System.out.printf(
					"Trekk nummer: %5d Flytt skiven %2d fra %c til %c\n", count,
					n, fromTower, toTower);
			count++;
			flyttBrikker(n - 1, auxTower, toTower, fromTower);
		}
	}
}
