package com.examples.mit;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class IntFinderTest tests IntFinder using the following strategy:
 * 	+ Partition of the space:
 * 		- x : num to find
 * 		- a : sorted array of nums
 * 		- i : position of the first occurrence of x in a
 * 
 * 	+ x 		: neg, 0, pos
 * 	+ a.length 	: null, 0, 1, 2, 2+
 * 	+ a.values 	: negative, 0, positive, all same, increasing
 * 	+ i			: 0, middle, n-1, -1	
 */
public class IntFinderTest {

	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(IntFinderTest.class);
	
	/**
	 * Find -1 in a null array should return not found.
	 */
	@Test
	public void testNullArray() {
		int[] a = null;
		int i = IntFinder.find(-1, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find -1 in empty array should return not found.
	 */
	@Test
	public void testEmptyArray() {
		int[] a = {};
		int i = IntFinder.find(-1, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find -1 in in { -1 } should return 0.
	 */
	@Test
	public void testSingletonExisting() {
		int[] a = { -1 };
		int i = IntFinder.find(-1, a);
		Assert.assertEquals("should return 0", 0, i);
	}
	
	/**
	 * Find 0 in { -1 } should return not found.
	 */
	@Test
	public void testSingletonNonExisting() {
		int[] a = { -1 };
		int i = IntFinder.find(0, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find existing negative at the beginning should return 0.
	 */
	@Test
	public void testArray2NegElemsExistingNegFirst() {
		int[] a = { -2, -1 };
		int i = IntFinder.find(-2, a);
		Assert.assertEquals("should return 0", 0, i);
	}
	
	/**
	 * Find existing negative at the end should return 1.
	 */
	@Test
	public void testArray2NegElemsExistingNegSecond() {
		int[] a = { -2, -1 };
		int i = IntFinder.find(-1, a);
		Assert.assertEquals("should return 1", 1, i);
	}
	
	/**
	 * Find non existing negative in the end return not found.
	 */
	@Test
	public void testArray2NegElemsNonExisting1() {
		int[] a = { -2, -1 };
		int i = IntFinder.find(0, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find non existing negative in the beginning should return not found.
	 */
	@Test
	public void testArray2NegElemsNonExisting2() {
		int[] a = { -2, -1 };
		int i = IntFinder.find(-3, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find non existing negative in the middle should return not found.
	 */
	@Test
	public void testArray2NegElemsNonExisting3() {
		int[] a = { -3, -1 };
		int i = IntFinder.find(-2, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find existing positive at the beginning should return 0.
	 */
	@Test
	public void testArray2PosElemsExistingNegFirst() {
		int[] a = { 1, 2 };
		int i = IntFinder.find(1, a);
		Assert.assertEquals("should return 0", 0, i);
	}
	
	/**
	 * Find existing positive at the end should return 1.
	 */
	@Test
	public void testArray2PosElemsExistingNegSecond() {
		int[] a = { 1, 2 };
		int i = IntFinder.find(2, a);
		Assert.assertEquals("should return 1", 1, i);
	}
	
	/**
	 * Find non existing positive in the end return not found.
	 */
	@Test
	public void testArray2PosElemsNonExisting1() {
		int[] a = { 1, 2 };
		int i = IntFinder.find(3, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find non existing positive in the beginning should return not found.
	 */
	@Test
	public void testArray2PosElemsNonExisting2() {
		int[] a = { 1, 2 };
		int i = IntFinder.find(0, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find non existing positive in the middle should return not found.
	 */
	@Test
	public void testArray2PosElemsNonExisting3() {
		int[] a = { 1, 3 };
		int i = IntFinder.find(2, a);
		Assert.assertEquals("should return -1", -1, i);
	}	
		
	/**
	 * Find existing negative at the beginning should return 0.
	 */
	@Test
	public void testArrayNegElemsExistingNegFirst() {
		int[] a = { -5, -4, -3, -2, -1 };
		int i = IntFinder.find(-5, a);
		Assert.assertEquals("should return 0", 0, i);
	}
	
	/**
	 * Find existing negative at the end should return 1.
	 */
	@Test
	public void testArrayNegElemsExistingNegSecond() {
		int[] a = { -5, -4, -3, -2, -1 };
		int i = IntFinder.find(-1, a);
		Assert.assertEquals("should return 4", 4,  i);
	}
	
	/**
	 * Find existing negative in the pos previous to last return not found.
	 */
	@Test
	public void testArrayNegElemsExistingPrevLast() {
		int[] a = { -5, -4, -3, -2, -1 };
		int i = IntFinder.find(-2, a);
		Assert.assertEquals("should return 3", 3, i);
	}

	/**
	 * Find non existing negative in pos previous to first should return -1.
	 */
	@Test
	public void testArrayNegElemsNonExistingNegFirst() {
		int[] a = { -5, -4, -3, -2, -1 };
		int i = IntFinder.find(-6, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	/**
	 * Find non existing negative in position grater than last should return -1.
	 */
	@Test
	public void testArrayNegElemsNonExistingLast() {
		int[] a = { -5, -4, -3, -2, -1 };
		int i = IntFinder.find(0, a);
		Assert.assertEquals("should return -1", -1,  i);
	}
	
	/**
	 * Find non existing negative in the middle should return not found.
	 */
	@Test
	public void testArrayNegElemsNonExistingMiddle() {
		int[] a = { -6, -5, -3, -2, -1 };
		int i = IntFinder.find(-4, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
	// -- positives

		
	/**
	 * Find existing positive at the beginning should return 0.
	 */
	@Test
	public void testArrayPosElemsExistingFirst() {
		int[] a = { 0, 1, 2, 3, 4 };
		int i = IntFinder.find(0, a);
		Assert.assertEquals("should return 0", 0, i);
	}

	/**
	 * Find existing positive at the end should return 1.
	 */
	@Test
	public void testArrayPosElemsExistingLast() {
		int[] a = { 0, 1, 2, 3, 4 };
		int i = IntFinder.find(4, a);
		Assert.assertEquals("should return 4", 4,  i);
	}

	/**
	 * Find existing positive in the pos previous to last.
	 */
	@Test
	public void testArrayPosElemsExistingPrevLast() {
		int[] a = { 0, 1, 2, 3, 4 };
		int i = IntFinder.find(3, a);
		Assert.assertEquals("should return 3", 3, i);
	}

	/**
	 * Find non existing positive in pos previous to first should return -1.
	 */
	@Test
	public void testArrayPosElemsBeforeFirst() {
		int[] a = { 2, 3, 4, 5 };
		int i = IntFinder.find(1, a);
		Assert.assertEquals("should return -1", -1, i);
	}

	/**
	 * Find non existing positive in position greater than last should return -1.
	 */
	@Test
	public void testArrayPosElemsNonExistingLast() {
		int[] a = { 0, 1, 2, 3, 4 };
		int i = IntFinder.find(5, a);
		Assert.assertEquals("should return -1", -1,  i);
	}

	/**
	 * Find non existing positive in the middle should return not found.
	 */
	@Test
	public void testArrayPosElemsNonExistingMiddle() {
		int[] a = { 0, 1, 3, 4, 5 };
		int i = IntFinder.find(2, a);
		Assert.assertEquals("should return -1", -1, i);
	}
	
}
