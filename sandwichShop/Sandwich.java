import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final int size;
    private final String typeOfBread;
    private final boolean isToasted;
    private final List<Topping> toppings;

    public Sandwich(int size, String typeOfBread, boolean isToasted) {
        if (!SandwichOptions.SIZE_PRICE_MAP.containsKey(size)) {
            throw new IllegalArgumentException("Invalid sandwich size: " + size);
        }
        this.size = size;
        this.typeOfBread = typeOfBread;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public void removeTopping(String name) {
        toppings.removeIf(t -> t.getName().equalsIgnoreCase(name));
    }

    public double calculatePrice() {
        double basePrice = SandwichOptions.SIZE_PRICE_MAP.get(size);
        double toppingCost = 0.0;
        for (Topping topping : toppings) {
            toppingCost += topping.getCost(size);
        }
        return basePrice + toppingCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(typeOfBread)
                .append(isToasted ? " (Toasted)\n" : " (Not Toasted)\n");

        sb.append("Toppings:\n");

        double toppingTotal = 0.0;
        for (Topping topping : toppings) {
            double cost = topping.getCost(size);
            toppingTotal += cost;

            sb.append(String.format("  - %-20s (%s%s): $%.2f\n",
                    topping.getName(),
                    topping.getType(),
                    topping.isExtra() ? ", extra" : "",
                    cost));
        }

        double basePrice = SandwichOptions.SIZE_PRICE_MAP.get(size);
        double total = basePrice + toppingTotal;

        sb.append(String.format("Base Price:               $%.2f\n", basePrice));
        sb.append(String.format("Topping Total:            $%.2f\n", toppingTotal));
        sb.append(String.format("Sandwich Total:           $%.2f", total));

        return sb.toString();
    }



    //Getters
    public int getSize() {
        return size;
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
}