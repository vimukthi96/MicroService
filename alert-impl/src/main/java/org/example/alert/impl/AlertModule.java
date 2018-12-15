package org.example.alert.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.alert.api.AlertService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class AlertModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {

    bindService(AlertService.class, AlertImpl.class);

  }
}
