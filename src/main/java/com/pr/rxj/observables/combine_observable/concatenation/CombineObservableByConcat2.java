package com.pr.rxj.observables.combine_observable.concatenation;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineObservableByConcat2 {

    public static void main(String[] args) {

        // Emit every second
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(l -> l + 1)
                .take(2)
                .map(l -> "Source1: " + l + " seconds");

        // Emit every 300 milliseconds
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1)*300)
                .map(l -> "Source2: " + l + " milliseconds");

        // Concat and subscribe
        Observable.concat(source1, source2)
                .subscribe(System.out::println);

        // Keep alive for 3 seconds
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
