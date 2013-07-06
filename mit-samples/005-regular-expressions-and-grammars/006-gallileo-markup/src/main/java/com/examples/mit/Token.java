package com.examples.mit;

/**
 * The Class Token is an immutable value representing a token in a markup language.
 */
public class Token {
	
	/** The type of the token. */
	private final Type type;
	
	/** The value of the token. */
	private final String value;
	
	/**
	 * Instantiates a new token.
	 *
	 * @param type the type of the token
	 * @param value the value of the token
	 */
	public Token(Type type, String value) {
		this.type = type;
		this.value = value;
	}
	
	/**
	 * Gets the type of the token.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Gets the value of the token.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
