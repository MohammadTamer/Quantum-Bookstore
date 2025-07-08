public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String bookTitle) {
        super(bookTitle + " is out of stock");
    }
}