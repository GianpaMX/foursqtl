package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class UserContact implements Bean {
    final public static String FOURSQTL_USERCONTACT_ID_USER = "com.github.juansimp.foursqtl.model.bean.userContact.ID_USER";
    final public static String FOURSQTL_USERCONTACT_PHONE = "com.github.juansimp.foursqtl.model.bean.userContact.PHONE";
    final public static String FOURSQTL_USERCONTACT_EMAIL = "com.github.juansimp.foursqtl.model.bean.userContact.EMAIL";
    final public static String FOURSQTL_USERCONTACT_TWITTER = "com.github.juansimp.foursqtl.model.bean.userContact.TWITTER";
    final public static String FOURSQTL_USERCONTACT_FACEBOOK = "com.github.juansimp.foursqtl.model.bean.userContact.FACEBOOK";

    private int idUser;
    private String phone;
    private String email;
    private String twitter;
    private String facebook;

    public UserContact() {
        idUser = 0;
        phone = "";
        email = "";
        twitter = "";
        facebook = "";
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
    	public String getPhone(){
		return this.phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
    	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
    	public String getTwitter(){
		return this.twitter;
	}
	
	public void setTwitter(String twitter){
		this.twitter = twitter;
	}
	
    	public String getFacebook(){
		return this.facebook;
	}
	
	public void setFacebook(String facebook){
		this.facebook = facebook;
	}
	
        
    @Override
    public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setPhone((String) data[1]);
                setEmail((String) data[2]);
                setTwitter((String) data[3]);
                setFacebook((String) data[4]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(UserContact.FOURSQTL_USERCONTACT_ID_USER, String.valueOf(getIdUser()));
                intent.putExtra(UserContact.FOURSQTL_USERCONTACT_PHONE, String.valueOf(getPhone()));
                intent.putExtra(UserContact.FOURSQTL_USERCONTACT_EMAIL, String.valueOf(getEmail()));
                intent.putExtra(UserContact.FOURSQTL_USERCONTACT_TWITTER, String.valueOf(getTwitter()));
                intent.putExtra(UserContact.FOURSQTL_USERCONTACT_FACEBOOK, String.valueOf(getFacebook()));
                return intent;
    }
    
}
