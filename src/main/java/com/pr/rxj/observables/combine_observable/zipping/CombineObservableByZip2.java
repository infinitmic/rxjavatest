package com.pr.rxj.observables.combine_observable.zipping;

import io.reactivex.Observable;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class CombineObservableByZip2 {

    public static void main(String[] args) {
        Observable<String> strings = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(strings, seconds, (s, i) -> s + "-" + i)
                .subscribe(s -> System.out.println("RECEVEID ->" + s + " at " + LocalTime.now()));
        // Keep alive for 3 seconds
        sleep(6000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
