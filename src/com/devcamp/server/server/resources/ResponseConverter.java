package com.devcamp.server.server.resources;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/19/12
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class ResponseConverter {

    private List<ResponseData> poiDatas ;

    public ResponseConverter(){

    }

    public List<ResponseData> getPoiDatas() {
        return poiDatas;
    }

    public void setPoiDatas(List<ResponseData> poiDatas) {
        this.poiDatas = poiDatas;
    }
}
