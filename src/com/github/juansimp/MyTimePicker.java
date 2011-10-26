package com.github.juansimp;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TimePicker;

public class MyTimePicker extends MyPicker {
	public MyTimePicker(Context context, View view, MyDateTime dateTime,
			MyDateTimeUpdatable dateTimeUpdatable) {
		super(context, view, dateTime, dateTimeUpdatable);
		
		dialog = new TimePickerDialog(c, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				dt.hour = hourOfDay;
				dt.minute = minute;

				dtU.dateTimeChanged(dt);
			}
		}, dt.hour, dt.minute, false);

		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((TimePickerDialog)dialog).updateTime(dt.hour, dt.minute);
				dialog.show();
			}
		});
	}
}
