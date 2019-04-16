package com.shop;

import java.util.ArrayList;
import java.util.Arrays;

public class Buyer {
    private ArrayList<String> buyed_items = new ArrayList<String>();
    private int money;

    public int getMoney() {
        return money;
    }

    public ArrayList<String> getBuyed_items() {
        return buyed_items;
    }

    public void printBuyeditem()
    {
        System.out.println("WARNING:: Showing only one time of Each Item buyed at One time ");
        System.out.println("Items : "+Arrays.toString(buyed_items.toArray()));
    }

    public Buyer(int money) {
        this.money = money;
    }

    boolean canBuy(int reqMoney)
    {
        if(this.money >= reqMoney)
        {
            return true;
        }
        return false;
    }

    void buyItem(int numOfItems, String itemName, int reqMoney)
    {
        this.money -= numOfItems*reqMoney;
        buyed_items.add(itemName);
    }

}
