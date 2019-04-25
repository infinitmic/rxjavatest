package com.pr.rxj.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class MutlicastingWithOperators {
    public static void main(String[] args) {
        Observable<Integer> threeIntegers = Observable.range(1, 3)
                .map(i -> randomInt());

        threeIntegers.subscribe(s -> System.out.println("Observer 1: " + s));
        threeIntegers.subscribe(s -> System.out.println("Observer 2: " + s));

    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }
}
