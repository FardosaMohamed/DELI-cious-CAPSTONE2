import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void writeReceipt(Order order) {
        // Generate timestamp-based filename
        LocalDateTime now = LocalDateTime.now();
        String filename = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Create receipts folder if it doesn't exist
        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File receiptFile = new File(folder, filename);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("🧾 DELI-cious Sandwich Receipt 🧾\n");
            writer.write("🗓️ Order Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            int sandwichCount = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("🥪 Sandwich #" + sandwichCount++ + ":\n");
                writer.write(sandwich.toString() + "\n\n");
            }

            writer.write("🥤 Drinks:\n");
            for (String size : order.getDrinks().keySet()) {
                writer.write("- " + size + ": " + order.getDrinks().get(size) + "\n");
            }

            writer.write("\n🍟 Chips:\n");
            for (String chip : order.getChips()) {
                writer.write("- " + chip + "\n");
            }

            writer.write("\n💰 Total: $" + String.format("%.2f", order.calculateTotal()) + "\n");
            writer.write("✅ Thank you for your order! Come again soon!\n");

        } catch (IOException e) {
            System.out.println("⚠️ Error writing receipt: " + e.getMessage());
        }
    }
}
