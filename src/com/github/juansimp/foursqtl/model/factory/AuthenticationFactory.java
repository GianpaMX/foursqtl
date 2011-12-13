package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.Authentication;
import com.github.juansimp.foursqtl.model.catalog.AuthenticationCatalog;

public class AuthenticationFactory implements Factory
{

    public static Authentication fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(AuthenticationCatalog.ID_USER)),
            cursor.getString(cursor.getColumnIndex(AuthenticationCatalog.TOKEN))
        };
        Authentication authentication = new Authentication();
        authentication.setData(data);
        
        return authentication;
    }

}