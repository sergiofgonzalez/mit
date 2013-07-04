package com.examples.mit;

import junit.framework.Assert;

import org.junit.Test;


/**
 * The Class MostCommonWordFinderTest tests MostCommonWordFinder.
 * 
 * MostCommonWordFinder details:
 * 		- s : text to be searched through for the most common word
 * 		- w : the most common word
 * 
 * + s : null, empty, single word, several words.
 * - w : NoWordsException, word.
 */
public class MostCommonWordFinderTest {

	@Test(expected=NoWordsException.class)
	public void testNullString() throws NoWordsException {
		MostCommonWordFinder.mostCommonWord(null);
	}
	
	@Test(expected=NoWordsException.class)
	public void testEmptyString() throws NoWordsException {
		MostCommonWordFinder.mostCommonWord("");
	}
	
	@Test
	public void testSingleWord() throws NoWordsException {
		String word = MostCommonWordFinder.mostCommonWord("vampire");
		Assert.assertEquals("word must match vampire", "vampire", word);
	}
	
	@Test
	public void testSeveralWordsNoReps() throws NoWordsException {
		String word = MostCommonWordFinder.mostCommonWord("the world is a vampire");
		Assert.assertTrue("word must match vampire", 
				word.equals("the") || word.equals("world") ||
				word.equals("is") || word.equals("a") || word.equals("vampire"));
	}
	
	@Test
	public void testSeveralWordsWithReps() throws NoWordsException {
		String word = MostCommonWordFinder
				.mostCommonWord("this is your life. It does not get any better than this");
		Assert.assertEquals("word must match this", "this", word);
	}
	
	@Test
	public void testCasingIsIgnored() throws NoWordsException {
		String word = MostCommonWordFinder
				.mostCommonWord("This is your life. It does not get any better than this");
		Assert.assertEquals("word must match this", "this", word);
	}
}
