package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.VenueCategory;
import com.github.juansimp.foursqtl.model.catalog.VenueCategoryCatalog;

public class VenueCategoryFactory implements Factory
{

    public static VenueCategory fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(VenueCategoryCatalog.ID_VENUE)),
            cursor.getInt(cursor.getColumnIndex(VenueCategoryCatalog.ID_CATEGORY)),
            cursor.getInt(cursor.getColumnIndex(VenueCategoryCatalog.PRIMARY))
        };
        VenueCategory venueCategory = new VenueCategory();
        venueCategory.setData(data);
        
        return venueCategory;
    }

}