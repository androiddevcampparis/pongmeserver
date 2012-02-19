package com.devcamp.server.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devcamp.server.server.model.PlusOne;
import com.devcamp.server.server.model.PoiData;
import com.devcamp.server.server.model.User;
import com.devcamp.server.server.resources.ResponseData;
import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.gwt.user.client.rpc.core.java.util.Collections;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class DAO {

	//ADD bigtable support
	Objectify ofy;
	private List<PoiData> myPois; 

	static {
		ObjectifyService.register(PlusOne.class);
		ObjectifyService.register(PoiData.class);
		ObjectifyService.register(User.class);
	}

	public DAO(){
		ofy  =ObjectifyService.begin();
		myPois = getAllPois();
	}
	
	public PoiData findPoiById(long id){
		PoiData pod= null;
		for (PoiData p : myPois){
			if (id==p.getId()){
				pod = p;
				break;
			}
		}
		return pod;
	}

	public  void savePoiDatas (List<PoiData> poiDatas){
		for (PoiData poi : poiDatas){
			ofy.put(poi);
		}
	}

	

	public List<PoiData> getAllPois(){
//		String[] files = new String[]{"/MH-Ile-de-France.txt-fr_utf8_monument_opendata.paris.csv",
//				"/Arbres_remarquables_utf8_arbre_opendata.paris_new.csv",
//				"/Paris_Hotels_fusiontable_OK.csv"
//		};
//		List<PoiData> list = new ArrayList<PoiData>();
//
//		for (String file : files){
//			list.addAll(getFromFile(file));
//		}
//		return list;
		return getFromFile("/All_sauf_voies.csv");
	}

	public List<PoiData> getFromFile(String file){
		List<PoiData> list = new ArrayList<PoiData>();
		URL url = DAO.class.getResource(file);
		File csvFile = new File(url.getFile());

		BufferedReader buffer;
		try {
			buffer = new BufferedReader(new FileReader(csvFile));
			String line;

			while ((line =buffer.readLine())!=null) {

				String[] splitted = line.split("\\t");
				PoiData poiData= new PoiData();
				poiData.setId(System.currentTimeMillis());
				poiData.setTitre(splitted[0]);
				poiData.setDescription(splitted[1]);
				poiData.setAddresse(splitted[2]);
				poiData.setLatitude(Double.valueOf(splitted[3]));
				poiData.setLongitude(Double.valueOf(splitted[4]));
				poiData.setCategory(splitted[5]);
				poiData.setLoc();
				list.add(poiData);

			}

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return list;

	}


	public List<ResponseData> findData(PoiData poiData, double radius){

		//extract all stuff in the range from MongoDB
		List<ResponseData> responses = new ArrayList<ResponseData>();
		for (PoiData poi : getAllPois()){
			double distance = gpsDistance(poiData, poi);
			if (( distance<= radius)){
				ResponseData resp=new ResponseData(poi);
				resp.setDistance(distance);
				responses.add(resp);
			}
		}

		//java.util.Collections.sort(responses);

		return responses;

	}

	/**
	 *  COmputes the distance betweeen two point
	 * @param source
	 * @param dest
	 * @return
	 */
	public double gpsDistance(PoiData source, PoiData dest){

		double destLat = dest.getLatitude();
		double destLong = dest.getLongitude();
		double sourceLat = source.getLatitude();
		double sourceLong = source.getLongitude();

		double d = 6378 * (Math.PI/2 - Math.asin( Math.sin(destLat) * Math.sin(sourceLat) 
				+ Math.cos(destLong - sourceLong) * Math.cos(destLat) * Math.cos(sourceLat)));

		return d;
	}


	public static void main(String[] args){
			  DAO dao = new DAO();
				 List<PoiData> list = dao.getAllPois();
			        for (PoiData data : list){
			            System.out.println(data);
			        }
				
		}


}
