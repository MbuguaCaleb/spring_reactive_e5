package com.codewithcaleb.spring_reactive_e5.controllers;

import com.codewithcaleb.spring_reactive_e5.publishers.DemoPublisher;
import com.codewithcaleb.spring_reactive_e5.subscribers.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
        //DemoPublisher f1 = new DemoPublisher(List.of(1,2,3,4));


        //subscriber requests for values
        //the subscriber can decide how many values to request from the publisher
        //Something we do not have in the Streams API

     //   f1.subscribe(new DemoSubscriber()); //custom subscriber


        //Providing Values to a Publisher in a Programmatic Way



        //Creating Flux Values Programmatically

        //Flux.just() and Flux.from() creates these values statically

        //How do i create the Values Dynamically

        //A consumer is just a piece of programming Logic

        //creating a Flux from Non-Static Values
        Flux<String> f1 = Flux.create(s->{
            //sink
            for(int i=0; i<10; i++){
                s.next(UUID.randomUUID().toString());
            }
            s.complete();

           // s.error();
        });


        f1.subscribe(c-> System.out.println(c));
        f1.subscribe(c-> System.out.println(c));
        f1.subscribe(c-> System.out.println(c));

        Stream<Integer> l = Stream.of(1,2,3,4,5);
        l.forEach(s-> System.out.println(s));
        l.forEach(s-> System.out.println(s)); //throws exception

        //When i do not apply backpressure,where my subscriber does not let the publisher
        //know how may event it wants, we get into a scenario called request unbounded,

        //My subscriber is given all the events

        //Through the log method, i am able to observe that.
//        f1.log().subscribe(c-> System.out.println(c));


        f1.log().subscribe(new Subscriber<String>() {

            private Subscription subscription;
            private int i;

            @Override
            public void onSubscribe(Subscription subscription) {

                this.subscription = subscription;
                subscription.request(2);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);

                i++;
                if(i % 2 == 0 ){
                    subscription.request(2);
                }

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

}
