package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.VenueCategory;
import com.github.juansimp.foursqtl.model.factory.VenueCategoryFactory;
import com.github.juansimp.foursqtl.model.collection.VenueCategoryCollection;
import com.github.juansimp.foursqtl.model.exception.VenueCategoryException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class VenueCategoryCatalog extends AbstractCatalog<VenueCategory>  {
    final public static String TABLE_NAME = "venue_category";
    final public static String ID_VENUE = "id_venue";
    final public static String ID_CATEGORY = "id_category";
    final public static String PRIMARY = "primary";
    
    protected static VenueCategoryCatalog instance;
    
    public static VenueCategoryCatalog getInstance() throws UninitializedDatabaseException {
        if(VenueCategoryCatalog.instance == null) {
            VenueCategoryCatalog.instance = new VenueCategoryCatalog();
        }
        return VenueCategoryCatalog.instance;
    }
    
    protected VenueCategoryCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(VenueCategory venueCategory) {
        ContentValues values = new ContentValues();
                values.put(VenueCategoryCatalog.ID_VENUE, venueCategory.getIdVenue());
                values.put(VenueCategoryCatalog.ID_CATEGORY, venueCategory.getIdCategory());
                values.put(VenueCategoryCatalog.PRIMARY, venueCategory.getPrimary());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return VenueCategoryCatalog.ID_VENUE;
    }

    @Override
    protected String getTableName() {
        return VenueCategoryCatalog.TABLE_NAME;
    }

    @Override
    public VenueCategory fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return VenueCategoryFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public VenueCategoryCollection fetchAll() {
        VenueCategoryCollection collection = new VenueCategoryCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(VenueCategoryFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }