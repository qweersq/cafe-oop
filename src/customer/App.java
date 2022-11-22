package customer;

import java.util.ArrayList;
import java.util.Scanner;

//create oop managment restaurant
public class App {
    public static ArrayList<Food> foods = new ArrayList<Food>();
    public static ArrayList<Drink> drinks = new ArrayList<Drink>();

    public static void setArraylist() {
        // add food to list
        foods.add(new Food("Burger", 10.0, 10, "Main"));
        foods.add(new Food("Fries", 5.0, 10, "Dessert"));
        foods.add(new Food("Salad", 7.0, 10, "Apetizer"));

        // add drink to list
        drinks.add(new Drink("Coke", 2.0, 10, "Soft Drink"));
        drinks.add(new Drink("Sprite", 2.0, 10, "Soft Drink"));
        drinks.add(new Drink("Water", 1.0, 10, "Water"));
    }

    public static void addFood(String name, double price, int quantity, String type) {
        foods.add(new Food(name, price, quantity, type));
    }

    public static void viewFood() {
        System.out.println("Food List");
        System.out.println("+==============================================================+");
        System.out.println("|        Name        |      Price      |  Quantity  | Category |");
        System.out.println("+==============================================================+");
        for (Food food : foods) {
            System.out.println(food);
        }
        System.out
                .println("+==============================================================+\n");
    }

    public static void main() {
        int foodQuantity = 0;
        int drinkQuantity = 0;
        Scanner sc = new Scanner(System.in);

        // // create food
        // Food food1 = new Food("Burger", 10.0, 10, "Main");
        // Food food2 = new Food("Fries", 5.0, 10, "Dessert");
        // Food food3 = new Food("Salad", 7.0, 10, "Apetizer");

        // // create drink
        // Drink drink1 = new Drink("Coke", 2.0, 10, "Soft Drink");
        // Drink drink2 = new Drink("Sprite", 2.0, 10, "Soft Drink");
        // Drink drink3 = new Drink("Water", 1.0, 10, "Water");

        // // add food to list
        setArraylist();
        // order something
        Order order = new Order();
        int choice = 0;
        do {
            System.out.println("1. Order Food or Drink");
            System.out.println("2. View Order");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. Food");
                    System.out.println("2. Drink");
                    System.out.print("Choice: ");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    switch (choice2) {
                        case 1:
                            viewFood();
                            System.out.print("Food Name: ");
                            String foodName = sc.nextLine();
                            System.out.print("Quantity: ");
                            foodQuantity = sc.nextInt();
                            sc.nextLine();
                            for (Food food : foods) {
                                if (food.getName().equals(foodName)) {
                                    food.orderFood(order, foodQuantity);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Drink List");
                            System.out.println("+================================================================+");
                            System.out.println("|        Name        |      Price      |  Quantity  |  Category  |");
                            System.out.println("+================================================================+");
                            for (Drink drink : drinks) {
                                System.out.println(drink);
                            }
                            System.out
                                    .println("+================================================================+\n");
                            System.out.print("Drink Name: ");
                            String drinkName = sc.nextLine();
                            System.out.print("Quantity: ");
                            drinkQuantity = sc.nextInt();
                            sc.nextLine();
                            for (Drink drink : drinks) {
                                if (drink.getName().equals(drinkName)) {
                                    order.orderDrink(drink, drinkQuantity);
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                case 2:
                    // jika order lebih dari 1 maka x akan di print
                    if (order.getFoods().size() > 0 || order.getDrinks().size() > 0) {
                        System.out.println("Order List");
                        System.out.println("+================================================================+");
                        System.out.println("|        Name        |      Price      |  Quantity  |  Category  |");
                        System.out.println("+================================================================+");
                        for (Food food : order.getFoods()) {
                            System.out.println(food);
                        }
                        for (Drink drink : order.getDrinks()) {
                            System.out.println(drink);
                        }
                        System.out.println("+================================================================+");
                        System.out.println(order.getTotal(foodQuantity, drinkQuantity));
                        System.out.println("+================================================================+");
                    } else {
                        System.out.println("Order is Empty");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using our service");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 3);

    }

}
