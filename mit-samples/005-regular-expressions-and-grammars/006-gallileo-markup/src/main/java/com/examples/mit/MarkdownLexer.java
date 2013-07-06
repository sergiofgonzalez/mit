package com.examples.mit;

/**
 * The Class MarkdownLexer is a mutable object that generates a stream of tokens from a string in markdown
 * format. <br>
 *
 * Markdown is a type of markup language that represents typographic style in plain text:
 * This is _italic_.<br>
 * 
 * The grammar for this simplified version of markdown (only italics are allowed) is simple:<br>
 * Markdown ::= (Normal | Italic)*<br>
 * Italic ::= _Text_<br>
 * Normal :== Text<br>
 * Text :== [^_]*<br>
 */
public class MarkdownLexer {

	/** The string to be analyzed by the lexer. */
	private final String s;
	
	/** The position within the string to be analyzed. */
	private int i;
	
	/**
	 * Instantiates a new markdown lexer.
	 *
	 * @param s the string to be analyzed by this lexer
	 */
	public MarkdownLexer(String s) {
		this.s = s;
	}
	
	/**
	 * Next returns the next token.
	 * Modifies this object by consuming a token from the input stream.
	 *
	 * @return the next token on the stream, or EOF token if there are no more tokens in the strem.
	 */
	public Token next() {
		if (i >= s.length()) {
			return new Token(Type.EOF, "");
		}
		
		switch (s.charAt(i)) {
			case '_' :
				++i;
				return new Token(Type.UNDERLINE, "_");
				
			default:
				int start = i;
				while (i < s.length() && s.charAt(i) != '_') {
					++i;
				}
				int end = i;
				return new Token(Type.TEXT, s.substring(start, end));
		}
	}
}
