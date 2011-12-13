package com.github.juansimp.foursqtl.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.juansimp.MyFoursquareDatabaseHelper;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class Database {
	private static MyFoursquareDatabaseHelper dbHelper;
	private static SQLiteDatabase database;
	
	public static void init(Context context) {
		if (null != Database.database)
			return;

		Database.dbHelper = new MyFoursquareDatabaseHelper(context);
		Database.database = Database.dbHelper.getWritableDatabase();
	}

	protected static SQLiteDatabase getDatabase()
			throws UninitializedDatabaseException {
		if (null == Database.database)
			throw new UninitializedDatabaseException();
		return Database.database;
	}
}
