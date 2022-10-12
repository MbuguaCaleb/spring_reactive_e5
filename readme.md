**Notes**

```yaml

f1.subscribe(c-> System.out.println(c)); //consumer

//simplest implementation of a subscriber
//Its taking in a consumer
//consumer is just a subscriber behind scenes

```

**Differences Between Steaam API and Reactor**

```yaml

1.It is always first the Subscriber Requesting Values.

If the subscriber does not request for values it does not
get anything.



2.There is no backpressure from the Streams API.

reactor embraces back pressure

Backpressure ensures that the subsriber only gets the amount
of events they can process

subsribers in the reactive stack are more smart.

REACTOR Stack is much more intelligent...

Steam API is also a pipeline approach of processing events,but the 
reactor is much more smarter.

Stream api does not have a way of the subscriber having back pressure


In stream APi the publisher provides the requested events,



```

**N/B**
```yaml

Values are pushed from the pUB to the Sub by calling onNext Method

```

**Creating a Custom Publisher**

```yaml


The Subscriber has natively one method which is subscribe()


```

**Java Consumer**

```yaml


Java Consumer is a functional interface which represents 
an operation that accepts a single input argument and returns no result. 

```

**Creating a Flux Dynamically/Programmatically**

```yaml

To create a Flux dynamically i use the create method,

from and just create the values statically but create
solves this problem by taking in a consumer.


   Flux<String> f1 = Flux.create(s->{
            //sink
            for(int i=0; i<10; i++){
                s.next(UUID.randomUUID().toString());
            }
            s.complete();
            
           // s.error();
        });

        f1.subscribe(c-> System.out.println(c));


```

**Log is an important method along the pipeline that we can call
to show the Event(s) Flow**

```yaml

 f1.log().subscribe(c-> System.out.println(c));

```
```yaml


We are as well able to transform the values that a publisher
gets along the pipeline,

Woow Amazing

This means the subscriber will receive the values in the 
format which i desire.


N/B

When building reactive applications be ware that all
parts of the application are reactive so that we do
not over engineer our applications,

This includes the front end and all the database drivers.

Make sure there is nothing at all that blocks your application


A publisher can have as many subscribers as we want

Each formatted differently

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

This is another difference that reactive programming 
has with stream.

Stream<Integer> l = Stream.of(1,2,3,4,5);
l.forEach(s-> System.out.println(s));
l.forEach(s-> System.out.println(s)); //throws exception



```

