package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class IconSize implements Bean {
    final public static String FOURSQTL_ICONSIZE_ID_ICON_SIZE = "com.github.juansimp.foursqtl.model.bean.iconSize.ID_ICON_SIZE";
    final public static String FOURSQTL_ICONSIZE_ID_ICON = "com.github.juansimp.foursqtl.model.bean.iconSize.ID_ICON";
    final public static String FOURSQTL_ICONSIZE_SIZE = "com.github.juansimp.foursqtl.model.bean.iconSize.SIZE";

    private int idIconSize;
    private int idIcon;
    private String size;

    public IconSize() {
        idIconSize = 0;
        idIcon = 0;
        size = "";
    }


	public int getIdIconSize(){
		return this.idIconSize;
	}
	
	public void setIdIconSize(int idIconSize){
		this.idIconSize = idIconSize;
	}
	
        @Override
    public long getId() {
        return getIdIconSize();
    }
    	public int getIdIcon(){
		return this.idIcon;
	}
	
	public void setIdIcon(int idIcon){
		this.idIcon = idIcon;
	}
	
    	public String getSize(){
		return this.size;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
        
    @Override
    public void setData(Object[] data) {
                setIdIconSize((Integer) data[0]);
                setIdIcon((Integer) data[1]);
                setSize((String) data[2]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(IconSize.FOURSQTL_ICONSIZE_ID_ICON_SIZE, String.valueOf(getIdIconSize()));
                intent.putExtra(IconSize.FOURSQTL_ICONSIZE_ID_ICON, String.valueOf(getIdIcon()));
                intent.putExtra(IconSize.FOURSQTL_ICONSIZE_SIZE, String.valueOf(getSize()));
                return intent;
    }
    
}
