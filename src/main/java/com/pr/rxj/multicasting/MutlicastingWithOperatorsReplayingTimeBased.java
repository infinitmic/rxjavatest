package com.pr.rxj.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class MutlicastingWithOperatorsReplayingTimeBased {
    public static void main(String[] args) {
        Observable<Long> seconds = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1)*300)
                .replay(1, TimeUnit.SECONDS)
                .autoConnect();

        //Observable1
        seconds.subscribe(s -> System.out.println("Observer 1: " + s));

        sleep(2000);


        //Observer2
        seconds.subscribe(s -> System.out.println("Observer 2: " + s));

        sleep(1000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
