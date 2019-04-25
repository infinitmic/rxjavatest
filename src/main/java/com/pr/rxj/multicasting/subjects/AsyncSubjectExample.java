package com.pr.rxj.multicasting.subjects;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        Subject<String> subject = AsyncSubject.create();

        subject.subscribe(s-> System.out.println("Observer 1: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer1 done")
        );


        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        subject.subscribe(s-> System.out.println("Observer 2: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer2 done")
        );
    }
}
