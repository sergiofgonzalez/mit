package com.examples.mit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class StackTest provides the unit tests for Stack class.
 * 
 * size : the number of elements of the stack
 * 
 * Testing strategy: 
 * size : 0, 1, n
 * 
 * test cases:
 * 	[]  + push(a)           => [a]
 *  [a] + pop()             => [], a
 *  [a] + push(b)           => [a, b]
 *  [a, b] + pop()          => [a], b
 *  [a, b] + push(c)        => [a, b, c]
 *  [a, b, c] + pop()       => [a, b], c
 */
public class StackTest {

	private Stack<String> sstack;

	@Test
	public void testNewStackIsEmpty() {
		sstack = new Stack<String>();
		assertTrue("initialized Stack must be empty", sstack.size() == 0);
	}
	
	@Test
	public void testPushOnEmpty() {
		sstack = new Stack<String>();
		sstack.push("a");
		
		assertTrue("stack must have 1 elem", sstack.size() == 1);		
	}
	
	@Test
	public void testPopOnSingleton() {
		sstack = new Stack<String>();
		sstack.push("a");
		
		String elem = sstack.pop();
		assertTrue("stack must be empty", sstack.size() == 0);
		assertEquals("elem must match", "a", elem);
	}

	@Test
	public void testPushTwoElems() {
		sstack = new Stack<String>();
		sstack.push("a");
		sstack.push("b");
		
		assertTrue("stack must have 2 elems", sstack.size() == 2);
	}
	
	@Test
	public void testPopFromTwoElems() {
		sstack = new Stack<String>();
		sstack.push("a");
		sstack.push("b");
	
		String elem = sstack.pop();
		
		assertTrue("stack must have 1 elem", sstack.size() == 1);		
		assertEquals("elem must match", "b", elem);
	}
	
	@Test
	public void testPushThreeElems() {
		sstack = new Stack<String>();
		sstack.push("a");
		sstack.push("b");
		sstack.push("c");
		
		assertTrue("stack must have 3 elems", sstack.size() == 3);
	}
	
	@Test
	public void testPopFromThreeElems() {
		sstack = new Stack<String>();
		sstack.push("a");
		sstack.push("b");
		sstack.push("c");
	
		String elem = sstack.pop();
		
		// Non-empty
		assertTrue("stack must have 2 elem", sstack.size() == 2);		
		assertEquals("elem must match", "c", elem);
		
		// Non-empty
		String other = sstack.pop();
		assertTrue("stack must have 1 elem", sstack.size() == 1);		
		assertEquals("elem must match", "b", other);
		
		// Empty
		String last = sstack.pop();
		assertTrue("stack must have 0 elems", sstack.size() == 0);		
		assertEquals("elem must match", "a", last);
		
	}	
}
