package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    double costPerWeight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.costPerWeight = (double) value / weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(Item[] items, int capacity) {
        // Sort items by cost per weight in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.costPerWeight).reversed());

        double totalValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take the whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take the fraction of the item
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;
        System.out.println("Maximum value in Knapsack: " + fractionalKnapsack(items, capacity));
    }
}
