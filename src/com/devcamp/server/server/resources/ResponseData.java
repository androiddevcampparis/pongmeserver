package com.devcamp.server.server.resources;

import java.io.Serializable;

import com.devcamp.server.server.model.PoiData;


public class ResponseData implements Serializable, Comparable<ResponseData> {

	private long id;
	private String title;
	private String description;
	private String addresse;
	private String category;
	private double latitude;
	private double longitude;

	private String url_image;
	private String wiki_link;
	
	private double distance=0;
	

	public ResponseData (){

	}

	public ResponseData(PoiData poiData){
		this.id=poiData.getId();
		this.title=poiData.getTitre();
		this.description=poiData.getDescription();
		this.addresse=poiData.getDescription();
		this.category=poiData.getCategory();
		this.latitude=poiData.getLatitude();
		this.longitude=poiData.getLongitude();

	}
	
	public PoiData getPoiData(){
		return new PoiData(latitude,longitude);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getWiki_link() {
		return wiki_link;
	}

	public void setWiki_link(String wiki_link) {
		this.wiki_link = wiki_link;
	}
	

    public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
    public String toString() {
        return "ResponseData{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", addresse='" + addresse + '\'' +
                ", category='" + category + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", url_image='" + url_image + '\'' +
                ", wiki_link='" + wiki_link + '\'' +
                '}';
    }

	@Override
	public int compareTo(ResponseData o) {
		// TODO Auto-generated method stub
		
		return Integer.valueOf(Double.toString((this.getDistance() - o.getDistance())));
		};
	}

