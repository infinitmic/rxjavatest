package com.pr.rxj.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class MutlicastingExample {
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeIntegers = Observable.range(1, 3)
                .publish();

        threeIntegers.subscribe(s -> System.out.println("Observer 1: " + s));
        threeIntegers.subscribe(s -> System.out.println("Observer 2: " + s));

        threeIntegers.connect();
    }
}
