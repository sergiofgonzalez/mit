package com.examples.mit;

/**
 * The Class RationalNumber implements RationalNumbers, but it is used to exemplifies the concepts of the
 * space of rep values which consists of the values of the actual implementation entities and the space of
 * abstract values which consists of the values the type is designed to support.
 * The mapping between both spaces is infinite, so we describe it by giving two things:
 * 	- An abstraction function that maps rep values into the abstract values they represent: AF: R -> A
 * 	- A rep invariant that maps rep values to boolean: RI: R -> boolean
 * 		For a rep value r, RI is true if and only if r is mapped by AF, or in other words, RI tells us
 * 		if the rep value is well formed.
 */
public class RationalNumber {
	// Chosen implementation (rep space) : two ints representing the numerator and denominator
	// Note: besides, RationalNumber is not mutable
	/** The numer. */
	private final int numer;
	
	/** The denom. */
	private final int denom;
	
	// Representation Invariant (the function that tells us if the rep value is well formed)
	//	denom > 0
	// 	numer/denom is in reduced form
	
	// Abstraction Function (the function that maps rep values into abstract values):
	//	numer / denom represents any given rational number 
	
	/**
	 * Instantiates a new rational number.
	 *
	 * @param n the n
	 */
	public RationalNumber(int n) {
		numer = n;
		denom = 1;
		checkRep();
	}
	
	/**
	 * Instantiates a new rational number.
	 *
	 * @param n the n
	 * @param d the d
	 * @throws ArithmeticException the arithmetic exception
	 */
	public RationalNumber(int n, int d) throws ArithmeticException {
		// reduce ration to lowest terms: search for the greatest common divisor
		int g = gcd(n, d);
		n = n / g;
		d = d / g;
		
		if (d < 0) {
			numer = -n;
			denom = -d;
		} else {
			numer = n;
			denom = d;
		}
		
		checkRep();
	}
	
	
	/**
	 * Check rep is the implementation of the Representation Invariant (tells us which rep values are
	 * well-formed).
	 */
	private void checkRep() {
		assert denom > 0;
		assert gcd(numer, denom) == 1;
	}

	/* This is the implementation of the Abstraction Function which maps well-formed rep values into
	 * abstract values.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (denom > 1)? (numer + "/" + denom) : Integer.valueOf(numer).toString();
	}
	
	/**
	 * Computes the Greatest Common Divisor.
	 *
	 * @param a the first number
	 * @param b the second number
	 * @return the greatest number which is divisor of both a and b
	 */
	private static int gcd(int a, int b) {
		return (b == 0)? a : gcd(b, a % b);
	}
	
	
}
