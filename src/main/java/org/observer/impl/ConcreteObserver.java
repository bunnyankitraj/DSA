package org.observer.impl;

import org.observer.Observer;

public class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Subject state changed to: " + subject.getState());
    }
}
