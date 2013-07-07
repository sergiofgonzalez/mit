package com.examples.mit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class RationalNumberTest provides the unitary tests for the RationalNumber class.
 * testing strategy:
 * numerator 	: the numerator of the rational number
 * denominator  : the denominator of the rational number
 * 
 * partitioning of the testing space:
 * 	numerator	: -n, 0, n
 *  denominator : -n < 0, 1, n > 0 
 *  num / denom : gcd(n, d) == 1, gcd(n, d) > 1
 */
public class RationalNumberTest {

	private RationalNumber rationalNum;

	@Test
	public void testNegNumNegDenomReduced() {
		rationalNum = new RationalNumber(-3, -2);
		assertEquals("3/2", rationalNum.toString());
	}
	
	@Test
	public void testPosNumNegDenomReduced() {
		rationalNum = new RationalNumber(3, -2);
		assertEquals("-3/2", rationalNum.toString());
	}
	
	@Test
	public void testNegNumPosDenomReduced() {
		rationalNum = new RationalNumber(-3, 2);
		assertEquals("-3/2", rationalNum.toString());
	}

	@Test
	public void testPosNumPosDenomReduced() {
		rationalNum = new RationalNumber(3, 2);
		assertEquals("3/2", rationalNum.toString());
	}
	
	@Test
	public void testNegNumPosDenomNotReduced() {
		rationalNum = new RationalNumber(-8, 6);
		assertEquals("-4/3", rationalNum.toString());
	}
	
	@Test
	public void testPosNumPosDenomNotReduced() {
		rationalNum = new RationalNumber(12, 15);
		assertEquals("4/5", rationalNum.toString());
	}
	
	@Test
	public void testZeroNum() {
		rationalNum = new RationalNumber(0, 2);
		assertEquals("0", rationalNum.toString());
	}	
	
	@Test
	public void testOneDenom() {
		rationalNum = new RationalNumber(5, 1);
		assertEquals("5", rationalNum.toString());
		
		rationalNum = new RationalNumber(5);
		assertEquals("5", rationalNum.toString());
		
	}	
}
