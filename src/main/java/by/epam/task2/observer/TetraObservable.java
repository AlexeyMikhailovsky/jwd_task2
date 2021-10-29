package by.epam.task2.observer;

public interface TetraObservable {

    void attach(TetraObserver observer);

    void detach(TetraObserver observer);

    void notifyObserver();

}
