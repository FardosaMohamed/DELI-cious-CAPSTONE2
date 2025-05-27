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
        if (type.equals("regular") || type.equals("sauce")) return 0.0;

        // Pricing logic based on size
        switch (type) {
            case "meat":
                return isExtra ? switch (size) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> 0.0;
                } : switch (size) {
                    case 4 -> 1.00;
                    case 8 -> 2.00;
                    case 12 -> 3.00;
                    default -> 0.0;
                };
            case "cheese":
                return isExtra ? switch (size) {
                    case 4 -> 0.30;
                    case 8 -> 0.60;
                    case 12 -> 0.90;
                    default -> 0.0;
                } : switch (size) {
                    case 4 -> 0.75;
                    case 8 -> 1.50;
                    case 12 -> 2.25;
                    default -> 0.0;
                };
        }
        return 0.0;
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