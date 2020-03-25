package com.example.webflux;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import javax.xml.bind.TypeConstraintException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@RestController
@Slf4j
@RequestMapping("api")
public class TestSameController {

    Logger logger = LoggerFactory.getLogger(TestSameController.class);

    @GetMapping("mono")
    public Mono demo() {



        return Mono.create(a -> {
            logger.info("创建mono");
            a.success("hello webFlux");
        }).doOnSubscribe(subscription -> {
            logger.info("{}", subscription);
        }).doOnNext(b -> {
            logger.info("{}", b);
        });
    }

    @GetMapping("flux")
    public Flux flux() {
        Random random = new Random();

        Flux<Object> generate = Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        });
        return Flux.generate(a -> {
            a.next("the date had fixed");
            a.complete();
        });


    }
}
