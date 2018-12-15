package org.example.userr.impl;

import org.example.userr.api.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    Map<String,User> productMap=new HashMap<>();
    public InMemoryUserRepository(){

        User product1=new User();
        product1.setName("Nokia mobile phone");
        product1.setId("111");
       // product1.setUniprice("10000");

        User product2=new User();
        product2.setName("Water  bottle");
        product2.setId("222");
     //   product2.setUniprice("100");

        productMap.put("111",product1);
        productMap.put("222",product2);
    }


    @Override
    public User getUser(String id) {
        if(productMap.containsKey(id)){
            return productMap.get(id);
        }
        return null;
    }

    @Override
    public void save(User request) {
        productMap.put(request.getId(),request);

    }
}
