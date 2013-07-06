package com.examples.mit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The Class Gallileo implements a parser/evaluator for markdown that scrambles italic test (generates a 
 * random anagram of each italic part so that Kepler can't read it.
 */
public class Gallileo {

	/** The lexer for the markdown language. */
	private final MarkdownLexer lex;
	
	/**
	 * Instantiates a new gallileo.
	 *
	 * @param markdown the markdown text to be parsed
	 */
	public Gallileo(String markdown) {
		this.lex = new MarkdownLexer(markdown);
	}
	
	/**
	 * Evaluates the input text, scrambling italic sections.
	 * Can be called only once on a given object.
	 * Modifies the object, consuming all the text.
	 *
	 * @return the string of text with markdown formatting removed and italic sections replaced by a random
	 * anagram.
	 * For example, new Gallileo("The killer was _Mrs. White_").eval() ==> The killer was hrW.sM tie"
	 */
	public String eval() {
		return evalMarkdown();
	}
	
	/**
	 * The parser for markdown implementation.<br>
	 * Markdown ::= (Normal | Italic)*<br>
	 * Italic ::= _Text_<br>
	 * Normal :== Text<br>
	 * Text :== [^_]*<br>	 
	 * Modifies lex by consuming all the remaining tokens.
	 * @return the evaluated string
	 */
	private String evalMarkdown() {
		StringBuilder sb = new StringBuilder();
		for (Token tok = lex.next(); tok.getType() != Type.EOF; tok = lex.next()) {
			switch (tok.getType()) {
				case UNDERLINE:
					sb.append(evalItalic(tok));
					break;
				case TEXT:
					sb.append(evalNormal(tok));
					break;
				default:
					throw new AssertionError("unexpected token: " + tok.getType());
			}
		}
		
		return sb.toString();
	}

	/**
	 * Evaluates the italic production of the grammar.
	 * Modifies lex by consuming an entire production, including the last token of the production.
	 *
	 * @param tok the token that started this production
	 * @return the evaluated string
	 */
	private String evalItalic(Token tok) {
		StringBuilder sb = new StringBuilder();
		
		for (tok = lex.next(); tok.getType() != Type.EOF && tok.getType() != Type.UNDERLINE; tok = lex.next()) {
			if (tok.getType() == Type.TEXT) {
				sb.append(shuffle(tok.getValue()));
			} else {
				throw new AssertionError("unexpected token: " + tok.getType());
			}
		}
		
		return sb.toString();
	}

	/**
	 * Makes a random anagram of a string.
	 *
	 * @param s the string to rearrange
	 * @return a random permutation of the characters in s.
	 * For example, shuffle("abc") might return "bca" or "cba" or "abc"
	 */
	private String shuffle(String s) {
		String[] a = s.split("");
		List<String> l = Arrays.asList(a);
		Collections.shuffle(l);

		StringBuilder sb = new StringBuilder();
		for (String t : l) {
			sb.append(t);
		}
		
		return sb.toString();
	}

	/**
	 * Evaluates the normal production of the grammar.
	 *
	 * @param tok the token that started this production.
	 * @return the evaluated string
	 */
	private String evalNormal(Token tok) {
		return tok.getValue();
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Gallileo g = new Gallileo("I've discovered that _Saturn has ears_.");
		System.out.println(g.eval());
	}
	
}
