package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);
    private boolean man;

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int ind = base.get() + age / 100;
        if (hasWork) {
            ind = (int) (ind * 1.1);
        } else {
            ind = (int) (ind * 0.9);
        }
        if (hasHouse) {
            ind = (int) (ind * 1.1);
        } else {
            ind = (int) (ind * 0.9);
        }
        return ind;
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}