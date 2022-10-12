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