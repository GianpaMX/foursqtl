package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class VenueCategory implements Bean {
    final public static String FOURSQTL_VENUECATEGORY_ID_VENUE = "com.github.juansimp.foursqtl.model.bean.venueCategory.ID_VENUE";
    final public static String FOURSQTL_VENUECATEGORY_ID_CATEGORY = "com.github.juansimp.foursqtl.model.bean.venueCategory.ID_CATEGORY";
    final public static String FOURSQTL_VENUECATEGORY_PRIMARY = "com.github.juansimp.foursqtl.model.bean.venueCategory.PRIMARY";

    private int idVenue;
    private int idCategory;
    private int primary;

    public VenueCategory() {
        idVenue = 0;
        idCategory = 0;
        primary = 0;
    }


	public int getIdVenue(){
		return this.idVenue;
	}
	
	public void setIdVenue(int idVenue){
		this.idVenue = idVenue;
	}
	
        @Override
    public long getId() {
        return getIdVenue();
    }
    	public int getIdCategory(){
		return this.idCategory;
	}
	
	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}
	
    	public int getPrimary(){
		return this.primary;
	}
	
	public void setPrimary(int primary){
		this.primary = primary;
	}
	
        
    @Override
    public void setData(Object[] data) {
                setIdVenue((Integer) data[0]);
                setIdCategory((Integer) data[1]);
                setPrimary((Integer) data[2]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(VenueCategory.FOURSQTL_VENUECATEGORY_ID_VENUE, String.valueOf(getIdVenue()));
                intent.putExtra(VenueCategory.FOURSQTL_VENUECATEGORY_ID_CATEGORY, String.valueOf(getIdCategory()));
                intent.putExtra(VenueCategory.FOURSQTL_VENUECATEGORY_PRIMARY, String.valueOf(getPrimary()));
                return intent;
    }
    
}
