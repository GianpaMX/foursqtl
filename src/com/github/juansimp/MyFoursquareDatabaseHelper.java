package com.github.juansimp;

import com.github.juansimp.foursqtl.R;
import com.github.juansimp.foursqtl.R.string;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class MyFoursquareDatabaseHelper extends SQLiteOpenHelper {
	Context c;

	public MyFoursquareDatabaseHelper(Context context) {
		super(context, context.getString(R.string.database_name), null, Integer
				.parseInt(context.getString(R.string.database_version)));
		c = context;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(c.getString(R.string.database_create));
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(MyFoursquareDatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL(c.getString(R.string.database_drop));
		onCreate(database);
	}
}
