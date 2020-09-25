package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда, для выхода введите exit:");
        List<Dish> tempListForDish = new ArrayList<>();

        while (true){
            String dish = readString();
            if(dish.equalsIgnoreCase("exit"))break;
            try{
                tempListForDish.add(Dish.valueOf(dish));}catch (Exception e){writeMessage("Такого блюда нет в меню.");}
        }
        return tempListForDish;
    }
}