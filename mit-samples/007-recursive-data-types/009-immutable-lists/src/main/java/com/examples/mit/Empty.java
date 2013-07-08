package com.examples.mit;

public class Empty<E> implements ImList<E> {
	
	@Override
	public ImList<E> cons(E e) {
		return new Cons<E>(e, this);
	}

	@Override
	public E first() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImList<E> rest() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int size() {
		return 0;
	}

}
