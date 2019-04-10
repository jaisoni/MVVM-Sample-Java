package dev.jai.weather.ui;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class EventBus {
    private PublishSubject<Object> bus = PublishSubject.create();

    @Inject
    public EventBus() {

    }

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> tObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
