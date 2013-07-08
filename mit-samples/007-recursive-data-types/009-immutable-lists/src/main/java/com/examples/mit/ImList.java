package com.examples.mit;

/**
 * ImList defines the interface of an immutable List.
 *
 * @param <E> the type of the elements this list holds
 */
public interface ImList<E> {
	
	/**
	 * Constructs a new list adding the element e at the head of the list.
	 *
	 * @param e the element to put at the head of the list
	 * @return the immutable list resulting of putting e at the top of the list
	 */
	ImList<E> cons(E e);
	
	/**
	 * Returns the head of the immutable list.
	 *
	 * @return the head of the list
	 */
	E first();
	
	/**
	 * Returns the immutable list resulting of removing the head of the list.
	 *
	 * @return the immutable list resulting of removing the head of the list.
	 */
	ImList<E> rest();
	
	/**
	 * Checks if the inmmutable list is empty.
	 *
	 * @return true, if the list contains no elements
	 */
	boolean isEmpty();
	
	/**
	 * Returns the number of elements of the immutable list.
	 *
	 * @return the number of elements of the list, 0 if the list is empty
	 */
	int size();
}
