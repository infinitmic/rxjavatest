package com.pr.rxj.observables.combine_observable.merge;

import io.reactivex.Observable;

public class CombineObservableByMergeWith {
    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        source1.mergeWith(source2)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
