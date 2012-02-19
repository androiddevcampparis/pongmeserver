package com.devcamp.server.server.resources;

import com.devcamp.server.server.model.PlusOne;
import com.devcamp.server.server.model.PoiData;
import com.devcamp.server.service.DAO;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;



/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/19/12
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */

@Path("/")
public class ResponseResource {

    private DAO dao;

    public ResponseResource(){
    	dao = new DAO();
    	
    }

    @GET
    @Path("/poi/{requestUrl}")
    @Produces("application/json")
    public ResponseConverter getClosestPOI(@PathParam("requestUrl")String req){

        //Parse requestUrl
        String[] reqs = req.split("\\+");
        Double radius = Double.valueOf(reqs[2]);
        //String category = reqs[3];
        PoiData poiData = new PoiData();
        poiData.setLatitude(Double.valueOf(reqs[0]));
        poiData.setLongitude(Double.valueOf(reqs[1]));

        //find the closest neighbors
        List<ResponseData> responses= dao.findData(poiData, radius);
        ResponseConverter rc = new ResponseConverter();
        rc.setPoiDatas(responses);

        return rc;

    }

    @GET
    @Path("/like/{reqUrl}")
    @Produces("application/plain-text")
    public Response likePoi(@PathParam("reqUrl") String req ){
    	//Parse req
    	String[] reqs = req.split("\\+");
    	PlusOne plus = new PlusOne(Long.valueOf(reqs[0]),reqs[1],Boolean.valueOf(reqs[2]));
    	PoiData poidata = dao.findPoiById(plus.getPoId());
    	poidata.updateSum(plus.getBool());
    	
    	
    	return Response.ok().build();
    }

}
