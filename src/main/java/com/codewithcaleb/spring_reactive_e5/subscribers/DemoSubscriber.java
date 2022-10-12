package com.codewithcaleb.spring_reactive_e5.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {
        private Subscription subscription;

        @Override
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        //Values are pushed from the pUB to the Sub by calling onNext Method
        @Override
        public void onNext(Integer integer) {
            System.out.println(integer);
            subscription.request(1);

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {

        }
}
