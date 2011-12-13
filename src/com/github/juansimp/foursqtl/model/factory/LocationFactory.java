package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Location;
import com.github.juansimp.foursqtl.model.catalog.LocationCatalog;

public class LocationFactory implements Factory
{

    public static Location fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(LocationCatalog.ID_LOCATION)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.ADDRESS)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.CROSS_STREET)),
            cursor.getFloat(cursor.getColumnIndex(LocationCatalog.LAT)),
            cursor.getFloat(cursor.getColumnIndex(LocationCatalog.LNG)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.POSTAL_CODE)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.CITY)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.STATE)),
            cursor.getString(cursor.getColumnIndex(LocationCatalog.COUNTRY))
        };
        Location location = new Location();
        location.setData(data);
        
        return location;
    }

}