import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Inventory i = new Inventory();
        HashMap<String, Book> data = i.loadBooks("src\\books.txt");
        Cart cart = new Cart();
        cart.add(data,"ISBN001");
        cart.add(data,"ISBN002");
        cart.add(data,"ISBN101");
        cart.add(data,"ISBN102");
        cart.add(data,"ISBN103");
        cart.checkout();

    }
}