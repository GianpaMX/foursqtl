package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Icon;
import com.github.juansimp.foursqtl.model.catalog.IconCatalog;

public class IconFactory implements Factory
{

    public static Icon fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(IconCatalog.ID_ICON)),
            cursor.getString(cursor.getColumnIndex(IconCatalog.PREFIX)),
            cursor.getString(cursor.getColumnIndex(IconCatalog.NAME))
        };
        Icon icon = new Icon();
        icon.setData(data);
        
        return icon;
    }

}