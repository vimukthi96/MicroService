package org.example.userr.api;


import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.Service;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

public interface UserService extends Service {


    public ServiceCall<NotUsed, User> getUserId(String id);
    ServiceCall<User, Done> addUser();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("user").withCalls(
                pathCall("/api/user/:id",  this::getUserId),
                pathCall("/api/user", this::addUser)
        ).withAutoAcl(true);
        // @formatter:on
    }

}
