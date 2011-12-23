package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Category implements Bean {
    final public static String FOURSQTL_CATEGORY_ID_CATEGORY = "com.github.juansimp.foursqtl.model.bean.category.ID_CATEGORY";
    final public static String FOURSQTL_CATEGORY_ID_ICON = "com.github.juansimp.foursqtl.model.bean.category.ID_ICON";
    final public static String FOURSQTL_CATEGORY_NAME = "com.github.juansimp.foursqtl.model.bean.category.NAME";
    final public static String FOURSQTL_CATEGORY_PLURAL_NAME = "com.github.juansimp.foursqtl.model.bean.category.PLURAL_NAME";
    final public static String FOURSQTL_CATEGORY_SHORT_NAME = "com.github.juansimp.foursqtl.model.bean.category.SHORT_NAME";

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
	
        @Override
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
	
        
    @Override
    public void setData(Object[] data) {
                setIdCategory((Integer) data[0]);
                setIdIcon((Integer) data[1]);
                setName((String) data[2]);
                setPluralName((String) data[3]);
                setShortName((String) data[4]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Category.FOURSQTL_CATEGORY_ID_CATEGORY, String.valueOf(getIdCategory()));
                intent.putExtra(Category.FOURSQTL_CATEGORY_ID_ICON, String.valueOf(getIdIcon()));
                intent.putExtra(Category.FOURSQTL_CATEGORY_NAME, String.valueOf(getName()));
                intent.putExtra(Category.FOURSQTL_CATEGORY_PLURAL_NAME, String.valueOf(getPluralName()));
                intent.putExtra(Category.FOURSQTL_CATEGORY_SHORT_NAME, String.valueOf(getShortName()));
                return intent;
    }
    
}
