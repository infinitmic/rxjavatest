package com.pr.rxj.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class MutlicastingWithOperatorsAutoConnect3 {
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                .publish()
                .autoConnect(2);

        //Observer1
        threeRandoms.subscribe(s -> System.out.println("Observer 1: " + s));
        threeRandoms.reduce(0, (total, next) -> total + next).subscribe(s -> System.out.println("Observer 2: " + s));
        // won't receive the emissions
        threeRandoms.subscribe(s -> System.out.println("Observer 3: " + s));

    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }
}
