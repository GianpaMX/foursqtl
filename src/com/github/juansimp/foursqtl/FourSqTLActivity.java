package com.github.juansimp.foursqtl;

import java.text.DateFormat;
import java.util.Calendar;

import com.github.juansimp.MyDateTime;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class FourSqTLActivity extends Activity {
	static final int FROM_TIME_DIALOG_ID = 0;
	static final int FROM_DATE_DIALOG_ID = 1;
	static final int TO_TIME_DIALOG_ID = 2;
	static final int TO_DATE_DIALOG_ID = 3;

	private MyDateTime dateFrom, dateTo;
	private Button dateFromButton, dateToButton;
	private Button timeFromButton, timeToButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setupActionBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.display_options_actions, menu);
		setupDatePickers();
		
		return true;
	}

	private void setupActionBar() {
		View mCustomView = getLayoutInflater().inflate(
				R.layout.action_bar_date_interval_selector, null);
		final ActionBar bar = getActionBar();
		bar.setCustomView(mCustomView, new ActionBar.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		int flags = 0;
		flags = ActionBar.DISPLAY_HOME_AS_UP ^ ActionBar.DISPLAY_SHOW_CUSTOM;

		int change = bar.getDisplayOptions() ^ flags;
		bar.setDisplayOptions(change, flags);
	}
	
	private void setupDatePickers() {
		dateFromButton = (Button) findViewById(R.id.dateFrom);
		timeFromButton = (Button) findViewById(R.id.timeFrom);

		dateToButton = (Button) findViewById(R.id.dateTo);
		timeToButton = (Button) findViewById(R.id.timeTo);

		Button pickDate = (Button) findViewById(R.id.dateFrom);
		pickDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(FROM_DATE_DIALOG_ID);
			}
		});
		pickDate = (Button) findViewById(R.id.dateTo);
		pickDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(TO_DATE_DIALOG_ID);
			}
		});

		Button pickTime = (Button) findViewById(R.id.timeFrom);
		pickTime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(FROM_TIME_DIALOG_ID);
			}
		});
		pickTime = (Button) findViewById(R.id.timeTo);
		pickTime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(TO_TIME_DIALOG_ID);
			}
		});

		dateFrom = new MyDateTime();
		dateTo = new MyDateTime();
		final Calendar c = Calendar.getInstance();
		dateFrom.year = c.get(Calendar.YEAR);
		dateFrom.month = c.get(Calendar.MONTH);
		dateFrom.day = c.get(Calendar.DAY_OF_MONTH);
		dateFrom.hour = c.get(Calendar.HOUR_OF_DAY);
		dateFrom.minute = c.get(Calendar.MINUTE);

		dateTo.year = c.get(Calendar.YEAR);
		dateTo.month = c.get(Calendar.MONTH);
		dateTo.day = c.get(Calendar.DAY_OF_MONTH);
		dateTo.hour = c.get(Calendar.HOUR_OF_DAY);
		dateTo.minute = c.get(Calendar.MINUTE);

		updateDisplay();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case FROM_TIME_DIALOG_ID:
			return new TimePickerDialog(this, fromTimeSetListener, dateFrom.hour, dateFrom.minute, false);
		case FROM_DATE_DIALOG_ID:
			return new DatePickerDialog(this, fromDateSetListener, dateFrom.year, dateFrom.month, dateFrom.day);
		case TO_TIME_DIALOG_ID:
			return new TimePickerDialog(this, toTimeSetListener, dateTo.hour, dateTo.minute, false);
		case TO_DATE_DIALOG_ID:
			return new DatePickerDialog(this, toDateSetListener, dateTo.year, dateTo.month, dateTo.day);
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case FROM_TIME_DIALOG_ID:
			((TimePickerDialog) dialog).updateTime(dateFrom.hour, dateFrom.minute);
			break;
		case FROM_DATE_DIALOG_ID:
			((DatePickerDialog) dialog).updateDate(dateFrom.year, dateFrom.month, dateFrom.day);
			break;
		case TO_TIME_DIALOG_ID:
			((TimePickerDialog) dialog).updateTime(dateTo.hour, dateTo.minute);
			break;
		case TO_DATE_DIALOG_ID:
			((DatePickerDialog) dialog).updateDate(dateTo.year, dateTo.month, dateTo.day);
			break;
		}
	}

	private void updateDisplay() {
		dateFromButton.setText(DateFormat.getDateInstance().format(dateFrom.toDate()));
		timeFromButton.setText(new StringBuilder() 
				.append(pad(dateFrom.hour)).append(":")
				.append(pad(dateFrom.minute)));
		dateToButton.setText(DateFormat.getDateInstance().format(dateTo.toDate()));
		timeToButton.setText(new StringBuilder() 
				.append(pad(dateTo.hour)).append(":")
				.append(pad(dateTo.minute)));
	}

	private DatePickerDialog.OnDateSetListener fromDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			dateFrom.year = year;
			dateFrom.month = monthOfYear;
			dateFrom.day = dayOfMonth;
			updateDisplay();
		}
	};

	private TimePickerDialog.OnTimeSetListener fromTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			dateFrom.hour = hourOfDay;
			dateFrom.minute = minute;
			updateDisplay();
		}
	};

	private DatePickerDialog.OnDateSetListener toDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			dateTo.year = year;
			dateTo.month = monthOfYear;
			dateTo.day = dayOfMonth;
			updateDisplay();
		}
	};

	private TimePickerDialog.OnTimeSetListener toTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			dateTo.hour = hourOfDay;
			dateTo.minute = minute;
			updateDisplay();
		}
	};

	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}

}
