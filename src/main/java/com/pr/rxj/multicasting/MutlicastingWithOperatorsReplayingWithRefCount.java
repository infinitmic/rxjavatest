package com.pr.rxj.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class MutlicastingWithOperatorsReplayingWithRefCount {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .replay(1)
                .refCount();


        //Observable1
        source.subscribe(s -> System.out.println("Observer 1: " + s));

        sleep(3000);


        //Observer2
        source.subscribe(s -> System.out.println("Observer 2: " + s));

        sleep(3000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
