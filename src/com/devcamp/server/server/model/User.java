package com.devcamp.server.server.model;

import java.io.Serializable;

import javax.persistence.Id;


public class User implements Serializable {

    @Id
	private long id;
	private String uid;
	private String name;
	
	public User(){
		
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
