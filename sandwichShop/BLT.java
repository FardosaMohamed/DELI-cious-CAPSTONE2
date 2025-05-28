public class BLT extends Sandwich{
    public BLT() {
        super(8,"White",true);

        // Add default toppings
        addTopping(new Topping("Bacon","meat", false));
        addTopping(new Topping("Cheddar","cheese", false));
        addTopping(new Topping("Lettuce","regular", false));
        addTopping(new Topping("Tomato","regular", false));
        addTopping(new Topping("Ranch","sauce", false));
    }
}
