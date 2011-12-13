package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Checkin;
import com.github.juansimp.foursqtl.model.factory.CheckinFactory;
import com.github.juansimp.foursqtl.model.collection.CheckinCollection;
import com.github.juansimp.foursqtl.model.exception.CheckinException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class CheckinCatalog extends AbstractCatalog<Checkin>  {
    final public static String TABLE_NAME = "checkin";
    final public static String ID_CHECKIN = "id_checkin";
    final public static String ID_USER = "id_user";
    final public static String ID_VENUE = "id_venue";
    final public static String CREATED_AT = "created_at";
    final public static String SHOUT = "shout";
    final public static String IS_MAYOR = "is_mayor";
    final public static String TIME_ZONE = "time_zone";
    
    protected static CheckinCatalog instance;
    
    public static CheckinCatalog getInstance() throws UninitializedDatabaseException {
        if(CheckinCatalog.instance == null) {
            CheckinCatalog.instance = new CheckinCatalog();
        }
        return CheckinCatalog.instance;
    }
    
    protected CheckinCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Checkin checkin) {
        ContentValues values = new ContentValues();
                values.put(CheckinCatalog.ID_CHECKIN, checkin.getIdCheckin());
                values.put(CheckinCatalog.ID_USER, checkin.getIdUser());
                values.put(CheckinCatalog.ID_VENUE, checkin.getIdVenue());
                values.put(CheckinCatalog.CREATED_AT, checkin.getCreatedAt());
                values.put(CheckinCatalog.SHOUT, checkin.getShout());
                values.put(CheckinCatalog.IS_MAYOR, checkin.getIsMayor());
                values.put(CheckinCatalog.TIME_ZONE, checkin.getTimeZone());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return CheckinCatalog.ID_CHECKIN;
    }

    @Override
    protected String getTableName() {
        return CheckinCatalog.TABLE_NAME;
    }

    @Override
    public Checkin fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return CheckinFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public CheckinCollection fetchAll() {
        CheckinCollection collection = new CheckinCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(CheckinFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }