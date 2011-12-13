package com.github.juansimp.foursqtl.model.bean;

import com.github.juansimp.foursqtl.model.Bean;

public class Checkin implements Bean {
    private int idCheckin;
    private int idUser;
    private int idVenue;
    private int createdAt;
    private String shout;
    private int isMayor;
    private String timeZone;

    public Checkin() {
        idCheckin = 0;
        idUser = 0;
        idVenue = 0;
        createdAt = 0;
        shout = "";
        isMayor = 0;
        timeZone = "";
    }


	public int getIdCheckin(){
		return this.idCheckin;
	}
	
	public void setIdCheckin(int idCheckin){
		this.idCheckin = idCheckin;
	}
	
        public long getId() {
        return getIdCheckin();
    }
    	public int getIdUser(){
		return this.idUser;
	}
	
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
	
    	public int getIdVenue(){
		return this.idVenue;
	}
	
	public void setIdVenue(int idVenue){
		this.idVenue = idVenue;
	}
	
    	public int getCreatedAt(){
		return this.createdAt;
	}
	
	public void setCreatedAt(int createdAt){
		this.createdAt = createdAt;
	}
	
    	public String getShout(){
		return this.shout;
	}
	
	public void setShout(String shout){
		this.shout = shout;
	}
	
    	public int getIsMayor(){
		return this.isMayor;
	}
	
	public void setIsMayor(int isMayor){
		this.isMayor = isMayor;
	}
	
    	public String getTimeZone(){
		return this.timeZone;
	}
	
	public void setTimeZone(String timeZone){
		this.timeZone = timeZone;
	}
	
        public void setData(Object[] data) {
                setIdCheckin((Integer) data[0]);
                setIdUser((Integer) data[1]);
                setIdVenue((Integer) data[2]);
                setCreatedAt((Integer) data[3]);
                setShout((String) data[4]);
                setIsMayor((Integer) data[5]);
                setTimeZone((String) data[6]);
            }
}
