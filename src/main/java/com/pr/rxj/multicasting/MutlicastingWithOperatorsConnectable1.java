package com.pr.rxj.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class MutlicastingWithOperatorsConnectable1 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeIntegers = Observable.range(1, 3)
                .publish();

        Observable<Integer> threeRandoms = threeIntegers.map(i -> randomInt());

        threeRandoms.subscribe(s -> System.out.println("Observer 1: " + s));
        threeRandoms.subscribe(s -> System.out.println("Observer 2: " + s));

        threeIntegers.connect();

    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }
}
