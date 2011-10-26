package com.github.juansimp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;

public class MyDatePicker extends MyPicker {
	public MyDatePicker(Context context, View view, MyDateTime dateTime,
			MyDateTimeUpdatable dateTimeUpdatable) {
		super(context, view, dateTime, dateTimeUpdatable);
		
		dialog = new DatePickerDialog(c, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				dt.year = year;
				dt.month = monthOfYear;
				dt.day = dayOfMonth;

				dtU.dateTimeChanged(dt);
			}
		}, dt.year, dt.month, dt.day);

		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((DatePickerDialog)dialog).updateDate(dt.year, dt.month, dt.day);
				dialog.show();
			}
		});
	}
}
