package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Venue;
import com.github.juansimp.foursqtl.model.factory.VenueFactory;
import com.github.juansimp.foursqtl.model.collection.VenueCollection;
import com.github.juansimp.foursqtl.model.exception.VenueException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class VenueCatalog extends AbstractCatalog<Venue>  {
    final public static String TABLE_NAME = "venue";
    final public static String ID_VENUE = "id_venue";
    final public static String ID_LOCATION = "id_location";
    final public static String NAME = "name";
    final public static String URL = "url";
    
    protected static VenueCatalog instance;
    
    public static VenueCatalog getInstance() throws UninitializedDatabaseException {
        if(VenueCatalog.instance == null) {
            VenueCatalog.instance = new VenueCatalog();
        }
        return VenueCatalog.instance;
    }
    
    protected VenueCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Venue venue) {
        ContentValues values = new ContentValues();
                values.put(VenueCatalog.ID_VENUE, venue.getIdVenue());
                values.put(VenueCatalog.ID_LOCATION, venue.getIdLocation());
                values.put(VenueCatalog.NAME, venue.getName());
                values.put(VenueCatalog.URL, venue.getUrl());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return VenueCatalog.ID_VENUE;
    }

    @Override
    protected String getTableName() {
        return VenueCatalog.TABLE_NAME;
    }

    @Override
    public Venue fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return VenueFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public VenueCollection fetchAll() {
        VenueCollection collection = new VenueCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(VenueFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }