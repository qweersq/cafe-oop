package admin;

import customer.*;
import java.util.Scanner;

public class admin {

    // create constructor for food
    // public admin(String foodName, String foodPrice, String foodQuantity) {
    // this.foodName = foodName;
    // this.foodPrice = foodPrice;
    // this.foodQuantity = foodQuantity;
    // }

    //food menu

    // create menu for editing Food.java
    public static void main() {
        int choice;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);


        customer.App.setArraylist();
        // System.out.print("\033[H\033[2J");
        do {
            // clear screen
            System.out.println("Welcome to Admin Page");
            System.out.println("1. Food Menu");
            System.out.println("2. Drink Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add Food");
                    System.out.println("2. Edit Food");
                    System.out.println("3. Delete Food");
                    System.out.println("4. View Food");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            System.out.print("Enter food name: ");
                            String foodName = sc1.nextLine();
                            System.out.print("Enter food price: ");
                            int foodPrice = sc1.nextInt();
                            System.out.print("Enter food quantity: ");
                            int foodQuantity = sc1.nextInt();
                            System.out.println("Enter Food category: ");
                            String foodCategory = sc1.nextLine();
                            customer.App.addFood(foodName, foodPrice, foodQuantity, foodCategory);
                            break;
                        case 2:
                            System.out.print("Enter food name: ");
                            String foodName1 = sc1.nextLine();
                            customer.App.editFood(foodName1);
                            break;
                        case 3:
                            System.out.print("Enter food name: ");
                            String foodName2 = sc1.nextLine();
                            System.out.println("Please input "+foodName2+" to confirm");
                            String confirm = sc1.nextLine();
                            if (confirm.equals(foodName2)) {
                                customer.App.deleteFood(foodName2);
                            } else {
                                System.out.println("Operation cancelled");
                            }
                            break;
                        case 4:
                            customer.App.viewFood();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Add Drink");
                    System.out.println("2. Edit Drink");
                    System.out.println("3. Delete Drink");
                    System.out.println("4. View Drink");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter drink name: ");
                            String drinkName = sc1.nextLine();
                            System.out.print("Enter drink price: ");
                            int drinkPrice = sc1.nextInt();
                            System.out.print("Enter drink quantity: ");
                            int drinkQuantity = sc1.nextInt();
                            System.out.println("Enter Drink category: ");
                            String drinkCategory = sc1.nextLine();
                            customer.App.addDrink(drinkName, drinkPrice, drinkQuantity, drinkCategory);
                            break;
                        case 2:
                            System.out.print("Enter drink name: ");
                            String drinkName1 = sc1.nextLine();
                            customer.App.editDrink(drinkName1);
                            break;
                        case 3:
                            System.out.print("Enter drink name: ");
                            String drinkName2 = sc1.nextLine();
                            // ask for confirmation
                            System.out.println("please input "+drinkName2+" again to confirm");
                            String drinkName3 = sc1.nextLine();
                            if (drinkName2.equals(drinkName3)){
                                customer.App.deleteDrink(drinkName2);
                            }
                            else{
                                System.out.println("Operation cancelled");
                            }

                            customer.App.deleteDrink(drinkName2);
                            break;
                        case 4:
                            customer.App.viewDrink();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;

                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 3);

}
}
