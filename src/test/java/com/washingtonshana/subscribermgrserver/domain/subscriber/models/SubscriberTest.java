package com.washingtonshana.subscribermgrserver.domain.subscriber.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubscriberTest {

        @Test
        public void constructorTest01(){
            Subscriber subscriber = new Subscriber ("New", "User", "new@user.com");
            subscriber.setId(1L);

            String expected = "1 New User new@user.com";
            String actual = subscriber.toString();

            Assertions.assertEquals(expected, actual);


        }
    }
