package com.examples.mit;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Stack is a custom implementation of a Stack.
 * A Stack is a mutable object representing a last-in-first-out stack of elements of Strings.
 * Elements can be pushed onto the stack and then popped off in the reverse order that they were pushed.
 * A Stack can hold an arbitrary number of elements, but this implementation is limited to 3 elements
 *
 */
public class FixedStack {

	/** The Constant MAX_SIZE. */
	private static final int MAX_SIZE = 3;
	
	
	/** The elems contains the elements in the stack in order from the oldest pushed (elems[0]) to
	 * the latest item pushed, and the next to be popped(elems[size-1]).
	 * If elems.size == 0 the stack is empty
	 * If elems.size == max the stack is full 
	 */
	private String[] elems = new String[3];

	/** The position of the top of the stack. */
	private int i;
	
	/**
	 * Instantiates a new empty stack.
	 */
	public FixedStack()	{
		i = -1;
	}
	
	/**
	 * Modifies this stack by pushing an element onto it.
	 *
	 * @param e the element to push on top
	 */
	public void push(String e) {
		i++;
		elems[i] = e;
	}
	
	/**
	 * Modifies this stack by popping off the top element.
	 * Requires the stack to be non-empty (i.e. size() > 0).
	 *
	 * @return the element on top of the stack
	 */
	public String pop() {		
		String top = elems[i];
		if (i >= 0) {
			--i;
		}
		return top;
	}
	
	/**
	 * Returns the number of elements in the stack.
	 *
	 * @return the number of elements in the stack
	 */
	public int size() {
		return i + 1;
	}
	
}
