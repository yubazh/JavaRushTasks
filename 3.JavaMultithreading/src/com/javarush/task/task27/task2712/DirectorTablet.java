package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private StatisticManager statisticManager = StatisticManager.getInstance();

    public void printAdvertisementProfit() {

        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().amountPerDay();
        double totalAmount = 0;
        double amount;
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            amount = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), amount));
            totalAmount += amount;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> map = statisticManager.cookLoading();
        for (Map.Entry entry : map.entrySet()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String date = simpleDateFormat.format(entry.getKey());
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> map1 = (Map) entry.getValue();

            for (Map.Entry entry1 : map1.entrySet()) {
                ConsoleHelper.writeMessage(entry1.getKey() + " - " + entry1.getValue() + " min");
            }
        }
    }

    public void printActiveVideoSet() {
        Map<String, Integer> map = StatisticAdvertisementManager.getInstance().active();
        for(Map.Entry entry : map.entrySet()){
            ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printArchivedVideoSet() {
        List<String> list = StatisticAdvertisementManager.getInstance().archive();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for(String name : list){
            ConsoleHelper.writeMessage(name);
        }
    }
}