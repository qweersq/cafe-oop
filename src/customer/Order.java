package customer;

import java.util.ArrayList;

public class Order {

    // Food list
    ArrayList<Food> foods;
    // Drink list
    private ArrayList<Drink> drinks;

    // Constructor
    public Order() {
        this.foods = new ArrayList<Food>();
        this.drinks = new ArrayList<Drink>();
    }

    // Getters and setters

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    // toString method
    @Override
    public String toString() {
        for (Food food : foods) {
            System.out.println(food);
        }
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
        return "+================================================================+";
    }

    public void orderFood(Food food, int quantity) {
        if (food.getQuantity() >= quantity) {
            food.setQuantity(food.getQuantity() - quantity);
            foods.add(food);
        } else {
            System.out.println("Not enough stock");
        }
    }

    public void orderDrink(Drink drink, int quantity) {
        if (drink.getQuantity() >= quantity) {
            drink.setQuantity(drink.getQuantity() - quantity);
            drinks.add(drink);
        } else {
            System.out.println("Not enough stock");
        }
    }

    public String getTotal(int quantity1, int quantity2) {
        double total = 0;

        for (Food food : foods) {
            total += food.getPrice() * quantity1;
        }
        for (Drink drink : drinks) {
            total += drink.getPrice() * quantity2;
        }
        return String.format("| Total: Rp %.2f", total);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }

    public void clearOrder() {
        foods.clear();
        drinks.clear();
    }

}
