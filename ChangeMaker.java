//arichardson25@georgefox.edu

import java.util.Scanner;

/**
 * @brief A utility class to calculate change given a sales amount and an amount tendered
 * @file ChangeMaker.java
 * @author Anastasia Richardson (arichardson25@georgefox.edu)
 */
public class ChangeMaker
{
    /**
     * Main entry point to run the program
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my Change Maker program");

        // Get sale price from user
        System.out.print("Enter the sales price (xx.xx): $");
        double salesPrice = sc.nextDouble();
        System.out.println();

        //Get amount tendered from user
        System.out.print("Enter the amount tendered (xx.xx): $");
        double amountTendered = sc.nextDouble();
        System.out.println();

        //Check if user gave enough money to cover sale price
        if (amountTendered < salesPrice)
        {
            System.out.println("Not enough money.");
        }

        else
        {
            //Calculate change needed
            double changeNeeded = amountTendered - salesPrice;
            System.out.printf("Your change is: $%.2f%n", changeNeeded);
            System.out.println("You will receive:");

            //Call function to get bills and coins needed
            changeMaker(changeNeeded);
        }

    }

    /**
     * A function that determines which bills and coins the user receives
     * @param changeNeeded How much change the user will receive
     */
    public static void changeMaker(double changeNeeded)
    {
        double[] changeValues = {100, 50, 20, 10, 5, 1, 0.25, 0.10, 0.05, 0.01};
        String[] changeNames =
                {
                        "One hundred dollar bill", "Fifty dollar bill", "Twenty dollar bill", "Ten dollar bill",
                        "Five dollar bill", "One dollar bill", "Quarter", "Dime", "Nickel", "Penny"
                };
        int amount;
        //Use a for loop to find change needed
        for (int i = 0; i < changeValues.length; i++)
        {
            if (changeNeeded >= changeValues[i])
            {
                amount = 0;
                //Use a while loop to avoid division with doubles
                while(changeNeeded >= changeValues[i])
                {
                    amount = amount + 1;
                    changeNeeded = changeNeeded - changeValues[i];
                }
                if (amount > 1)
                {
                    //Change penny to pennies
                    if (changeNames[i].equals("Penny"))
                    {
                        System.out.println(amount + " - Pennies");
                    }
                    //Make other bills and coins plural
                    else
                    {
                        System.out.println(amount + " - " + changeNames[i] + "s");
                    }
                }
                //Print out for just one coin or bill
                else
                {
                    System.out.println(amount + " - " + changeNames[i]);
                }
            }
        }
    }
}
