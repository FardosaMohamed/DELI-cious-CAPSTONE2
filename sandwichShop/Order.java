import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<String> chips = new ArrayList<>();
    private Map<String, Integer> drinks = new HashMap<>(); // Drink size → quantity

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(String size) {
        drinks.put(size, drinks.getOrDefault(size, 0) + 1);
    }

    public void addChips(String type) {
        chips.add(type);
    }

    public double calculateTotal() {
        double total = 0.0;

        for (Sandwich s : sandwiches) total += s.calculatePrice();
        for (String chip : chips) total += SandwichOptions.CHIP_PRICES.getOrDefault(chip, 0.0);
        for (String size : drinks.keySet()) {
            double price = SandwichOptions.DRINK_PRICES.getOrDefault(size, 0.0);
            total += price * drinks.get(size);
        }

        return total;
    }

    public List<Sandwich> getSandwiches() { return sandwiches; }
    public List<String> getChips() { return chips; }
    public Map<String, Integer> getDrinks() { return drinks; }
}