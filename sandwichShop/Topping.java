public class Topping {
    private final String name;
    private final String type; // "meat", "cheese", "regular", "sauce"
    private final boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type.toLowerCase();
        this.isExtra = isExtra;
    }

    public double getCost(int size) {
        // Regular toppings and sauces are always free
        if (type.equalsIgnoreCase("regular") || type.equalsIgnoreCase("sauce")) {
            return 0.0;
        }

        switch (type.toLowerCase()) {
            case "meat" -> {
                double baseMeatPrice = switch (size) {
                    case 4 -> 1.00;
                    case 8 -> 2.00;
                    case 12 -> 3.00;
                    default -> 0.0;
                };
                double extraMeatAddOn = isExtra ? switch (size) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> 0.0;
                } : 0.0;
                return baseMeatPrice + extraMeatAddOn;
            }

            case "cheese" -> {
                double baseCheesePrice = switch (size) {
                    case 4 -> 0.75;
                    case 8 -> 1.50;
                    case 12 -> 2.25;
                    default -> 0.0;
                };
                double extraCheeseAddOn = isExtra ? switch (size) {
                    case 4 -> 0.30;
                    case 8 -> 0.60;
                    case 12 -> 0.90;
                    default -> 0.0;
                } : 0.0;
                return baseCheesePrice + extraCheeseAddOn;
            }

            default -> {
                return 0.0; // Fallback for unknown types
            }
        }
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isExtra() {
        return isExtra;
    }
}