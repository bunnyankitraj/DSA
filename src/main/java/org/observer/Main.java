package org.observer;

import org.observer.impl.ConcreteObserver;
import org.observer.impl.ConcreteSubject;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(10);
        subject.setState(20);
    }
}
