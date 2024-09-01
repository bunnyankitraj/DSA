package org.singleton;

public enum SingletonEnum {
    INSTANCE;

    public void showMessage() {
        System.out.println("Hello, I am a Singleton using Enum!");
    }
}
