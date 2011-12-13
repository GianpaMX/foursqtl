package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Venue;
import com.github.juansimp.foursqtl.model.catalog.VenueCatalog;

public class VenueFactory implements Factory
{

    public static Venue fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(VenueCatalog.ID_VENUE)),
            cursor.getInt(cursor.getColumnIndex(VenueCatalog.ID_LOCATION)),
            cursor.getString(cursor.getColumnIndex(VenueCatalog.NAME)),
            cursor.getString(cursor.getColumnIndex(VenueCatalog.URL))
        };
        Venue venue = new Venue();
        venue.setData(data);
        
        return venue;
    }

}