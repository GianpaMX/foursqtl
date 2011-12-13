package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.Authentication;
import com.github.juansimp.foursqtl.model.factory.AuthenticationFactory;
import com.github.juansimp.foursqtl.model.collection.AuthenticationCollection;
import com.github.juansimp.foursqtl.model.exception.AuthenticationException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class AuthenticationCatalog extends AbstractCatalog<Authentication>  {
    final public static String TABLE_NAME = "authentication";
    final public static String ID_USER = "id_user";
    final public static String TOKEN = "token";
    
    protected static AuthenticationCatalog instance;
    
    public static AuthenticationCatalog getInstance() throws UninitializedDatabaseException {
        if(AuthenticationCatalog.instance == null) {
            AuthenticationCatalog.instance = new AuthenticationCatalog();
        }
        return AuthenticationCatalog.instance;
    }
    
    protected AuthenticationCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(Authentication authentication) {
        ContentValues values = new ContentValues();
                values.put(AuthenticationCatalog.ID_USER, authentication.getIdUser());
                values.put(AuthenticationCatalog.TOKEN, authentication.getToken());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return AuthenticationCatalog.ID_USER;
    }

    @Override
    protected String getTableName() {
        return AuthenticationCatalog.TABLE_NAME;
    }

    @Override
    public Authentication fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return AuthenticationFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public AuthenticationCollection fetchAll() {
        AuthenticationCollection collection = new AuthenticationCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(AuthenticationFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }