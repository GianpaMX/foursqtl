package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Location;
import com.github.juansimp.foursqtl.model.factory.LocationFactory;
import com.github.juansimp.foursqtl.model.collection.LocationCollection;
import com.github.juansimp.foursqtl.model.exception.LocationException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class LocationCatalog extends AbstractCatalog<Location>  {
    final public static String TABLE_NAME = "location";
    final public static String ID_LOCATION = "id_location";
    final public static String ADDRESS = "address";
    final public static String CROSS_STREET = "cross_street";
    final public static String LAT = "lat";
    final public static String LNG = "lng";
    final public static String POSTAL_CODE = "postal_code";
    final public static String CITY = "city";
    final public static String STATE = "state";
    final public static String COUNTRY = "country";
    
    protected static LocationCatalog instance;
    
    public static LocationCatalog getInstance() throws UninitializedDatabaseException {
        if(LocationCatalog.instance == null) {
            LocationCatalog.instance = new LocationCatalog();
        }
        return LocationCatalog.instance;
    }
    
    protected LocationCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Location location) {
        ContentValues values = new ContentValues();
                values.put(LocationCatalog.ID_LOCATION, location.getIdLocation());
                values.put(LocationCatalog.ADDRESS, location.getAddress());
                values.put(LocationCatalog.CROSS_STREET, location.getCrossStreet());
                values.put(LocationCatalog.LAT, location.getLat());
                values.put(LocationCatalog.LNG, location.getLng());
                values.put(LocationCatalog.POSTAL_CODE, location.getPostalCode());
                values.put(LocationCatalog.CITY, location.getCity());
                values.put(LocationCatalog.STATE, location.getState());
                values.put(LocationCatalog.COUNTRY, location.getCountry());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return LocationCatalog.ID_LOCATION;
    }

    @Override
    protected String getTableName() {
        return LocationCatalog.TABLE_NAME;
    }

    @Override
    public Location fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return LocationFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public LocationCollection fetchAll() {
        LocationCollection collection = new LocationCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(LocationFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }