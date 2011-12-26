package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Authentication implements Bean {
    final public static String FOURSQTL_AUTHENTICATION_ID_USER = "com.github.juansimp.foursqtl.model.bean.authentication.ID_USER";
    final public static String FOURSQTL_AUTHENTICATION_TOKEN = "com.github.juansimp.foursqtl.model.bean.authentication.TOKEN";

    private int idUser;
    private String token;

    public Authentication() {
        idUser = 0;
        token = "";
    }


	public int getIdUser(){
		return this.idUser;
	}
	
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
	
        public long getId() {
        return getIdUser();
    }
    	public String getToken(){
		return this.token;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	
        
    public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setToken((String) data[1]);
            }
    
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Authentication.FOURSQTL_AUTHENTICATION_ID_USER, String.valueOf(getIdUser()));
                intent.putExtra(Authentication.FOURSQTL_AUTHENTICATION_TOKEN, String.valueOf(getToken()));
                return intent;
    }
    
}
