package com.washingtonshana.subscribermgrserver.domain.subscriber.services;

import com.washingtonshana.subscribermgrserver.domain.core.exceptions.ResourceCreationException;
import com.washingtonshana.subscribermgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.washingtonshana.subscribermgrserver.domain.subscriber.models.Subscriber;

import java.util.List;
public interface SubscriberService {
    Subscriber create(Subscriber subscriber) throws ResourceCreationException;
    Subscriber getById(Long id) throws ResourceCreationException;
    Subscriber getByEmail(String email) throws ResourceNotFoundException;
    List<Subscriber> getAll();
    Subscriber update(Long id, Subscriber subscriberDetail) throws ResourceNotFoundException;
    void delete (Long id);

}
