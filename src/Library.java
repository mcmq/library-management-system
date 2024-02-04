import java.util.ArrayList;

/**
 * Represents a library containing a collection of books.
 */
public class Library {
    // ArrayList to store books in the library
    private final ArrayList<Book> books;
    // Instance of Message class for displaying formatted messages
    Message message = new Message();

    /**
     * Constructs a new Library object with an empty collection of books.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library and assigns a unique identifier to it.
     * @param book The book to be added to the library.
     */
    public void addBook(Book book) {
        // Generate and set a unique identifier for the book
        book.setId();
        // Add the book to the library collection
        books.add(book);
        // Display success message with book details
        message.success("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        message.success("The book has been added successfully.");
    }

    /**
     * Removes a book from the library based on its title.
     * @param title The title of the book to be removed.
     */
    public void removeBook(String title) {
        // Find the book with the specified title
        Book book = findBook(title);
        // If the book is found, remove it from the library
        if (book != null) {
            books.remove(book);
            message.success(book.getTitle() + " has been removed successfully!");
        }
    }

    /**
     * Finds a book in the library based on its title.
     * @param title The title of the book to be found.
     * @return The found Book object, or null if not found.
     */
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        message.success("Sorry! No book with title '" + title + "' has been found!");
        return null;
    }

    /**
     * Displays all the books available in the library.
     */
    public void displayBooks() {
        // Check if the library is empty
        if (books.isEmpty()) {
            message.success("Sorry! The library is empty");
        }

        // Iterate through each book and display its details
        int index = 1;
        for (Book book : books) {
            message.success(index + ". ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            index++;
        }
    }

    /**
     * Allows a user to borrow a book from the library.
     * @param title The title of the book to be borrowed.
     */
    public void borrowBook(String title) {
        Book book = findBook(title);
        // Check if the book is available for borrowing
        if (book != null) {
            if (book.isAvailable()) {
                // Set the book as unavailable (borrowed)
                book.setAvailability(false);
                message.success("Thank you, please ensure the book is returned undamaged.");
                return;
            }
            message.success("Sorry! The book is already borrowed.");
        }
    }

    /**
     * Allows a user to return a borrowed book to the library.
     * @param title The title of the book to be returned.
     */
    public void returnBook(String title) {
        Book book = findBook(title);
        // Check if the book is available for return
        if (book != null) {
            if (!book.isAvailable()) {
                // Set the book as available (returned)
                book.setAvailability(true);
                message.success("Thank you for taking good care of the book.");
                return;
            }
            message.success("Sorry! The book is already in the library, please make sure the title is correct.");
        }
    }
}