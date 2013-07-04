package com.examples.mit;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The Class MyIteratorTest provides unitary tests for MyIterator.
 * 
 * l : the list over which we iterates
 * s : the string located at the current position of the iterator
 * 
 * partition of the space:
 * 	+ l : null, empty, singleton, several
 *  + s : no elements to return, element, out-of-bounds 
 */
public class MyIteratorTest {
	
	private MyIterator myIter;
	
	@Test(expected=NullPointerException.class)
	public void testNullList() {
		ArrayList<String> l = null;
		myIter = new MyIterator(l);
		
		myIter.hasNext();
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEmptyList() {
		ArrayList<String> l = new ArrayList<String>();
		myIter = new MyIterator(l);
		
		assertTrue("hasNext must return false", myIter.hasNext() == false);
		String s = myIter.next();
	}
	
	@Test
	public void testSingletonList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("single");
		
		myIter = new MyIterator(l);
		assertTrue("one element must be available", myIter.hasNext() == true);
		assertEquals("the first element must match", "single", myIter.next());
		assertTrue("no more elements available", myIter.hasNext() == false);
	}
	
	@Test
	public void testSeveralList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		
		myIter = new MyIterator(l);
		assertTrue("one element must be available", myIter.hasNext() == true);
		assertEquals("the first element must match", "one", myIter.next());
		
		assertTrue("more elements available", myIter.hasNext() == true);
		assertEquals("the second element must match", "two", myIter.next());
		
		assertTrue("more elements available", myIter.hasNext() == true);
		assertEquals("the third element must match", "three", myIter.next());
		
		assertTrue("No more elements available", myIter.hasNext() == false);
	}	
}
