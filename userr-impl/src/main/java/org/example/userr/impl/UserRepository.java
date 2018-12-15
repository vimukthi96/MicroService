package org.example.userr.impl;

import com.google.inject.ImplementedBy;
import org.example.userr.api.User;

@ImplementedBy(InMemoryUserRepository.class)
public interface UserRepository {
    User getUser(String id);
    void save(User request);
}
