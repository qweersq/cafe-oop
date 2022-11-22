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
            System.out.println("1. Add Food");
            System.out.println("2. Edit Food");
            System.out.println("3. Delete Food");
            System.out.println("4. View Food");
            System.out.println("5. Exit");
            // create choose for user to choose
            System.out.print("Enter your choice: ");
            choice = sc1.nextInt();
            // create switch case for user to choose
            switch (choice) {
                case 1:
                    System.out.println("\nAdd Food");
                    System.out.print("Enter Food Name: ");
                    String foodName = sc.nextLine();
                    System.out.print("Enter Food Price: ");
                    double foodPrice = sc1.nextInt();
                    System.out.print("Enter Food Quantity: ");
                    Integer foodQuantity = sc1.nextInt();
                    System.out.print("Enter Food Category: ");
                    String foodCategory = sc.nextLine();
                    // create new food
                    customer.App.addFood(foodName, foodPrice, foodQuantity, foodCategory);

                    break;
                case 2:
                    System.out.println("Edit Food");
                    break;
                case 3:
                    System.out.println("Delete Food");
                    //view food list
                    customer.App.viewFood();
                    System.out.println("Enter Food Name to delete: ");
                    String foodName1 = sc.nextLine();
                    customer.App.deleteFood(foodName1);
                    break;
                case 4:
                    System.out.println("\nView Food");
                    customer.App.viewFood();
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);

    }
}
