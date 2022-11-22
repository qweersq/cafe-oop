package customer;

import java.util.ArrayList;
import java.util.Scanner;

//create oop managment restaurant
public class App {

    public static ArrayList<Food> foods = new ArrayList<Food>();
    public static ArrayList<Drink> drinks = new ArrayList<Drink>();
    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static void setArraylist() {
        // add food to list
        foods.add(new Food("Burger", 10.0, 0, "Main"));
        foods.add(new Food("Fries", 5.0, 0, "Dessert"));
        foods.add(new Food("Salad", 7.0, 0, "Apetizer"));

        // add drink to list
        drinks.add(new Drink("Coke", 2.0, 0, "Soft Drink"));
        drinks.add(new Drink("Sprite", 2.0, 0, "Soft Drink"));
        drinks.add(new Drink("Water", 1.0, 0, "Water"));
    }

    public static void addFood(String name, double price, int quantity, String type) {
        foods.add(new Food(name, price, 0, type));
    }

    // delete food from list
    public static void deleteFood(String name) {
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equals(name)) {
                foods.remove(i);
            }
        }
    }

    // edit food from list
    public static void editFood(String name) {
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equals(name)) {
                System.out.println("Enter new food name: ");
                Scanner sc = new Scanner(System.in);
                String newName = sc.nextLine();
                foods.get(i).setName(newName);
                System.out.println("Enter new food price: ");
                double newPrice = sc.nextDouble();
                foods.get(i).setPrice(newPrice);
                System.out.println("Enter new food type: ");
                String newType = sc.nextLine();
                foods.get(i).setCategory(newType);
                System.out.println("Edit food success");
            }
        }
    }

    public static void viewFood() {
        System.out.println("Food List: ");
        System.out.println("+==========================================+");
        System.out.println("| No |      Name      |  Price  | Category |");
        System.out.println("+==========================================+");
        for (int i = 0; i < foods.size(); i++) {
            // print food list sesuai tabel
            System.out.printf("| %2d | %-14s | %7.3f | %-8s |%n", i + 1, foods.get(i).getName(),
                    foods.get(i).getPrice(), foods.get(i).getCategory());
        }
        System.out.println("+==========================================+");
    }

    public static void viewDrink() {
        System.out.println("Drink List: ");
        System.out.println("+==========================================+");
        System.out.println("| No |      Name      |  Price  | Category |");
        System.out.println("+==========================================+");
        for (int i = 0; i < drinks.size(); i++) {
            // print drink list sesuai tabel
            System.out.printf("| %2d | %-14s | %7.3f | %-8s |%n", i + 1, drinks.get(i).getName(),
                    drinks.get(i).getPrice(), drinks.get(i).getCategory());
        }
    }

    public static void addDrink(String name, double price, int quantity, String type) {
        drinks.add(new Drink(name, price, quantity, type));
    }

    // delete drink
    public static void deleteDrink(String name) {
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().equals(name)) {
                drinks.remove(i);
            }
        }
    }

    // edit drink
    public static void editDrink(String name) {
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().equals(name)) {
                System.out.println("Enter new drink name: ");
                Scanner sc = new Scanner(System.in);
                String newName = sc.nextLine();
                drinks.get(i).setName(newName);
                System.out.println("Enter new drink price: ");
                double newPrice = sc.nextDouble();
                drinks.get(i).setPrice(newPrice);
                System.out.println("Enter new drink type: ");
                String newType = sc.nextLine();
                drinks.get(i).setCategory(newType);
                System.out.println("Edit drink success");
            }
        }
    }

    public static void main() {
        int foodQuantity = 0;
        int drinkQuantity = 0;

        // menu
        do {
            System.out.println("Welcome to our restaurant!");
            System.out.println("1. Order Food or Drink");
            System.out.println("2. View Order");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("1. Food");
                    System.out.println("2. Drink");
                    System.out.print("Choose: ");
                    int choose1 = sc.nextInt();
                    switch (choose1) {
                        case 1:
                            // view food
                            viewFood();

                            System.out.print("Choose: ");
                            int chooseFood = sc.nextInt();
                            System.out.print("Quantity: ");
                            int quantityFood = sc.nextInt();
                            // jika quantity lebih dari 0 maka hanya menambahkan quantity
                            if (foods.get(chooseFood - 1).getQuantity() > 0) {
                                foodQuantity = foods.get(chooseFood - 1).getQuantity() + quantityFood;
                                foods.get(chooseFood - 1).setQuantity(foodQuantity);
                            } else {
                                foods.get(chooseFood - 1).setQuantity(quantityFood);
                            }
                            foodQuantity += quantityFood;
                            break;
                        case 2:
                            viewDrink();
                            System.out.print("Choose: ");
                            int chooseDrink = sc.nextInt();
                            System.out.print("Quantity: ");
                            int quantityDrink = sc.nextInt();
                            // jika quantity lebih dari 0 maka hanya menambahkan quantity
                            if (drinks.get(chooseDrink - 1).getQuantity() > 0) {
                                drinkQuantity = drinks.get(chooseDrink - 1).getQuantity() + quantityDrink;
                                drinks.get(chooseDrink - 1).setQuantity(drinkQuantity);
                            } else {
                                drinks.get(chooseDrink - 1).setQuantity(quantityDrink);
                            }
                            break;
                        default:
                            System.out.println("Wrong choose!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Food List: ");
                    // print tabel food tambah quantity
                    System.out.println("+=====================================================+");
                    System.out.println("| No |      Name      |  Price  | Category | Quantity |");
                    System.out.println("+=====================================================+");
                    for (int i = 0; i < foods.size(); i++) {
                        if (foods.get(i).getQuantity() != 0) {
                            System.out.printf("| %2d | %-14s | %7.3f | %-8s | %8d |%n", i + 1, foods.get(i).getName(),
                                    foods.get(i).getPrice(), foods.get(i).getCategory(), foods.get(i).getQuantity());
                        }
                    }
                    for (int i = 0; i < drinks.size(); i++) {
                        if (drinks.get(i).getQuantity() != 0) {
                            System.out.printf("| %2d | %-14s | %7.3f | %-8s | %8d |%n", i + 1, drinks.get(i).getName(),
                                    drinks.get(i).getPrice(), drinks.get(i).getCategory(), drinks.get(i).getQuantity());
                        }
                    }
                    System.out.println("+=====================================================+");
                    // print total price
                    double totalPrice = 0;
                    for (int i = 0; i < foods.size(); i++) {
                        totalPrice += foods.get(i).getPrice() * foods.get(i).getQuantity();
                    }
                    for (int i = 0; i < drinks.size(); i++) {
                        totalPrice += drinks.get(i).getPrice() * drinks.get(i).getQuantity();
                    }
                    System.out.printf("Total Price : Rp %.3f\n", totalPrice);
                    System.out.println("+=====================================================+");
                    break;
                case 3:
                    // System.out.println("Thank you for using our service!");
                    break;
                default:
                    System.out.println("Wrong choose!");
                    break;
            }
        } while (true);
    }
}