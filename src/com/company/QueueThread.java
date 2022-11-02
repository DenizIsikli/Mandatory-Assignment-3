package com.company;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class QueueThread extends Thread {

    Semaphore sem;

    public QueueThread() {
        sem = new Semaphore(1);
    }


    public void buyGrocerciesInLine(Customer customer) {
        try {
            System.out.println("Customer " + customer.getName() + ": Is waiting in line and is still shopping while waiting for his turn");
            sem.acquire();
            System.out.println("Customer " + customer.getName() + ": Has the turn in the queue, place your groceries on the belt");
            long durationOfItems = (long) (Math.random() * 1);
            TimeUnit.SECONDS.sleep(durationOfItems);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Customer " + customer.getName() + ": Has paid and now leaving the store \n");
            sem.release();
        }
    }
}