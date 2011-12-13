package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class Authentication implements Bean {
    private int idUser;
    private String token;

    public Authentication() {
        idUser = 0;
        token = "";
    }


	public int getIdUser(){
		return this.idUser;
	}
	
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
	
        public long getId() {
        return getIdUser();
    }
    	public String getToken(){
		return this.token;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	
        public void setData(Object[] data) {
                setIdUser((Integer) data[0]);
                setToken((String) data[1]);
            }
}
