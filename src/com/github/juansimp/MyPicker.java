package com.github.juansimp;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public abstract class MyPicker {
	protected Dialog dialog;

	protected Context c;
	protected View v;
	protected MyDateTime dt;
	protected MyDateTimeUpdatable dtU;

	public MyPicker(Context context, View view, MyDateTime dateTime,
			MyDateTimeUpdatable dateTimeUpdatable) {
		c = context;
		v = view;
		dt = dateTime;
		dtU = dateTimeUpdatable;
	}
}
