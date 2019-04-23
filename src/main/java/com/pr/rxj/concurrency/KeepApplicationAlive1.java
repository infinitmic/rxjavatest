package com.pr.rxj.concurrency;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class KeepApplicationAlive1 {
    public static void main(String[] args) {

        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + intenseCalculation(i))
                .subscribe(System.out::println);
        sleep(Long.MAX_VALUE);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
