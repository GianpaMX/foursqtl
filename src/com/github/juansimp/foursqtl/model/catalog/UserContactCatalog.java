package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.UserContact;
import com.github.juansimp.foursqtl.model.factory.UserContactFactory;
import com.github.juansimp.foursqtl.model.collection.UserContactCollection;
import com.github.juansimp.foursqtl.model.exception.UserContactException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class UserContactCatalog extends AbstractCatalog<UserContact>  {
    final public static String TABLE_NAME = "user_contact";
    final public static String ID_USER = "id_user";
    final public static String PHONE = "phone";
    final public static String EMAIL = "email";
    final public static String TWITTER = "twitter";
    final public static String FACEBOOK = "facebook";
    
    protected static UserContactCatalog instance;
    
    public static UserContactCatalog getInstance() throws UninitializedDatabaseException {
        if(UserContactCatalog.instance == null) {
            UserContactCatalog.instance = new UserContactCatalog();
        }
        return UserContactCatalog.instance;
    }
    
    protected UserContactCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(UserContact userContact) {
        ContentValues values = new ContentValues();
                values.put(UserContactCatalog.ID_USER, userContact.getIdUser());
                values.put(UserContactCatalog.PHONE, userContact.getPhone());
                values.put(UserContactCatalog.EMAIL, userContact.getEmail());
                values.put(UserContactCatalog.TWITTER, userContact.getTwitter());
                values.put(UserContactCatalog.FACEBOOK, userContact.getFacebook());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return UserContactCatalog.ID_USER;
    }

    @Override
    protected String getTableName() {
        return UserContactCatalog.TABLE_NAME;
    }

    @Override
    public UserContact fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return UserContactFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public UserContactCollection fetchAll() {
        UserContactCollection collection = new UserContactCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(UserContactFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }