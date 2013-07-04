package com.examples.mit;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Stack is a custom implementation of a Stack.
 * A Stack is a mutable object representing a last-in-first-out stack of elements of an arbitrary type E.
 * Elements can be pushed onto the stack and then popped off in the reverse order that they were pushed.
 * A Stack can hold an arbitrary number of elements
 *
 * @param <E> the type of elements that the Stack holds
 */
public class Stack<E> {

	/** The elems contains the elements in the stack in order from the oldest pushed (elems[0]) to
	 * the latest item pushed, and the next to be popped(elems[size-1]).
	 * If elems.size == 0 the stack is empty 
	 */
	private List<E> elems;
	
	/**
	 * Instantiates a new empty stack.
	 */
	public Stack()	{
		elems = new ArrayList<E>();
	}
	
	/**
	 * Modifies this stack by pushing an element onto it.
	 *
	 * @param e the element to push on top
	 */
	public void push(E e) {
		elems.add(e);
	}
	
	/**
	 * Modifies this stack by popping off the top element.
	 * Requires the stack to be non-empty (i.e. size() > 0).
	 *
	 * @return the element on top of the stack
	 */
	public E pop() {
		E top = elems.get(elems.size() - 1);
		elems.remove(elems.size() - 1);
		return top;
	}
	
	/**
	 * Returns the number of elements in the stack.
	 *
	 * @return the number of elements in the stack
	 */
	public int size() {
		return elems.size();
	}
	
}
