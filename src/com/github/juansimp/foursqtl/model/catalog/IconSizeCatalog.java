package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.IconSize;
import com.github.juansimp.foursqtl.model.factory.IconSizeFactory;
import com.github.juansimp.foursqtl.model.collection.IconSizeCollection;
import com.github.juansimp.foursqtl.model.exception.IconSizeException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class IconSizeCatalog extends AbstractCatalog<IconSize>  {
    final public static String TABLE_NAME = "icon_size";
    final public static String ID_ICON_SIZE = "id_icon_size";
    final public static String ID_ICON = "id_icon";
    final public static String SIZE = "size";
    
    protected static IconSizeCatalog instance;
    
    public static IconSizeCatalog getInstance() throws UninitializedDatabaseException {
        if(IconSizeCatalog.instance == null) {
            IconSizeCatalog.instance = new IconSizeCatalog();
        }
        return IconSizeCatalog.instance;
    }
    
    protected IconSizeCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(IconSize iconSize) {
        ContentValues values = new ContentValues();
                values.put(IconSizeCatalog.ID_ICON_SIZE, iconSize.getIdIconSize());
                values.put(IconSizeCatalog.ID_ICON, iconSize.getIdIcon());
                values.put(IconSizeCatalog.SIZE, iconSize.getSize());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return IconSizeCatalog.ID_ICON_SIZE;
    }

    @Override
    protected String getTableName() {
        return IconSizeCatalog.TABLE_NAME;
    }

    @Override
    public IconSize fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return IconSizeFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public IconSizeCollection fetchAll() {
        IconSizeCollection collection = new IconSizeCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(IconSizeFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }