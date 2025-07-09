
# 📚 Quantum Bookstore

A Java-based console bookstore management system that supports both **EBooks** and **PaperBooks** with features like inventory loading from a file, shopping cart, checkout process, shipping logic, and stock management.

---

## 📦 Project Structure

Quantum Bookstore/
├── src/
│ ├── Book.java
│ ├── EBook.java
│ ├── PaperBook.java
│ ├── Cart.java
│ ├── Inventory.java
│ ├── OutOfStockException.java
│ └── Main.java
├── books.txt
└── README.md

## ✅ Features

- **Book Types**:
  - `EBook`: Sent via email upon checkout.
  - `PaperBook`: Can be shipped or picked up depending on availability.
- **Cart Functionality**: Add books to a cart by ISBN and perform checkout.
- **Inventory System**:
  - Loads books from a text file.
  - Supports quantity tracking and automatic stock removal.
- **Checkout Options**:
  - Ship paper books to an address if shippable.
  - Notify user if they need to pick it up manually.

---

## 📝 File Format (`books.txt`)

Each line represents one book.

### EBook Format
EBook|<ISBN>|<Title>|<PublicationYear>|<Price>


### PaperBook Format
PaperBook|<ISBN>|<Title>|<PublicationYear>|<Price>|<Quantity>|<Shippable>

### Example:
EBook|9780134685991|Effective Java|2018|55
PaperBook|9780132350884|Clean Code|2008|60|3|true
PaperBook|9781492056270|Learning Java|2021|45|1|false


## 🚀 How to Run

1. Ensure `books.txt` is in the project root directory.
2. Compile and run using your IDE (e.g., IntelliJ) or terminal.
3. Load books using `Inventory.loadBooks(filename)`.
4. Add books to a cart using:  
   ```java
   cart.add(bookMap, "9780132350884");
5. Call cart.checkout() to simulate the purchase.



📤 Sample Checkout Output:
EBook "Effective Java" has been sent to customer@gmail.com
PaperBook "Clean Code" has been shipped.
PaperBook "Learning Java" is not available for shipping. Please pick it up from the library inventory.

--- Selected Books ---
Item                           Price
----                           -----
Effective Java                55.0 L.E.
Clean Code                    60.0 L.E.
Learning Java                 45.0 L.E.
----------------------------------------
Total Price :               160.0 L.E.




🧠 Classes Overview
Book (abstract):
•	Fields: IBSN, title, publicationYear, price

EBook extends Book:
•	sendToEmail(String email)

PaperBook extends Book:
•	Additional fields: quantity, shippable
•	Methods: decrementQuantity(int), isShippable(), ShippingService(String address)

Cart:
•	add(HashMap<String, Book> data, String isbn)
•	checkout() — handles book processing and output

Inventory:
•	loadBooks(String filename) — loads from books.txt
•	Returns: HashMap<String, Book>

OutOfStockException:
•	Custom exception when quantity becomes zero


📌 Requirements:
• Java 8 or higher
•	UTF-8 encoded books.txt

👨‍💻 Author
Created by [Mohammad AlShafie]

