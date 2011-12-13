package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class IconSize implements Bean {
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
	
        public void setData(Object[] data) {
                setIdIconSize((Integer) data[0]);
                setIdIcon((Integer) data[1]);
                setSize((String) data[2]);
            }
}
