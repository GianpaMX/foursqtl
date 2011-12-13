package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.UserContact;
import com.github.juansimp.foursqtl.model.catalog.UserContactCatalog;

public class UserContactFactory implements Factory
{

    public static UserContact fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(UserContactCatalog.ID_USER)),
            cursor.getString(cursor.getColumnIndex(UserContactCatalog.PHONE)),
            cursor.getString(cursor.getColumnIndex(UserContactCatalog.EMAIL)),
            cursor.getString(cursor.getColumnIndex(UserContactCatalog.TWITTER)),
            cursor.getString(cursor.getColumnIndex(UserContactCatalog.FACEBOOK))
        };
        UserContact userContact = new UserContact();
        userContact.setData(data);
        
        return userContact;
    }

}