package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.IconSize;
import com.github.juansimp.foursqtl.model.catalog.IconSizeCatalog;

public class IconSizeFactory implements Factory
{

    public static IconSize fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(IconSizeCatalog.ID_ICON_SIZE)),
            cursor.getInt(cursor.getColumnIndex(IconSizeCatalog.ID_ICON)),
            cursor.getString(cursor.getColumnIndex(IconSizeCatalog.SIZE))
        };
        IconSize iconSize = new IconSize();
        iconSize.setData(data);
        
        return iconSize;
    }

}