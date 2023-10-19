package com.washingtonshana.subscribermgrserver.domain.subscriber.controllers;

import com.washingtonshana.subscribermgrserver.domain.subscriber.models.Subscriber;
import com.washingtonshana.subscribermgrserver.domain.subscriber.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/subscribers")
@CrossOrigin ("*")
public class SubscriberController {
    private SubscriberService subscriberService;

    @Autowired // Automatically injects an instance of subscriberService
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    // Handles HTTP GET requests to retrieve all subscribers
    @GetMapping
    public ResponseEntity<List<Subscriber>> getAll() {
        List<Subscriber> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(subscribers, HttpStatus.OK); // Returns a list of subscribers as JSON with HTTP status OK (200)
    }

    // Handles HTTP POST requests to create a new subscriber
    @PostMapping
    public ResponseEntity<Subscriber> create(@RequestBody Subscriber subscriber) {
        subscriber = subscriberService.create(subscriber);
        return new ResponseEntity<>(subscriber, HttpStatus.CREATED); // Returns the created subscriber with HTTP status Created (201)
    }

    // Handles HTTP GET requests to retrieve a subscriber by their ID
    @GetMapping("{id}")
    public ResponseEntity<Subscriber> getById(@PathVariable("id") Long id) {
        Subscriber employee = subscriberService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK); // Returns the subscriber with the given ID with HTTP status OK (200)
    }

    // Handles HTTP GET requests to retrieve an subscriber by their email using a query parameter
    @GetMapping("lookup")
    public ResponseEntity<Subscriber> getByEmail(@RequestParam String email) {
        Subscriber subscriber = subscriberService.getByEmail(email);
        return new ResponseEntity<>(subscriber, HttpStatus.OK); // Returns the subscriber with the specified email with HTTP status OK (200)
    }

    // Handles HTTP PUT requests to update an subscriber by their ID
    @PutMapping("{id}")
    public ResponseEntity<Subscriber> update(@PathVariable("id") Long id, @RequestBody Subscriber subscriberDetail) {
        subscriberDetail = subscriberService.update(id, subscriberDetail);
        return new ResponseEntity<>(subscriberDetail, HttpStatus.ACCEPTED); // Returns the updated subscriber with HTTP status Accepted (202)
    }

    // Handles HTTP DELETE requests to delete a subscriber by their ID
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        subscriberService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); // Returns HTTP status No Content (204) indicating successful deletion
    }

}
