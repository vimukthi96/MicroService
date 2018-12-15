package org.example.userr.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.userr.api.UserService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class UserModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {

    bindService(UserService.class, UserImpl.class);

  }
}
