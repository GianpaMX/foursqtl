package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Category;
import com.github.juansimp.foursqtl.model.catalog.CategoryCatalog;

public class CategoryFactory implements Factory
{

    public static Category fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(CategoryCatalog.ID_CATEGORY)),
            cursor.getInt(cursor.getColumnIndex(CategoryCatalog.ID_ICON)),
            cursor.getString(cursor.getColumnIndex(CategoryCatalog.NAME)),
            cursor.getString(cursor.getColumnIndex(CategoryCatalog.PLURAL_NAME)),
            cursor.getString(cursor.getColumnIndex(CategoryCatalog.SHORT_NAME))
        };
        Category category = new Category();
        category.setData(data);
        
        return category;
    }

}