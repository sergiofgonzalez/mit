package com.examples.mit;

/**
 * Demonstrates the Hailstone sequence using the Hailstone class.
 * @author sergio.f.gonzalez
 *
 */
public final class HailstoneApp2 {

	/**
	 * The class constructor marked as private to prevent creation.
	 */
	private HailstoneApp2() {
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
		
		Hailstone hailstone = new Hailstone();
		
		for (int i = 1; i <= NUM_TIMES; i++) {
			System.out.println("Hailstone(" + i + "): " + hailstone.getSequence(i)); //NOSONAR: sergio.f.gonzalez: console app
		}
	}
}
