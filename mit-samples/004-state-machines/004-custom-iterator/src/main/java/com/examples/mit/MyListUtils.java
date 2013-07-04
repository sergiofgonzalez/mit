package com.examples.mit;

import java.util.ArrayList;

/**
 * The Class MyListUtils contains the implementatio of stripTags to show the risks of mutation.
 */
public class MyListUtils {

	/**
	 * Strip the HTML tags from a list of Strings using MyIterator.
	 * Modifies l by removing elements of the form "<*>"
	 *
	 * @param l the list that contains words and HTML tags
	 */
	public static void stripTags(ArrayList<String> l) {
		MyIterator myIter = new MyIterator(l);
		while (myIter.hasNext()) {
			String s = myIter.next();
			if (isTag(s)) {
				l.remove(s);
			}
		}
	}
	
	/**
	 * Checks if a string is an HTML type tag.
	 *
	 * @param s the string to be tested
	 * @return true, if s is of the form "<*>"
	 */
	private static boolean isTag(String s) {
		if (s.startsWith("<") && s.endsWith(">")) {
			return true;
		} else {
			return false;
		}
	}
}
