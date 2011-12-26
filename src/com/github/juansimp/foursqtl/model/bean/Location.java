package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Location implements Bean {
    final public static String FOURSQTL_LOCATION_ID_LOCATION = "com.github.juansimp.foursqtl.model.bean.location.ID_LOCATION";
    final public static String FOURSQTL_LOCATION_ADDRESS = "com.github.juansimp.foursqtl.model.bean.location.ADDRESS";
    final public static String FOURSQTL_LOCATION_CROSS_STREET = "com.github.juansimp.foursqtl.model.bean.location.CROSS_STREET";
    final public static String FOURSQTL_LOCATION_LAT = "com.github.juansimp.foursqtl.model.bean.location.LAT";
    final public static String FOURSQTL_LOCATION_LNG = "com.github.juansimp.foursqtl.model.bean.location.LNG";
    final public static String FOURSQTL_LOCATION_POSTAL_CODE = "com.github.juansimp.foursqtl.model.bean.location.POSTAL_CODE";
    final public static String FOURSQTL_LOCATION_CITY = "com.github.juansimp.foursqtl.model.bean.location.CITY";
    final public static String FOURSQTL_LOCATION_STATE = "com.github.juansimp.foursqtl.model.bean.location.STATE";
    final public static String FOURSQTL_LOCATION_COUNTRY = "com.github.juansimp.foursqtl.model.bean.location.COUNTRY";

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
    
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Location.FOURSQTL_LOCATION_ID_LOCATION, String.valueOf(getIdLocation()));
                intent.putExtra(Location.FOURSQTL_LOCATION_ADDRESS, String.valueOf(getAddress()));
                intent.putExtra(Location.FOURSQTL_LOCATION_CROSS_STREET, String.valueOf(getCrossStreet()));
                intent.putExtra(Location.FOURSQTL_LOCATION_LAT, String.valueOf(getLat()));
                intent.putExtra(Location.FOURSQTL_LOCATION_LNG, String.valueOf(getLng()));
                intent.putExtra(Location.FOURSQTL_LOCATION_POSTAL_CODE, String.valueOf(getPostalCode()));
                intent.putExtra(Location.FOURSQTL_LOCATION_CITY, String.valueOf(getCity()));
                intent.putExtra(Location.FOURSQTL_LOCATION_STATE, String.valueOf(getState()));
                intent.putExtra(Location.FOURSQTL_LOCATION_COUNTRY, String.valueOf(getCountry()));
                return intent;
    }
    
}
