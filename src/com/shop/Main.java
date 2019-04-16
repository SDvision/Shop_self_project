/*for practise of array,array list and linked list
so, we have shop, it contains items in one array and another array contains the number of that items
available, there also another  array which contains the money per buying of each corresponding item.

so buyer have limited money and he can buy the items from the shop, so the buyer have array list for the items he have
and attribute for the money, he can buy as much as he can and until money ends

make this application for the buyer use so that he can buy items
*/

package com.shop;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Shop shop = new Shop();
        Buyer buyer = new Buyer(10);
        int choice = 0;
        printOptions();
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    shop.setShop();
                    break;
                case 2:
                    shop.showAllItems();
                    break;
                case 3:
                    buyer.printBuyeditem();
                    System.out.println("Money in Buyers Wallet - " +buyer.getMoney());
                    break;
                case 4:

                    System.out.println("Money in Buyers Wallet - " +buyer.getMoney());
                    System.out.print("\nEnter item number to be buy - ");
                    int buyIndex = sc.nextInt()-1;
                    System.out.print("\nEnter Number of this Items to Buy - ");
                    int numberOfItemsToBuy = sc.nextInt();
                    if( (shop.getSpecificItemAvailability(buyIndex)>0) && buyer.canBuy(shop.getSpecificItemPrice(buyIndex)*numberOfItemsToBuy) ) {
                        buyer.buyItem(numberOfItemsToBuy,shop.getSpecificItemName(buyIndex),
                                shop.getSpecificItemPrice(buyIndex));
                        System.out.println("Money in Buyers Wallet - " +buyer.getMoney());
                        System.out.println("Buyer Buyed Item: "+  numberOfItemsToBuy +" "+ shop.getSpecificItemName(buyIndex) + " for "
                                +shop.getSpecificItemPrice(buyIndex)*numberOfItemsToBuy);
                        shop.reduceBuyedItems(buyIndex, numberOfItemsToBuy);
                    }
                    else {
                        System.out.println("You Don't Have that much Money to buy this item Or Items is no more Avaiilable.");
                        System.out.println("Money in Buyers Wallet - " +buyer.getMoney());
                    }
                    //if can buy, buy it
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please Enter valid choice");
            }
            System.out.println("\n\n");
            printOptions();
        } while (true);

    }
    private static void printOptions () {
        System.out.println("1. Set the shop (for Shop Owner Only)");
        System.out.println("2. Show Items in the Shop");
        System.out.println("3. Show Items that Buyer Have.");
        System.out.println("4. Buy an item");
        System.out.println("5. Exit");
    }
}
