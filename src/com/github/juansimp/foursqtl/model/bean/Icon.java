package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Icon implements Bean {
    final public static String FOURSQTL_ICON_ID_ICON = "com.github.juansimp.foursqtl.model.bean.icon.ID_ICON";
    final public static String FOURSQTL_ICON_PREFIX = "com.github.juansimp.foursqtl.model.bean.icon.PREFIX";
    final public static String FOURSQTL_ICON_NAME = "com.github.juansimp.foursqtl.model.bean.icon.NAME";

    private int idIcon;
    private String prefix;
    private String name;

    public Icon() {
        idIcon = 0;
        prefix = "";
        name = "";
    }


	public int getIdIcon(){
		return this.idIcon;
	}
	
	public void setIdIcon(int idIcon){
		this.idIcon = idIcon;
	}
	
        @Override
    public long getId() {
        return getIdIcon();
    }
    	public String getPrefix(){
		return this.prefix;
	}
	
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	
    	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
        
    @Override
    public void setData(Object[] data) {
                setIdIcon((Integer) data[0]);
                setPrefix((String) data[1]);
                setName((String) data[2]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Icon.FOURSQTL_ICON_ID_ICON, String.valueOf(getIdIcon()));
                intent.putExtra(Icon.FOURSQTL_ICON_PREFIX, String.valueOf(getPrefix()));
                intent.putExtra(Icon.FOURSQTL_ICON_NAME, String.valueOf(getName()));
                return intent;
    }
    
}
