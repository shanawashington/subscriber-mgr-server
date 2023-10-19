package com.washingtonshana.subscribermgrserver.domain.subscriber.services;

import com.washingtonshana.subscribermgrserver.domain.core.exceptions.ResourceCreationException;
import com.washingtonshana.subscribermgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.washingtonshana.subscribermgrserver.domain.subscriber.models.Subscriber;
import com.washingtonshana.subscribermgrserver.domain.subscriber.repos.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    private SubscriberRepository subscriberRepository;

    @Autowired // automatically injects instance of SubscriberService
    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public Subscriber create(Subscriber subscriber) throws ResourceCreationException {
        Optional<Subscriber> optional = subscriberRepository.findByEmail(subscriber.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Subscriber with email exists: " + subscriber.getEmail());
        subscriber = subscriberRepository.save(subscriber);
        return subscriber;
    }

    @Override
    public Subscriber getById(Long id) throws ResourceCreationException {
        Subscriber subscriber = subscriberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Subscriber with id " + id));
        return subscriber;
    }

    @Override
    public Subscriber getByEmail(String email) throws ResourceNotFoundException {
        Subscriber subscriber = subscriberRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No Subscriber with email " + email));
        return subscriber;
    }

    @Override
    public List<Subscriber> getAll() {
        return subscriberRepository.findAll();
    }

    @Override
    public Subscriber update(Long id, Subscriber subscriberDetail) throws ResourceNotFoundException {
        Subscriber subscriber = getById(id);
        subscriber.setFirstName(subscriberDetail.getFirstName());
        subscriber.setLastName(subscriberDetail.getLastName());
        subscriber.setEmail(subscriberDetail.getEmail());
        subscriber = subscriberRepository.save(subscriber);
        return subscriber;
    }

    @Override
    public void delete(Long id) {
        Subscriber employee = getById(id);
        subscriberRepository.delete(employee);

    }
}
