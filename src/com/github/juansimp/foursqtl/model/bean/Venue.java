package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Venue implements Bean {
    final public static String FOURSQTL_VENUE_ID_VENUE = "com.github.juansimp.foursqtl.model.bean.venue.ID_VENUE";
    final public static String FOURSQTL_VENUE_ID_LOCATION = "com.github.juansimp.foursqtl.model.bean.venue.ID_LOCATION";
    final public static String FOURSQTL_VENUE_NAME = "com.github.juansimp.foursqtl.model.bean.venue.NAME";
    final public static String FOURSQTL_VENUE_URL = "com.github.juansimp.foursqtl.model.bean.venue.URL";

    private int idVenue;
    private int idLocation;
    private String name;
    private String url;

    public Venue() {
        idVenue = 0;
        idLocation = 0;
        name = "";
        url = "";
    }


	public int getIdVenue(){
		return this.idVenue;
	}
	
	public void setIdVenue(int idVenue){
		this.idVenue = idVenue;
	}
	
        public long getId() {
        return getIdVenue();
    }
    	public int getIdLocation(){
		return this.idLocation;
	}
	
	public void setIdLocation(int idLocation){
		this.idLocation = idLocation;
	}
	
    	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
    	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
        
    public void setData(Object[] data) {
                setIdVenue((Integer) data[0]);
                setIdLocation((Integer) data[1]);
                setName((String) data[2]);
                setUrl((String) data[3]);
            }
    
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Venue.FOURSQTL_VENUE_ID_VENUE, String.valueOf(getIdVenue()));
                intent.putExtra(Venue.FOURSQTL_VENUE_ID_LOCATION, String.valueOf(getIdLocation()));
                intent.putExtra(Venue.FOURSQTL_VENUE_NAME, String.valueOf(getName()));
                intent.putExtra(Venue.FOURSQTL_VENUE_URL, String.valueOf(getUrl()));
                return intent;
    }
    
}
