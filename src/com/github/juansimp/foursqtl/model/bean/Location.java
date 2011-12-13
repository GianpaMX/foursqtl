package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class Location implements Bean {
    private int idLocation;
    private String address;
    private String crossStreet;
    private float lat;
    private float lng;
    private String postalCode;
    private String city;
    private String state;
    private String country;

    public Location() {
        idLocation = 0;
        address = "";
        crossStreet = "";
        lat = 0;
        lng = 0;
        postalCode = "";
        city = "";
        state = "";
        country = "";
    }


	public int getIdLocation(){
		return this.idLocation;
	}
	
	public void setIdLocation(int idLocation){
		this.idLocation = idLocation;
	}
	
        public long getId() {
        return getIdLocation();
    }
    	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
    	public String getCrossStreet(){
		return this.crossStreet;
	}
	
	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}
	
    	public float getLat(){
		return this.lat;
	}
	
	public void setLat(float lat){
		this.lat = lat;
	}
	
    	public float getLng(){
		return this.lng;
	}
	
	public void setLng(float lng){
		this.lng = lng;
	}
	
    	public String getPostalCode(){
		return this.postalCode;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
    	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
    	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
    	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
        public void setData(Object[] data) {
                setIdLocation((Integer) data[0]);
                setAddress((String) data[1]);
                setCrossStreet((String) data[2]);
                setLat((Float) data[3]);
                setLng((Float) data[4]);
                setPostalCode((String) data[5]);
                setCity((String) data[6]);
                setState((String) data[7]);
                setCountry((String) data[8]);
            }
}
