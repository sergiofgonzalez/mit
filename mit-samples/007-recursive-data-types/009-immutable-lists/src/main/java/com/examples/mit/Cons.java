package com.examples.mit;

public class Cons<E> implements ImList<E> {

	private E e;
	private ImList<E> rest;
	
	public Cons(E e, ImList<E> rest) {
		this.e = e;
		this.rest = rest;
	}
	
	@Override
	public ImList<E> cons(E e) {
		return new Cons<E>(e, this);
	}

	@Override
	public E first() {
		return e;
	}

	@Override
	public ImList<E> rest() {
		return rest;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 1 + rest.size();
	}

}
