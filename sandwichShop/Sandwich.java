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
        sb.append(size).append("\" ").append(typeOfBread).append(isToasted ? " (Toasted)" : " (Not Toasted)").append("\n");
        sb.append("Toppings:\n");
        for (Topping topping : toppings) {
            sb.append("  - ").append(topping).append("\n");
        }
        sb.append("Price: $").append(String.format("%.2f", calculatePrice()));
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