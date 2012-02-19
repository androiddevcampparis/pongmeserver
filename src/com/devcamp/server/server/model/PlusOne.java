package com.devcamp.server.server.model;

import java.io.Serializable;

import javax.persistence.Id;


/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/19/12
 * Time: 5:28 AM
 * To change this template use File | Settings | File Templates.
 */

public class PlusOne implements Serializable {
	@Id
    public long id;
	public long poId;
    public String md5;
    public boolean bool;

    public PlusOne(){

    }

    public PlusOne(long poId, String md5, boolean bool) {
        this.poId = poId;
        this.md5 = md5;
        this.bool = bool;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public long getPoId() {
		return poId;
	}

	public void setPoId(long poId) {
		this.poId = poId;
	}

	public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public boolean getBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
