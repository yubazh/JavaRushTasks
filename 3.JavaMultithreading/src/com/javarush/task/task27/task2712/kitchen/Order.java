package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    protected List<Dish> dishes;
    private final Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime += dish.getDuration();
        }
        return totalTime;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        if (dishes.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Dish dish : dishes) {
            stringBuffer.append(dish);
            stringBuffer.append(", ");
        }
        String dishesInOrder = stringBuffer.toString().substring(0, stringBuffer.toString().length() - 2);

        return "Your order: " + dishesInOrder + " of " + tablet.toString() +
                ", cooking time " + getTotalCookingTime() + "min";
    }
}