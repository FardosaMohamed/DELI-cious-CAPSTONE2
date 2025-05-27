public class PhillyCheeseSteak extends Sandwich {
    public PhillyCheeseSteak() {
        super(8,"White",true);

        // Add default toppings
        addTopping(new Topping("Steak", "meat", false));
        addTopping(new Topping("American Cheese", "cheese", false));
        addTopping(new Topping("Peppers", "regular", false));
        addTopping(new Topping("Mayo", "sauce", false));

    }
}
