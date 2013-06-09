package com.examples.mit;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Hailstone that computes the Hailstone sequence.
 *
 * @author sergio.f.gonzalez
 */
public class Hailstone {
	
	/** The Constant STARTING_NUMBER_ERR that stores the error message. */
	private static final String STARTING_NUMBER_ERR = "The starting number must be greater than zero.";
	
	/**
	 * Gets the Hailstone sequence for a given starting number.
	 *
	 * @param startingNumber the starting number
	 * @return the sequence as a list of integers
	 */
	public List<Integer> getSequence(int startingNumber) {
		if (startingNumber < 1) {
			throw new IllegalArgumentException(STARTING_NUMBER_ERR);
		}
		
		int n = startingNumber;
		List<Integer> result = new ArrayList<Integer>();
		
		while (n != 1) {
			result.add(n);
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;	//NOSONAR: sergio.f.gonzalez : required by the algorithm
			}
		}
		
		result.add(n);
		
		return result;
	}
}
