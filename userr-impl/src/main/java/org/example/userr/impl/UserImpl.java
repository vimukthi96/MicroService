package org.example.userr.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.userr.api.User;
import org.example.userr.api.UserService;

import java.util.concurrent.CompletableFuture;

public class UserImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public ServiceCall<NotUsed, User> getUserId(String id){
        //System.out.println("get product by id method is called with id "+ id);

      //  ProductRepository productRepository=new InMemoryProductRepository();
        return request -> CompletableFuture.completedFuture(userRepository.getUser(id));
    }

    @Override
    public ServiceCall<User, Done> addUser() {
        return request -> {
            //save the prodct in database
           // System.out.println(request.getId());
            userRepository.save(request);
            return CompletableFuture.completedFuture(Done.getInstance());
        };

    }
}
