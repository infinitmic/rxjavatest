package com.pr.rxj.observables.combine_observable.combinelatest;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineObservableByCombineLatest {

    public static void main(String[] args) {

        // Emit every second
        Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS);

        // Emit every 300 milliseconds
        Observable<Long> source2 = Observable.interval(300, TimeUnit.MILLISECONDS);

        // Merge and subscribe
        Observable.combineLatest(source1, source2, (l1, l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);

        // Keep alive for 3 seconds
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
