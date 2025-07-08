public class PaperBook extends Book {
    private int quantity;
    private final boolean shippable;

    public PaperBook(String IBSN, String title, int publicationYear, int price, int quantity, boolean shippable) {
        super(IBSN, title, publicationYear, price);
        this.quantity = quantity;
        this.shippable = shippable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decrementQuantity() {
        if (quantity <= 0) {
            throw new OutOfStockException(this.title);
        } else {
            this.quantity -= 1;
        }
    }

    public boolean isShippable() {
        return shippable;
    }

    public void ShippingService(String address) {
        //if (this.isShippable())
           //System.out.println(this.title + "has shipped to " + address);
    }
}