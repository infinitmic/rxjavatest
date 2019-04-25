package com.pr.rxj.multicasting;

import io.reactivex.Observable;

public class MutlicastingWithCaching {
    public static void main(String[] args) {
        Observable<Integer> cachedRollingTotals =
                Observable.just(6,2,5,71,1,4,9,8,3)
                .scan(0, (total, next) -> total + next)
                .cache();

        cachedRollingTotals.subscribe(System.out::println);
    }
}
