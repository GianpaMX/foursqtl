package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class User implements Bean {
    final public static String FOURSQTL_USER_ID_USER = "com.github.juansimp.foursqtl.model.bean.user.ID_USER";
    final public static String FOURSQTL_USER_FIRST_NAME = "com.github.juansimp.foursqtl.model.bean.user.FIRST_NAME";
    final public static String FOURSQTL_USER_LAST_NAME = "com.github.juansimp.foursqtl.model.bean.user.LAST_NAME";
    final public static String FOURSQTL_USER_PHOTO = "com.github.juansimp.foursqtl.model.bean.user.PHOTO";
    final public static String FOURSQTL_USER_GENDER = "com.github.juansimp.foursqtl.model.bean.user.GENDER";
    final public static String FOURSQTL_USER_HOME_CITY = "com.github.juansimp.foursqtl.model.bean.user.HOME_CITY";
    final public static String FOURSQTL_USER_RELATIONSHIP = "com.github.juansimp.foursqtl.model.bean.user.RELATIONSHIP";

    private int idUser;
    private String firstName;
    private String lastName;
    private String photo;
    private String gender;
    private String homeCity;
    private String relationship;

    public User() {
        idUser = 0;
        firstName = "";
        lastName = "";
        photo = "";
        gender = "";
        homeCity = "";
        relationship = "";
    }


	public int getIdUser(){
		return this.idUser;
	}
	
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
	
        @Override
    public long getId() {
        return getIdUser();
    }
    	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
    	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
    	public String getPhoto(){
		return this.photo;
	}
	
	public void setPhoto(String photo){
		this.photo = photo;
	}
	
    	public String getGender(){
		return this.gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
    	public String getHomeCity(){
		return this.homeCity;
	}
	
	public void setHomeCity(String homeCity){
		this.homeCity = homeCity;
	}
	
    	public String getRelationship(){
		return this.relationship;
	}
	
	public void setRelationship(String relationship){
		this.relationship = relationship;
	}
	
        
    @Override
    public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setFirstName((String) data[1]);
                setLastName((String) data[2]);
                setPhoto((String) data[3]);
                setGender((String) data[4]);
                setHomeCity((String) data[5]);
                setRelationship((String) data[6]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(User.FOURSQTL_USER_ID_USER, String.valueOf(getIdUser()));
                intent.putExtra(User.FOURSQTL_USER_FIRST_NAME, String.valueOf(getFirstName()));
                intent.putExtra(User.FOURSQTL_USER_LAST_NAME, String.valueOf(getLastName()));
                intent.putExtra(User.FOURSQTL_USER_PHOTO, String.valueOf(getPhoto()));
                intent.putExtra(User.FOURSQTL_USER_GENDER, String.valueOf(getGender()));
                intent.putExtra(User.FOURSQTL_USER_HOME_CITY, String.valueOf(getHomeCity()));
                intent.putExtra(User.FOURSQTL_USER_RELATIONSHIP, String.valueOf(getRelationship()));
                return intent;
    }
    
}
