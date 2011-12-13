package com.github.juansimp.foursqtl.model;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public abstract class AbstractCatalog<T extends Bean> {
    protected SQLiteDatabase database;
    
    protected AbstractCatalog() throws UninitializedDatabaseException {
        database = Database.getDatabase();
    }
    
    public long insert(T bean) {
        ContentValues values = getContentValues(bean);
        return database.insert(getTableName(), null, values);
    }
    
    public long update(T bean) {
        ContentValues values = getContentValues(bean);
        return database.update(getTableName(), values, getPrimaryKey() + " = " + bean.getId(), null);
    }
    
    public long save(T bean) {
        if(bean.getId() == 0) {
            return insert(bean);
        } else {
            return update(bean);
        }
    }
    
    protected Cursor query(String selection) throws SQLException {
        return database.query(true, getTableName(), null, selection, null, null, null, null, null);
    }
    
    public abstract T fetch(long id);
    public abstract ArrayList<T> fetchAll();
    
    protected abstract String getPrimaryKey();
    protected abstract ContentValues getContentValues(T bean);
    protected abstract String getTableName();
}
