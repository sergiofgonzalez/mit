package com.examples.mit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class Transaction provides an immutable implementation of a banking transaction providing an
 * amount and a date as data fields.
 */
public class Transaction {
	private int amount;
	private Calendar date;
	
	public Transaction(int amount, Calendar date) {
		this.amount = amount;
		// This is called defensive copying
		this.date = (Calendar) date.clone();
	}

	public int getAmount() {
		return amount;
	}

	public Calendar getDate() {
		// prevent leaking out a reference to the object
		return (Calendar) date.clone();
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat();
		return "Transaction [amount=" + amount + ", date=" + df.format(date.getTime()) + "]";
	}
}
