package com.github.juansimp.foursqtl.model.bean;

import android.content.Intent;

import com.github.juansimp.foursqtl.model.Bean;

public class Checkin implements Bean {
    final public static String FOURSQTL_CHECKIN_ID_CHECKIN = "com.github.juansimp.foursqtl.model.bean.checkin.ID_CHECKIN";
    final public static String FOURSQTL_CHECKIN_ID_USER = "com.github.juansimp.foursqtl.model.bean.checkin.ID_USER";
    final public static String FOURSQTL_CHECKIN_ID_VENUE = "com.github.juansimp.foursqtl.model.bean.checkin.ID_VENUE";
    final public static String FOURSQTL_CHECKIN_CREATED_AT = "com.github.juansimp.foursqtl.model.bean.checkin.CREATED_AT";
    final public static String FOURSQTL_CHECKIN_SHOUT = "com.github.juansimp.foursqtl.model.bean.checkin.SHOUT";
    final public static String FOURSQTL_CHECKIN_IS_MAYOR = "com.github.juansimp.foursqtl.model.bean.checkin.IS_MAYOR";
    final public static String FOURSQTL_CHECKIN_TIME_ZONE = "com.github.juansimp.foursqtl.model.bean.checkin.TIME_ZONE";

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
	
        @Override
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
	
        
    @Override
    public void setData(Object[] data) {
                setIdCheckin((Integer) data[0]);
                setIdUser((Integer) data[1]);
                setIdVenue((Integer) data[2]);
                setCreatedAt((Integer) data[3]);
                setShout((String) data[4]);
                setIsMayor((Integer) data[5]);
                setTimeZone((String) data[6]);
            }
    
    @Override
    public Intent toIntent() {
        Intent intent = new Intent();
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_ID_CHECKIN, String.valueOf(getIdCheckin()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_ID_USER, String.valueOf(getIdUser()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_ID_VENUE, String.valueOf(getIdVenue()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_CREATED_AT, String.valueOf(getCreatedAt()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_SHOUT, String.valueOf(getShout()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_IS_MAYOR, String.valueOf(getIsMayor()));
                intent.putExtra(Checkin.FOURSQTL_CHECKIN_TIME_ZONE, String.valueOf(getTimeZone()));
                return intent;
    }
    
}
