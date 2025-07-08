public abstract class Book {
    protected String IBSN;
    protected String title;
    protected int publicationYear;
    protected double price;

    public Book(String IBSN, String title, int publicationYear, double price) {
        this.IBSN = IBSN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIBSN() {
        return IBSN;
    }

    public void setIBSN(String IBSN) {
        this.IBSN = IBSN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
