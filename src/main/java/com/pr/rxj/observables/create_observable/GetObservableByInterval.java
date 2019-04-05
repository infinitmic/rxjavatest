package com.pr.rxj.observables.create_observable;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class GetObservableByInterval {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " value"));

        sleep(5000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
