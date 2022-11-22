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
        // clear screen
        System.out.print("\033[H\033[2J");
        int choice;
        System.out.println("Welcome to Admin Page");
        System.out.println("1. Add Food");
        System.out.println("2. Edit Food");
        System.out.println("3. Delete Food");
        System.out.println("4. View Food");
        System.out.println("5. Exit");
        // create choose for user to choose
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        // create switch case for user to choose
        switch (choice) {
            case 1:
                System.out.println("\nAdd Food");

                break;
            case 2:
                System.out.println("Edit Food");
                break;
            case 3:
                System.out.println("Delete Food");
                break;
            case 4:
                System.out.println("\nView Food");
                customer.App.setArraylist();
                customer.App.viewFood();
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }
}
