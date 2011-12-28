package com.github.juansimp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDateTime {
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minute;

	public MyDateTime() {
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
	}

	public MyDateTime(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date toDate() {
		return new GregorianCalendar(year, month, day, hour, minute).getTime();
	}

	public String toDateString() {
		return DateFormat.getDateInstance().format(toDate());
	}

	public String toTimeString() {
		return pad(hour) + ":" + pad(minute);
	}

	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}
	
	public long toUnixTimeStamp() {
		return toDate().getTime() / 1000;
	}
}
