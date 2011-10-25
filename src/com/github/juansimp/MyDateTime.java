package com.github.juansimp;

import java.util.Date;
import java.util.GregorianCalendar;

public class MyDateTime {
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minute;
	
	public Date toDate() {
		return new GregorianCalendar(year, month, day, hour, minute).getTime();
	}
}
