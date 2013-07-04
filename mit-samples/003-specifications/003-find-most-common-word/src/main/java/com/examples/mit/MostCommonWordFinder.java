package com.examples.mit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class MostCommonWordFinder provides a method for obtaining the most common word in a string.
 */
public class MostCommonWordFinder {

	/**
	 * Finds the most common word in a string of text.
	 *
	 * @param s string of words, where a word is a nonempty string of characters separated by spaces or
	 * punctuation.
	 * @return a word that occurs most often in s (at least as much as any other word). Alphabetic case is
	 * ignored when comparing words.
	 * @throws NoWordsException if the string of words is null, or empty
	 */
	public static String mostCommonWord(String s) throws NoWordsException {
		if (s == null || s.isEmpty()) {
			throw new NoWordsException();
		}
		List<String> words = splitIntoWords(s);
		Map<String,Integer> occurrencesMap = countOccurrences(words);
		return findMax(occurrencesMap);
	}
	
	/***
	 * Splits s into words.
	 * @param s string to split
	 * @return list of words found in s, in order of their occurrence (where word is defined by the spec for
	 * 	mostCommonWord)
	 */
	private static List<String> splitIntoWords(String s) {
		String[] words = s.split(" ");
		return Arrays.asList(words);
	}
	
	/***
	 * Count the number of occurrences of each element in a list.
	 * @param l list of strings
	 * @return map m such that m[s] == k if s occurs k times in l, while m[s] == null if s never occurs in l
	 */
	private static Map<String,Integer> countOccurrences(List<String> l) {
		Map<String,Integer> occurrencesMap = new HashMap<String, Integer>();
		for (String word : l) {
			String lowerCaseWord = word.toLowerCase(Locale.getDefault());
			if (occurrencesMap.containsKey(lowerCaseWord)) {
				Integer occurrence = occurrencesMap.get(lowerCaseWord);
				occurrence++;
				occurrencesMap.put(lowerCaseWord, occurrence);
			} else {
				occurrencesMap.put(lowerCaseWord, 1);
			}
		}
		
		return occurrencesMap;
	}
	
	/**
	 * Finds a key with maximum value.
	 * @param m frequency counts for strings
	 * @return s such that m[s] >= m[t] for all other keys t in the map or null if no such s exists
	 */
	private static String findMax(Map<String,Integer> m) {
		Entry<String,Integer> maxEntry = null;
		for (Entry<String,Integer> entry : m.entrySet()) {
			if (maxEntry == null) {
				maxEntry = entry;
			} else {
				if (entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
		}		
		return maxEntry.getKey();
	}	
}
