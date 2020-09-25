package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.util.Observable;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet{
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    private final int number;
    private LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public Tablet(int tablet) {
        this.number = tablet;
    }

    public void setQueue(LinkedBlockingQueue queue){
        this.queue = queue;
    }

    public void createOrder() {
        try {
            final Order newOrder = new Order(this);
            insideOrder(newOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    private void insideOrder(Order newOrder) throws IOException {
        if (newOrder.isEmpty()) return;
        ConsoleHelper.writeMessage(newOrder.toString());
        queue.offer(newOrder);
        //setChanged();
        //this.notifyObservers(newOrder);
        try {
            new AdvertisementManager(newOrder.getTotalCookingTime() * 60).processVideos();
        } catch (NoVideoAvailableException e) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(newOrder.getTotalCookingTime()*60));
            logger.log(Level.INFO, "No video is available for the order " + newOrder);
        }
    }

    public void createTestOrder() {
        try {
            final Order newOrder = new TestOrder(this);
            insideOrder(newOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}