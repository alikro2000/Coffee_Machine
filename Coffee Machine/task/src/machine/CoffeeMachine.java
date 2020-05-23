package machine;

import Supply.Coffee;
import Supply.CoffeeFactory;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterInMachine;
    private static int milkInMachine;
    private static int coffeeInMachine;
    private static int cupsInMachine;
    private static int moneyInMachine;
    private static Scanner scTerminal;

    public static void main(String[] args) throws Exception {
        scTerminal = new Scanner(System.in);
        initMachine();
        while (processActions() != 0) {
            System.out.println();
        }
    }

    private static void initMachine() {
        waterInMachine = 400;
        milkInMachine = 540;
        coffeeInMachine = 120;
        cupsInMachine = 9;
        moneyInMachine = 550;
    }

    private static int processActions() throws Exception {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scTerminal.nextLine();
        switch (action) {
            case "buy":
                processBuyAction();
                break;
            case "fill":
                processFillAction();
                break;
            case "take":
                processMoneyWithdrawalAction();
                break;
            case "remaining":
                printStatus();
                break;
            case "exit":
                return 0;
            default:
                System.out.println("Invalid action!");
                break;
        }

        return 1;
    }

    private static void printStatus() {
        System.out.println("The coffee machine has: ");
        System.out.printf("%d of water\n", waterInMachine);
        System.out.printf("%d of milk\n", milkInMachine);
        System.out.printf("%d of coffee beans\n", coffeeInMachine);
        System.out.printf("%d of disposable cups\n", cupsInMachine);
        System.out.printf("%d of money\n", moneyInMachine);
        System.out.println();
    }

    private static void processBuyAction() throws Exception {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scTerminal.nextLine();
        Coffee coffee;
        switch (choice) {
            case "1":
                coffee = CoffeeFactory.CreateCoffee(CoffeeFactory.CoffeeType.ESPRESSO);
                break;
            case "2":
                coffee = CoffeeFactory.CreateCoffee(CoffeeFactory.CoffeeType.LATTE);
                break;
            case "3":
                coffee = CoffeeFactory.CreateCoffee(CoffeeFactory.CoffeeType.CAPPUCCINO);
                break;
            case "back":
                return;
            default:
                throw new Exception("Coffee not defined!");
        }
        makePurchase(coffee);
    }

    private static void processFillAction() {
        System.out.println("Write how many ml of water do you want to add: ");
        int waterToAdd = scTerminal.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milkToAdd = scTerminal.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int coffeeToAdd = scTerminal.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cupsToAdd = scTerminal.nextInt();

        waterInMachine += waterToAdd;
        milkInMachine += milkToAdd;
        coffeeInMachine += coffeeToAdd;
        cupsInMachine += cupsToAdd;
    }

    private static void processMoneyWithdrawalAction() {
        System.out.println("I gave you " + moneyInMachine);
        moneyInMachine = 0;
    }

    private static void makePurchase(Coffee coffee) {
        if (waterInMachine < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milkInMachine < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeInMachine < coffee.getCoffee()) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cupsInMachine < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= coffee.getWater();
            milkInMachine -= coffee.getMilk();
            coffeeInMachine -= coffee.getCoffee();
            cupsInMachine -= 1;
            moneyInMachine += coffee.getCost();
        }
    }
}
