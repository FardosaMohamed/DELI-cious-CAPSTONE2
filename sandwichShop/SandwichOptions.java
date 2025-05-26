import java.util.Map;
import java.util.List;

public class SandwichOptions {
    public static final Map<Integer, Double> SIZE_PRICE_MAP = Map.of(
            4, 5.50,
            8, 7.00,
            12, 8.50
    );

    public static final List<String> BREAD_TYPES = List.of("White", "Wheat", "Rye", "Wrap");

    public static final List<String> MEATS = List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
    public static final List<String> CHEESES = List.of("American", "Provolone", "Cheddar", "Swiss");
    public static final List<String> REGULAR_TOPPINGS = List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
    public static final List<String> SAUCES = List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette");

    public static final Map<String, Double> CHIP_PRICES = Map.of("Regular", 1.50);
    public static final Map<String, Double> DRINK_PRICES = Map.of(
            "Small", 2.00,
            "Medium", 2.50,
            "Large", 3.00
    );
}
