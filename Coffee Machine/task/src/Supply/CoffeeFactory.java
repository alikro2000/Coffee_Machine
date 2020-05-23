package Supply;

public class CoffeeFactory {
    public enum CoffeeType {ESPRESSO, LATTE, CAPPUCCINO}

    public static Coffee CreateCoffee(CoffeeType type) {
        Coffee coffee;
        switch (type) {
            case ESPRESSO:
                coffee = new Coffee(4, 250, 0, 16);
                break;
            case LATTE:
                coffee = new Coffee(7, 350, 75, 20);
                break;
            case CAPPUCCINO:
                coffee = new Coffee(6, 200, 100, 12);
                break;
            default:
                coffee = new Coffee(0, 0, 0, 0);
                System.out.println("ERROR! INVALID COFFEE TYPE");
                break;
        }
        return coffee;
    }
}
