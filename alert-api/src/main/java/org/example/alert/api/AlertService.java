package org.example.alert.api;


import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

public interface AlertService extends Service {


    public ServiceCall<NotUsed, Alert> getSensorId(String id);
    ServiceCall<Alert, Done> addSensorData();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("alert").withCalls(
                pathCall("/api/alert/:id",  this::getSensorId),
                pathCall("/api/alert", this::addSensorData)
        ).withAutoAcl(true);
        // @formatter:on
    }

}
