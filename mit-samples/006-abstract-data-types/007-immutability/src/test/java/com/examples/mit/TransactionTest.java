package com.examples.mit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TransactionTest {

	private Transaction transaction;
	
	@Test
	public void testImmutabilityMakeNextPayment() {
		transaction = new Transaction(10, Calendar.getInstance());
		
		// Calculate next payment
		Calendar nextDate = transaction.getDate();
		nextDate.add(Calendar.MONTH, 1);
		
		Transaction nextTransaction = new Transaction(transaction.getAmount(), nextDate);
		
		System.out.println(transaction);
		System.out.println(nextTransaction);
	}
	
	@Test
	public void testImmutabilityMakeYearPayments() {
		List<Transaction> transactions = new ArrayList<Transaction>(12);
		int fixedAmount = 10;
		
		Calendar date = Calendar.getInstance();
		for (int i = 0; i < 12; i++) {
			transactions.add(new Transaction(fixedAmount, date));
			date.add(Calendar.MONTH, 1);
		}
		
		System.out.println(transactions);
		
	}
}
