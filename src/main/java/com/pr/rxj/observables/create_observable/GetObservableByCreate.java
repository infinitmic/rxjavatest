package com.pr.rxj.observables.create_observable;


import io.reactivex.Observable;

public class GetObservableByCreate {

    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onNext("Delta");
                emitter.onNext("Epsilon");
                emitter.onComplete();
            }catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.subscribe(s -> System.out.println(s), Throwable::printStackTrace);
    }
}
