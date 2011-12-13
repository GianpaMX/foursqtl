package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Checkin;
import com.github.juansimp.foursqtl.model.catalog.CheckinCatalog;

public class CheckinFactory implements Factory
{

    public static Checkin fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(CheckinCatalog.ID_CHECKIN)),
            cursor.getInt(cursor.getColumnIndex(CheckinCatalog.ID_USER)),
            cursor.getInt(cursor.getColumnIndex(CheckinCatalog.ID_VENUE)),
            cursor.getInt(cursor.getColumnIndex(CheckinCatalog.CREATED_AT)),
            cursor.getString(cursor.getColumnIndex(CheckinCatalog.SHOUT)),
            cursor.getInt(cursor.getColumnIndex(CheckinCatalog.IS_MAYOR)),
            cursor.getString(cursor.getColumnIndex(CheckinCatalog.TIME_ZONE))
        };
        Checkin checkin = new Checkin();
        checkin.setData(data);
        
        return checkin;
    }

}