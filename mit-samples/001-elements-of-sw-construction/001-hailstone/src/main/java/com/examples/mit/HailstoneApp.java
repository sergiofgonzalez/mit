package com.examples.mit;

/**
 * Demonstrates the Hailstone sequence.
 * @author sergio.f.gonzalez
 *
 */
public final class HailstoneApp {

	/**
	 * The class constructor marked as private to prevent creation.
	 */
	private HailstoneApp() {
	}

	/**
	 * The number of times the sequence will be displayed.
	 */
	private static final int NUM_TIMES = 10;

	/**
	 * The main method for the Hailstone Application. Calculates the Hailstone sequence
	 * for numbers n=0..9
	 * @param args the arguments received from the command line, which are ignored
	 */
	public static void main(String[] args) {
		for (int i = 0; i < NUM_TIMES; i++) {
			System.out.print("Hailstone(" + i + "): "); //NOSONAR: sergio.f.gonzalez: console app
			displayHailstoneSequence(i);
		}
	}

	/***
	 * Displays on the standard output/err the Hailstone sequence for a given number.
	 * @param startingNumber the number from which the Hailstone sequence will be displayed.
	 * 			startingNumber must be greater than 0 or an error will be displayed.
	 */
	private static void displayHailstoneSequence(int startingNumber) {
		if (startingNumber < 1) {
			System.err.println("Hailstone sequence requires a startingNumber > 0"); //NOSONAR: sergio.f.gonzalez: console app
			return;
		}

		int n = startingNumber;

		while (n != 1) {
			System.out.print(n + " ");	//NOSONAR: sergio.f.gonzalez: console app
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1; //NOSONAR: sergio.f.gonzalez: part of the sequence
			}
		}
		System.out.println(n);	//NOSONAR: sergio.f.gonzalez: console app
	}
}
