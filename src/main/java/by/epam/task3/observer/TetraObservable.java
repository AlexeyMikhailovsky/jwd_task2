package by.epam.task3.observer;

import by.epam.task3.observer.impl.TetraObserverImpl;

public interface TetraObservable {

    void attach(TetraObserver observer);

    void detach(TetraObserver observer);

    void notifyObserver();

}
