package com.pr.rxj.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class MutlicastingWithOperatorsConnectable3 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt()).publish();

        threeRandoms.subscribe(s -> System.out.println("Observer 1: " + s));
        threeRandoms.reduce(0, (total, next) -> total + next).subscribe(s -> System.out.println("Observer 2: " + s));

        threeRandoms.connect();

    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }
}
