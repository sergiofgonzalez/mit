package com.examples.mit;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Class MyListUtilsTest provides the tests for stripTags method of MyListUtils.
 * 
 * 	l : the list with words and HTML tags
 * 
 * Testing strategy:
 * 	l.size       : 0, 1, n
 *  contents     : no tags, one tag, all tags
 *  position     : tag at start, tag in middle, tag at end
 *  kind of elem : <foo>, </foo>, word, empty string
 */
public class MyListUtilsTest {

	@Test
	public void testEmptyList() {
		ArrayList<String> l = new ArrayList<String>();	
		MyListUtils.stripTags(l);
		
		assertTrue("[] => []", l.isEmpty());
	}
	
	@Test
	public void testNoTagsSingleton() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		
		MyListUtils.stripTags(l);
		
		assertTrue("[a] => [a]", l.get(0).equals("a"));
		assertTrue(l.size() == 1);
	}
	
	@Test
	public void testNoTagsSeveral() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		
		MyListUtils.stripTags(l);
		
		assertTrue("[a, b, c] => [a, b, c]", l.get(0).equals("a") && l.get(1).equals("b") && l.get(2).equals("c"));
		assertTrue(l.size() == 3);
	}
	
	@Test
	public void testMiddleTagSeveral() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("<b>");
		l.add("c");
		
		MyListUtils.stripTags(l);
		
		assertTrue("[a, <b>, c] => [a, c]", l.get(0).equals("a") && l.get(1).equals("c"));
		assertTrue(l.size() == 2);
	}
	
	// This test fails because strip tags remove elements from the underlying list without notifying
	// MyIterator of that fact.
	// This causes that the second next() returns "<c>" and never strips "<b>"; 
	@Test
	public void testAllTagsSeveral() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("<a>");
		l.add("<b>");
		l.add("<c>");
		
		MyListUtils.stripTags(l);
		
		System.out.println(l);
		assertTrue("[<a>, <b>, <c>] => []", l.isEmpty());
	}
	
}
