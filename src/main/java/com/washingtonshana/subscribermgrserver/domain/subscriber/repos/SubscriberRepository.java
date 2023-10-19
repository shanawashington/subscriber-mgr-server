package com.washingtonshana.subscribermgrserver.domain.subscriber.repos;

import com.washingtonshana.subscribermgrserver.domain.subscriber.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

        Optional<Subscriber> findByEmail(String email);
    }

