package com.pr.rxj.multicasting.subjects;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class PublishSubjectExampleGoneWrong {
    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();


        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        // Won't receive emissions, as it is hot
        subject.map(String::length)
                .subscribe(System.out::println);
    }
}
