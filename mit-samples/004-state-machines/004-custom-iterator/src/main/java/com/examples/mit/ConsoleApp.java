package com.examples.mit;

import java.util.ArrayList;

public class ConsoleApp {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		
		// Iterating with MyIterator
		MyIterator iter = new MyIterator(l);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("-- done!!!");
	}
}
