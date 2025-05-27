import java.util.*;

public class OrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // 🍞 Home Screen
            System.out.println("\n╔═══════════════════════════════╗");
            System.out.println("║  🥪 Welcome to DELI-cious! 🥪   ");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("1️⃣  New Order");
            System.out.println("0️⃣  Exit");
            System.out.print("👉 Enter your choice: ");
            String homeChoice = scanner.nextLine();

            switch (homeChoice) {
                case "1" -> {
                    Order currentOrder = new Order();
                    boolean ordering = true;

                    while (ordering) {
                        // 🧾 Order Menu
                        System.out.println("\n🧾 What would you like to do?");
                        System.out.println("1️⃣  🥪 Add Sandwich");
                        System.out.println("2️⃣  🥤 Add Drink");
                        System.out.println("3️⃣  🍟 Add Chips");
                        System.out.println("4️⃣  ✅ Checkout");
                        System.out.println("0️⃣  ❌ Cancel Order");
                        System.out.print("👉 Select an option: ");
                        String orderChoice = scanner.nextLine();

                        switch (orderChoice) {
                            case "1" -> {
                                Sandwich sandwich = buildSandwich(scanner);
                                currentOrder.addSandwich(sandwich);
                                System.out.println("✅ Sandwich added! 🥪");
                            }
                            case "2" -> {
                                System.out.print("🥤 Enter drink size (Small, Medium, Large): ");
                                String size = scanner.nextLine();
                                currentOrder.addDrink(size);
                                System.out.println("✅ " + size + " drink added.");
                            }
                            case "3" -> {
                                System.out.print("🍟 Enter chip type: ");
                                String chip = scanner.nextLine();
                                currentOrder.addChips(chip);
                                System.out.println("✅ " + chip + " chips added.");
                            }
                            case "4" -> {
                                // 🧾 Checkout
                                System.out.println("\n🛍️ Your Order Summary:");
                                for (int i = 0; i < currentOrder.getSandwiches().size(); i++) {
                                    System.out.println("🥪 Sandwich #" + (i + 1));
                                    System.out.println(currentOrder.getSandwiches().get(i));
                                    System.out.println();
                                }

                                System.out.println("🥤 Drinks: " + currentOrder.getDrinks());
                                System.out.println("🍟 Chips: " + currentOrder.getChips());
                                System.out.printf("💰 Total: $%.2f\n", currentOrder.calculateTotal());

                                System.out.print("📦 Confirm order? (yes/no): ");
                                String confirm = scanner.nextLine();
                                if (confirm.equalsIgnoreCase("yes")) {
                                    ReceiptWriter.writeReceipt(currentOrder); // Implement this class
                                    System.out.println("✅ Order confirmed and saved! 🧾💖");
                                } else {
                                    System.out.println("❌ Order canceled.");
                                }
                                ordering = false;
                            }
                            case "0" -> {
                                System.out.println("❌ Order canceled. Returning to home screen...");
                                ordering = false;
                            }
                            default -> System.out.println("⚠️ Invalid option. Please try again.");
                        }
                    }
                }
                case "0" -> {
                    System.out.println("👋 Goodbye! Thanks for visiting DELI-cious!");
                    running = false;
                }
                default -> System.out.println("⚠️ Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // 🛠️ Sandwich Builder
    private static Sandwich buildSandwich(Scanner scanner) {
        System.out.println("\n👉 Let's build your sandwich!");

        System.out.print("📏 Enter sandwich size (4, 8, 12): ");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.print("🍞 Enter bread type (White, Wheat, Rye, Wrap): ");
        String bread = scanner.nextLine();

        System.out.print("🔥 Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.print("➕ How many toppings do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("🥗 Topping #" + (i + 1));
            System.out.print("🔤 Topping name: ");
            String name = scanner.nextLine();

            System.out.print("📂 Topping type (meat, cheese, regular, sauce): ");
            String type = scanner.nextLine();

            System.out.print("✨ Extra? (yes/no): ");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

            sandwich.addTopping(new Topping(name, type, isExtra));
        }

        return sandwich;
    }
}
