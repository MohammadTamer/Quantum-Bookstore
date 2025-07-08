import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book, int quantity) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void incrementBook(Book book, int quantity) {
        if (book instanceof PaperBook)
            ((PaperBook) book).incrementQuantity(quantity);
    }

    public void decrementBook(Book book) {
        if (book instanceof PaperBook) {
            ((PaperBook) book).decrementQuantity();
            if (((PaperBook) book).getQuantity() == 0) {
                this.books.remove(book);
            }
        }

    }

    public HashMap<String, Book> loadBooks(String filename) {
        HashMap<String, Book> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(Paths.get(filename)), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts[0].equals("EBook") && parts.length == 5) {
                    // EBook: type|isbn|title|year|price
                    String isbn = parts[1];
                    String title = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    int price = Integer.parseInt(parts[4]);
                    Book book = new EBook(isbn, title, year, price);
                    this.books.add(book);
                    data.put(isbn, book);

                } else if (parts[0].equals("PaperBook") && parts.length == 7) {
                    String isbn = parts[1];
                    String title = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    int price = Integer.parseInt(parts[4]);
                    int quantity = Integer.parseInt(parts[5]);
                    boolean shippable = Boolean.parseBoolean(parts[6]);
                    Book book = new PaperBook(isbn, title, year, price, quantity, shippable);
                    this.books.add(book);
                    data.put(isbn, book);
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Error reading the file!");
        }
        return data;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
