package com.examples.mit;

/**
 * The Class IntFinder.
 */
public final class IntFinder {

	/**
	 * Prevent the creation of IntFinder class instances.
	 */
	private IntFinder() {
		// prevent creation of IntFinder instances
	}
	
	/**
	 * Finds the first occurrence of a given integer number in a sorted array.
	 *
	 * @param x the number to find
	 * @param a the sorted array of integers
	 * @return the position of the first occurrence of x in the array or -1 if x was not found
	 */
	public static int find(int x, int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		
		int i = 0;
		while (i < a.length && x > a[i]) {
			i++;
		}		

		if (i == a.length) {
			return -1;
		} else if (x == a[i]) {
			return i; 
		} else {
			return -1;
		}		
	}
}
