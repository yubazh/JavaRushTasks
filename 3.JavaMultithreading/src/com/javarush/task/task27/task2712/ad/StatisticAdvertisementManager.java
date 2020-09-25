package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public Map<String, Integer> active(){

        List<Advertisement> list =  advertisementStorage.list();
        Map<String, Integer> tempMap = new TreeMap<>();
        for( Advertisement advertisement : list){
            if (advertisement.getHits() > 0){tempMap.put(advertisement.getName(), advertisement.getHits());}
        }

        return tempMap;
    }

    public List<String> archive(){

        List<Advertisement> list =  advertisementStorage.list();
        List<String> tempList = new ArrayList<>();
        for( Advertisement advertisement : list){
            if (advertisement.getHits() == 0){tempList.add(advertisement.getName());}
        }

        return tempList;
    }
}