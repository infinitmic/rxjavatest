package com.pr.rxj.multicasting;

import io.reactivex.Observable;

public class MutlicastingNotAvailable{
    public static void main(String[] args) {
        Observable<Integer> threeIntegers = Observable.range(1, 3);

        threeIntegers.subscribe(s -> System.out.println("Observer 1: " + s));
        threeIntegers.subscribe(s -> System.out.println("Observer 2: " + s));
    }
}
