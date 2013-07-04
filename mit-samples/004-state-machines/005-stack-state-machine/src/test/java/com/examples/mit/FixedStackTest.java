package com.examples.mit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class FixedStackTest provides the unit tests for FixedStack class.
 * 
 * size : the number of elements of the stack
 * 
 * Testing strategy: 
 * size : 0, 1, 2, 3 (full)
 * 
 * test cases:
 * 	[]  + push(a)           => [a]
 *  [a] + pop()             => [], a
 *  [a] + push(b)           => [a, b]
 *  [a, b] + pop()          => [a], b
 *  [a, b] + push(c)        => [a, b, c]
 *  [a, b, c] + pop()       => [a, b], c
 */
public class FixedStackTest {

	private FixedStack sstack;

	@Test
	public void testNewStackIsEmpty() {
		sstack = new FixedStack();
		assertTrue("initialized Stack must be empty", sstack.size() == 0);
	}
	
	@Test
	public void testPushOnEmpty() {
		sstack = new FixedStack();
		sstack.push("a");
		
		assertTrue("stack must have 1 elem", sstack.size() == 1);		
	}
	
	@Test
	public void testPopOnSingleton() {
		sstack = new FixedStack();
		sstack.push("a");
		
		String elem = sstack.pop();
		assertTrue("stack must be empty", sstack.size() == 0);
		assertEquals("elem must match", "a", elem);
	}

	@Test
	public void testPushTwoElems() {
		sstack = new FixedStack();
		sstack.push("a");
		sstack.push("b");
		
		assertTrue("stack must have 2 elems", sstack.size() == 2);
	}
	
	@Test
	public void testPopFromTwoElems() {
		sstack = new FixedStack();
		sstack.push("a");
		sstack.push("b");
	
		String elem = sstack.pop();
		
		assertTrue("stack must have 1 elem", sstack.size() == 1);		
		assertEquals("elem must match", "b", elem);
	}
	
	@Test
	public void testPushThreeElems() {
		sstack = new FixedStack();
		sstack.push("a");
		sstack.push("b");
		sstack.push("c");
		
		assertTrue("stack must have 3 elems", sstack.size() == 3);
	}
	
	@Test
	public void testPopFromThreeElems() {
		sstack = new FixedStack();
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
	
	@Test
	public void testAsStateMachine() {
		sstack = new FixedStack();
		assertTrue("state empty", sstack.size() == 0);
		
		sstack.push("a");
		assertTrue("state some//Transition empty => some", sstack.size() == 1);
		
		sstack.pop();
		assertTrue("state empty//Transition some => empty", sstack.size() == 0);
		
		sstack.push("a");
		sstack.push("b");
		sstack.push("c");
		assertTrue("state full//Transition some => full", sstack.size() == 3);
		
		sstack.pop();
		assertTrue("state some//Transition full => some", sstack.size() == 2);
	}
}
