package com.examples.mit;

public class HailstoneApp {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print("Hailstone(" + i + "): ");
			displayHailstoneSequence(i);
		}
	}
	
	private static void displayHailstoneSequence(int n) {
		if (n < 1) {
			System.err.println("Hailstone sequence requires a n > 0");
			return;
		}
		
		while (n != 1) {
			System.out.print(n + " ");
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
		}
		System.out.println(n);
	}
}
