package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {

    protected boolean isSoldier;

    public void live() {
        if (isSoldier)
            fight();
    }

    public Soldier(String name, int age) {
        super(name, age);
        this.isSoldier = true;
    }

    public void fight() {
    }

}
