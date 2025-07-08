public class EBook extends Book {

    public EBook(String IBSN, String title, int publicationYear, int price) {
        super(IBSN, title, publicationYear, price);
    }

    public void sendToEmail(String email) {
        //System.out.println("The Book " + this.title + "has sent to : " + email);
    }
}
