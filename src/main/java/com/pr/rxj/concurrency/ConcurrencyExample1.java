package com.pr.rxj.concurrency;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ConcurrencyExample1 {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + " Mississipi")
                .subscribe(System.out::println);
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
