package com.examples.mit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImListTest {

	@Test
	public void testEmpty() {
		ImList<Integer> nil = new Empty<Integer>();
		assertEquals("number of elements", 0, nil.size());
	}
	
	@Test
	public void testSingleton() {
		ImList<Integer> nil = new Empty<Integer>();
		ImList<Integer> l = nil.cons(0);
		
		assertEquals("number of elements", 1, l.size());
		assertEquals("head", Integer.valueOf(0), l.first());
		assertEquals("num of tail elements", 0, l.rest().size());
		
	}
	
	@Test
	public void severalElems() {
		ImList<Integer> nil = new Empty<Integer>();
		ImList<Integer> l = nil.cons(0).cons(1).cons(2);
		
		assertEquals("number of elements", 3, l.size());
		assertEquals("head", Integer.valueOf(2), l.first());
		assertEquals("num of tail elements", 2, l.rest().size());
		assertEquals("tail-head", Integer.valueOf(1), l.rest().first());
		assertEquals("tail-tail num of elems", 1, l.rest().rest().size());
	}

}
