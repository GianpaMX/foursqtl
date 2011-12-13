package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class Category implements Bean {
    private int idCategory;
    private int idIcon;
    private String name;
    private String pluralName;
    private String shortName;

    public Category() {
        idCategory = 0;
        idIcon = 0;
        name = "";
        pluralName = "";
        shortName = "";
    }


	public int getIdCategory(){
		return this.idCategory;
	}
	
	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}
	
        public long getId() {
        return getIdCategory();
    }
    	public int getIdIcon(){
		return this.idIcon;
	}
	
	public void setIdIcon(int idIcon){
		this.idIcon = idIcon;
	}
	
    	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
    	public String getPluralName(){
		return this.pluralName;
	}
	
	public void setPluralName(String pluralName){
		this.pluralName = pluralName;
	}
	
    	public String getShortName(){
		return this.shortName;
	}
	
	public void setShortName(String shortName){
		this.shortName = shortName;
	}
	
        public void setData(Object[] data) {
                setIdCategory((Integer) data[0]);
                setIdIcon((Integer) data[1]);
                setName((String) data[2]);
                setPluralName((String) data[3]);
                setShortName((String) data[4]);
            }
}
