package com.github.juansimp.foursqtl.model.catalog;


import android.content.ContentValues;
import android.database.Cursor;

import com.github.juansimp.foursqtl.model.AbstractCatalog;
import com.github.juansimp.foursqtl.model.bean.User;
import com.github.juansimp.foursqtl.model.factory.UserFactory;
import com.github.juansimp.foursqtl.model.collection.UserCollection;
import com.github.juansimp.foursqtl.model.exception.UserException;
import com.github.juansimp.foursqtl.model.exception.UninitializedDatabaseException;

public class UserCatalog extends AbstractCatalog<User>  {
    final public static String TABLE_NAME = "user";
    final public static String ID_USER = "id_user";
    final public static String FIRST_NAME = "first_name";
    final public static String LAST_NAME = "last_name";
    final public static String PHOTO = "photo";
    final public static String GENDER = "gender";
    final public static String HOME_CITY = "home_city";
    final public static String RELATIONSHIP = "relationship";
    
    protected static UserCatalog instance;
    
    public static UserCatalog getInstance() throws UninitializedDatabaseException {
        if(UserCatalog.instance == null) {
            UserCatalog.instance = new UserCatalog();
        }
        return UserCatalog.instance;
    }
    
    protected UserCatalog() throws UninitializedDatabaseException {
        super();
    }

    @Override
    protected ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
                values.put(UserCatalog.ID_USER, user.getIdUser());
                values.put(UserCatalog.FIRST_NAME, user.getFirstName());
                values.put(UserCatalog.LAST_NAME, user.getLastName());
                values.put(UserCatalog.PHOTO, user.getPhoto());
                values.put(UserCatalog.GENDER, user.getGender());
                values.put(UserCatalog.HOME_CITY, user.getHomeCity());
                values.put(UserCatalog.RELATIONSHIP, user.getRelationship());
        
        return values;
    }

    @Override
    protected String getPrimaryKey() {
        return UserCatalog.ID_USER;
    }

    @Override
    protected String getTableName() {
        return UserCatalog.TABLE_NAME;
    }

    @Override
    public User fetch(long id) {
        Cursor cursor = query(getPrimaryKey() + "=" + id);
        if (cursor.moveToFirst()) {
            return UserFactory.fromCursor(cursor);
        }
        return null;
    }

    @Override
    public UserCollection fetchAll() {
        UserCollection collection = new UserCollection();
        Cursor cursor = query(null);
        if (cursor.moveToFirst()) {
            collection.add(UserFactory.fromCursor(cursor));
        }
        return collection;
    }
    
 }