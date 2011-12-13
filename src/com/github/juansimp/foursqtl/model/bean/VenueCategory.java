package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class VenueCategory implements Bean {
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
	
        public void setData(Object[] data) {
                setIdVenue((Integer) data[0]);
                setIdCategory((Integer) data[1]);
                setPrimary((Integer) data[2]);
            }
}
