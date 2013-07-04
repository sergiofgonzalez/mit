package com.examples.mit;

import java.util.ArrayList;


/**
 * The Class MyIterator implements a mutable object that iterates over the elements of an ArrayList<String>
 *  from first to last.
 * Note that this is just an example of a home-made iterator and should not be used in an real case (you
 *  should rely on the ArrayList's own iterator returned by the iterator() method.
 */
public class MyIterator {
	
	/** The list. */
	private final ArrayList<String> l;
	
	/** The current position of the iterator on the list. */
	private int i;
	
	/**
	 * Instantiates a new my iterator.
	 *
	 * @param l the list
	 */
	public MyIterator(ArrayList<String> l) {
		this.l = l;
		this.i = 0;
	}
	
	/**
	 * Checks for the availability of a next element.
	 *
	 * @return true, if there are available elements on the list to be retrieved by the iterator
	 */
	public boolean hasNext() {
		return i < l.size();
	}
	
	/**
	 * Returns the next element of the list.
	 *
	 * @return the string
	 */
	public String next() {
		final String s = l.get(i);
		++i;
		return s;
	}
}
