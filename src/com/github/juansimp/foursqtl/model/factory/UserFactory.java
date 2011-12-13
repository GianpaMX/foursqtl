package com.github.juansimp.foursqtl.model.factory;

import android.database.Cursor;

import com.github.juansimp.foursqtl.model.Factory;
import com.github.juansimp.foursqtl.model.bean.User;
import com.github.juansimp.foursqtl.model.catalog.UserCatalog;

public class UserFactory implements Factory
{

    public static User fromCursor(Cursor cursor) {
        Object[] data = {
            cursor.getInt(cursor.getColumnIndex(UserCatalog.ID_USER)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.FIRST_NAME)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.LAST_NAME)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.PHOTO)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.GENDER)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.HOME_CITY)),
            cursor.getString(cursor.getColumnIndex(UserCatalog.RELATIONSHIP))
        };
        User user = new User();
        user.setData(data);
        
        return user;
    }

}