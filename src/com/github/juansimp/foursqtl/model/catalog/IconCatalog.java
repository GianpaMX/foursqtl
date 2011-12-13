package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Icon;
import com.github.juansimp.foursqtl.model.factory.IconFactory;
import com.github.juansimp.foursqtl.model.collection.IconCollection;
import com.github.juansimp.foursqtl.model.exception.IconException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class IconCatalog extends AbstractCatalog<Icon>  {
    final public static String TABLE_NAME = "icon";
    final public static String ID_ICON = "id_icon";
    final public static String PREFIX = "prefix";
    final public static String NAME = "name";
    
    protected static IconCatalog instance;
    
    public static IconCatalog getInstance() throws UninitializedDatabaseException {
        if(IconCatalog.instance == null) {
            IconCatalog.instance = new IconCatalog();
        }
        return IconCatalog.instance;
    }
    
    protected IconCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Icon icon) {
        ContentValues values = new ContentValues();
                values.put(IconCatalog.ID_ICON, icon.getIdIcon());
                values.put(IconCatalog.PREFIX, icon.getPrefix());
                values.put(IconCatalog.NAME, icon.getName());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return IconCatalog.ID_ICON;
    }

    @Override
    protected String getTableName() {
        return IconCatalog.TABLE_NAME;
    }

    @Override
    public Icon fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return IconFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public IconCollection fetchAll() {
        IconCollection collection = new IconCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(IconFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }