package com.pr.rxj.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class MutlicastingWithOperatorsAutoConnect {
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                .publish()
                .autoConnect(2);

        threeRandoms.subscribe(s -> System.out.println("Observer 1: " + s));
        threeRandoms.reduce(0, (total, next) -> total + next).subscribe(s -> System.out.println("Observer 2: " + s));

    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }
}
