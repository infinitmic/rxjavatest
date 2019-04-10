package com.pr.rxj.observables.combine_observable.flatmap;

import io.reactivex.Observable;

public class CombineObservableByFlatMap {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");

        source.flatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
