package org.example.alert.impl;

import org.example.alert.api.Alert;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAlertRepository implements AlertRepository {

    Map<String, Alert> productMap=new HashMap<>();
    public InMemoryAlertRepository(){

        Alert product1=new Alert();
        product1.setSensorId("nokia");
        product1.setSensorValue("111");
        product1.setDateAndTime("10/2000");

        Alert product2=new Alert();
        product2.setSensorId("laptop");
        product2.setSensorValue("121");
        product2.setDateAndTime("10/2010");

        productMap.put("nokia",product1);
        productMap.put("laptop",product2);
    }


    @Override
    public Alert getSensorData(String id) {
        if(productMap.containsKey(id)){
            return productMap.get(id);
        }
        return null;
    }

    @Override
    public void save(Alert request) {
        productMap.put(request.getSensorId(),request);

    }
}
