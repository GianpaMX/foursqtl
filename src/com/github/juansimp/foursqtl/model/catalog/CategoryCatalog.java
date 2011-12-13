package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Category;
import com.github.juansimp.foursqtl.model.factory.CategoryFactory;
import com.github.juansimp.foursqtl.model.collection.CategoryCollection;
import com.github.juansimp.foursqtl.model.exception.CategoryException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class CategoryCatalog extends AbstractCatalog<Category>  {
    final public static String TABLE_NAME = "category";
    final public static String ID_CATEGORY = "id_category";
    final public static String ID_ICON = "id_icon";
    final public static String NAME = "name";
    final public static String PLURAL_NAME = "plural_name";
    final public static String SHORT_NAME = "short_name";
    
    protected static CategoryCatalog instance;
    
    public static CategoryCatalog getInstance() throws UninitializedDatabaseException {
        if(CategoryCatalog.instance == null) {
            CategoryCatalog.instance = new CategoryCatalog();
        }
        return CategoryCatalog.instance;
    }
    
    protected CategoryCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Category category) {
        ContentValues values = new ContentValues();
                values.put(CategoryCatalog.ID_CATEGORY, category.getIdCategory());
                values.put(CategoryCatalog.ID_ICON, category.getIdIcon());
                values.put(CategoryCatalog.NAME, category.getName());
                values.put(CategoryCatalog.PLURAL_NAME, category.getPluralName());
                values.put(CategoryCatalog.SHORT_NAME, category.getShortName());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return CategoryCatalog.ID_CATEGORY;
    }

    @Override
    protected String getTableName() {
        return CategoryCatalog.TABLE_NAME;
    }

    @Override
    public Category fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return CategoryFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public CategoryCollection fetchAll() {
        CategoryCollection collection = new CategoryCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(CategoryFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }