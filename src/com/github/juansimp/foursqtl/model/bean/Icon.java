package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class Icon implements Bean {
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
	
        public void setData(Object[] data) {
                setIdIcon((Integer) data[0]);
                setPrefix((String) data[1]);
                setName((String) data[2]);
            }
}
