package com.codewithcaleb.spring_reactive_e5.controllers;

import com.codewithcaleb.spring_reactive_e5.publishers.DemoPublisher;
import com.codewithcaleb.spring_reactive_e5.subscribers.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    //Stream API Vs Reactor
    @GetMapping()
    public void demo(){

        //Stream API vs Reactor
        // Flux<Integer> f1 = Flux.just(1,2,3,4,5,6); //publisher
        // f1.subscribe(c-> System.out.println(c)); //consumer
//
//        Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
//        s1.forEach(c-> System.out.println(c)); -Subscriber Pulls Values from the Publisher


       // Flux<Integer> f1 = Flux.just(1,2,3,4,5,6,7);
        DemoPublisher f1 = new DemoPublisher(List.of(1,2,3,4));


        //subscriber requests for values
        //the subscriber can decide how many values to request from the publisher
        //Something we do not have in the Streams API

        f1.subscribe(new DemoSubscriber());


    }

}
