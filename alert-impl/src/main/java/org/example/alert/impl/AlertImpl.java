package org.example.alert.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.alert.api.Alert;
import org.example.alert.api.AlertService;

import java.util.concurrent.CompletableFuture;

public class AlertImpl implements AlertService {

    private final AlertRepository alertRepository;

    @Inject
    public AlertImpl(AlertRepository alertRepository) {

        this.alertRepository = alertRepository;
    }

    @Override
    public ServiceCall<NotUsed, Alert> getSensorId(String id){
        //System.out.println("get product by id method is called with id "+ id);

      //  ProductRepository productRepository=new InMemoryProductRepository();
        return request -> CompletableFuture.completedFuture(alertRepository.getSensorData(id));
    }

    @Override
    public ServiceCall<Alert, Done> addSensorData() {
        return request -> {
            //save the prodct in database
           // System.out.println(request.getId());
            alertRepository.save(request);
            return CompletableFuture.completedFuture(Done.getInstance());
        };

    }
}
