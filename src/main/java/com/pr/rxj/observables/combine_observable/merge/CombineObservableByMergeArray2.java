package com.pr.rxj.observables.combine_observable.merge;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class CombineObservableByMergeArray2 {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta" );
        Observable<String> source2 = Observable.just("Gamma", "Delta");
        Observable<String> source3 = Observable.just("Epsilon", "Zeta");
        Observable<String> source4 = Observable.just("Eta", "Theta");

        List<Observable<String>> sources = Arrays.asList(source1, source2, source3, source4);

        Observable.merge(sources)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
