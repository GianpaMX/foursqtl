package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class UserContact implements Bean {
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
	
        public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setPhone((String) data[1]);
                setEmail((String) data[2]);
                setTwitter((String) data[3]);
                setFacebook((String) data[4]);
            }
}
