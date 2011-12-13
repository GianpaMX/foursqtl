package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class User implements Bean {
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
	
        public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setFirstName((String) data[1]);
                setLastName((String) data[2]);
                setPhoto((String) data[3]);
                setGender((String) data[4]);
                setHomeCity((String) data[5]);
                setRelationship((String) data[6]);
            }
}
