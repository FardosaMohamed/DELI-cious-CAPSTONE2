import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReceiptWriter {

    public static void writeReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        String filename = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File receiptFile = new File(folder, filename);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("🧾 DELI-cious Sandwich Receipt 🧾\n");
            writer.write("🗓️ Order Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            // 🥪 Sandwiches
            int sandwichCount = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("🥪 Sandwich #" + sandwichCount++ + ":\n");
                writer.write(sandwich.toString() + "\n\n");
            }

            // 🥤 Drinks
            if (!order.getDrinks().isEmpty()) {
                writer.write("🥤 Drinks:\n");
                for (Map.Entry<String, Integer> entry : order.getDrinks().entrySet()) {
                    String size = entry.getKey();
                    int qty = entry.getValue();
                    double unitPrice = SandwichOptions.DRINK_PRICES.getOrDefault(size, 0.0);
                    writer.write(String.format("- %s x%d @ $%.2f = $%.2f\n", size, qty, unitPrice, unitPrice * qty));
                }
                writer.write("\n");
            }

            // 🍟 Chips
            if (!order.getChips().isEmpty()) {
                writer.write("🍟 Chips:\n");
                Map<String, Integer> chipCounts = new java.util.HashMap<>();
                for (String chip : order.getChips()) {
                    chipCounts.put(chip, chipCounts.getOrDefault(chip, 0) + 1);
                }
                for (Map.Entry<String, Integer> entry : chipCounts.entrySet()) {
                    writer.write(String.format("- %s x%d @ $%.2f = $%.2f\n",
                            entry.getKey(), entry.getValue(), SandwichOptions.CHIP_PRICE, SandwichOptions.CHIP_PRICE * entry.getValue()));
                }
                writer.write("\n");
            }

            // 💰 Total
            writer.write(String.format("💰 Total: $%.2f\n", order.calculateTotal()));
            writer.write("✅ Thank you for your order! Come again soon!\n");

        } catch (IOException e) {
            System.out.println("⚠️ Error writing receipt: " + e.getMessage());
        }
    }
}