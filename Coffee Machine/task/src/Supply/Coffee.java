package Supply;

public class Coffee {
    private int cost;
    private int water;
    private int milk;
    private int coffee;

    public Coffee(int cost, int water, int milk, int coffee) {
        this.cost = cost;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
    }

    public int getCost() {
        return cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }
}
