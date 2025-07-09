import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getItems() {
        return books;
    }

    public void add(HashMap<String, Book> data, String ibsn) {
        this.books.add(data.get(ibsn));
    }

    public void checkout() {
        ArrayList<Book> taken = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof EBook) {
                ((EBook) book).sendToEmail("customer@example.com");
                System.out.println("📧 EBook \"" + book.getTitle() + "\" has been sent to customer@gmail.com");
                taken.add(book);
            } else if (book instanceof PaperBook) {
                PaperBook pb = (PaperBook) book;

                try {
                    pb.decrementQuantity();
                    if (pb.isShippable()) {
                        pb.ShippingService("45 El-Hegaz St, Cairo");
                        System.out.println("📦 PaperBook \"" + pb.getTitle() + "\" has been shipped.");
                    }else{
                        System.out.println("🏬 PaperBook \"" + pb.getTitle() + "\" is not available for shipping. Please pick it up from the library inventory.");
                    }
                    taken.add(pb);
                } catch (OutOfStockException e) {
                    System.out.println("❌ " + e.getMessage());
                }
            }
        }
        StringBuilder receiptBuilder = new StringBuilder();
        double sumPrice = 0.0;

        receiptBuilder.append("--- Selected Books ---\n");
        receiptBuilder.append(String.format("%-30s %12s\n", "Item", "Price"));
        receiptBuilder.append(String.format("%-30s %12s\n", "----", "-----"));

        for (Book book : taken) {
            sumPrice += book.getPrice();

            String formattedPrice = String.format("%.1f L.E.", book.getPrice());
            receiptBuilder.append(String.format("%-30s %12s\n", book.getTitle(), formattedPrice));
        }

        receiptBuilder.append("----------------------------------------\n");
        String totalFormatted = String.format("%.1f L.E.", sumPrice);
        receiptBuilder.append(String.format("%-30s %12s\n", "Total Price :", totalFormatted));

        System.out.println("\n\n\n----------------------------------------");
        System.out.println(receiptBuilder);
    }
}
