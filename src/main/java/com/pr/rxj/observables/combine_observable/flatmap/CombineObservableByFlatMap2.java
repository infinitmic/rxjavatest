package com.pr.rxj.observables.combine_observable.flatmap;

import io.reactivex.Observable;

public class CombineObservableByFlatMap2 {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("52334/3244/FOXTROT", "2123/234444/TANGO");

        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));

    }
}
