package com.devcamp.server.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;


public class PoiData implements Serializable{
    
	@Id
    private long id;
	private String titre;
	private String addresse;
	private String description;
	private double longitude;
	private double latitude;
	private String category;
    private double[] loc;
    private int sumDesPlus;

    private List<PlusOne> plusOneList;
    
    @Transient
    private double distance;

        
	
	public PoiData(  double longitude,
			double latitude) {
				
		this.longitude = longitude;
		this.latitude = latitude;
		
		plusOneList = new ArrayList<PlusOne>();
	}


	
	public PoiData(){
        plusOneList = new ArrayList<PlusOne>();
		
	}


    public int getSumDesPlus() {
    	this.sumDesPlus = this.plusOneList.size();
        return this.plusOneList.size();
    }

    public void setSumDesPlus(int sums) {
        this.sumDesPlus = sums;
    }

    public List<PlusOne> getPlusOneList() {
        return plusOneList;
    }

    public void setPlusOneList(List<PlusOne> plusOneList) {
        this.plusOneList = plusOneList;
    }

    public double[] getLoc() {
        return loc;
    }

    public void setLoc(double[] loc) {
        this.loc = loc;
    }

    public void setLoc(){
        loc= new double[]{this.latitude, this.longitude};
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    @Override
    public String toString() {
        return "PoiData{" +
                "titre='" + titre + '\'' +
                ", addresse='" + addresse + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", category='" + category + '\'' +
                '}';
    }



	public void updateSum(boolean bool) {
		// TODO Auto-generated method stub
		if (bool ){
			this.sumDesPlus ++;
		} else{
			
		}
		
		
	}


	
}
