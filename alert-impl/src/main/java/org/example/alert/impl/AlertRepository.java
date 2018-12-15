package org.example.alert.impl;

import com.google.inject.ImplementedBy;
import org.example.alert.api.Alert;

@ImplementedBy(InMemoryAlertRepository.class)
public interface AlertRepository {
    Alert getSensorData(String id);

    void save(Alert request);
}
