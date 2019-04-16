package com.shop;

import java.util.Scanner;

public class Shop {
    private static Scanner sc = new Scanner(System.in);

    private String[] items_name = new String[5];
    private int[] items_available = new int[5];
    private int[] money_list = new int[5];
    private boolean setShop = false;

    public int getSpecificItemPrice( int index) {
        return this.money_list[index];
    }
    public String getSpecificItemName( int index) {
        return this.items_name[index];
    }
    public int getSpecificItemAvailability(int index) {
        return this.items_available[index];
    }

    public void setShop()
    {
        System.out.println("*************************");
        System.out.println("Lets First Set up SHOP");

        for(int i = 0; i < 5; i++)
        {
            System.out.print("\nEnter Item Name :");
            items_name[i] =sc.next();
            System.out.print("\n Total available piece : ");
            items_available[i] = sc.nextInt();
            System.out.print("\nPrize per Item :" );
            money_list[i] = sc.nextInt();
        }
        setShop = true;
        System.out.println(" Shop is Ready ");
        System.out.println("**************************");
    }

    void showAllItems()
    {
        if(setShop)
        {
            for(int i = 0; i<items_available.length; i++)
            {
                System.out.println(i+1+"." + items_name[i] + " -- available (" + items_available[i] +")" +
                                    "--Price per item is " + money_list[i] );
            }
        }
        else
        {
            System.out.println("The Shop is not Ready to take order, Please  come back later");
        }
    }

    void reduceBuyedItems(int index, int numberOfItemsBuyed)
    {
        this.items_available[index]-= numberOfItemsBuyed;
    }
}
