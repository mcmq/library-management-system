import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;
    Message message = new Message();

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        book.setId();
        books.add(book);
        message.success("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        message.success("The book has been added successfully.");
    }

    public void removeBook(String title) {
        Book book = findBook(title);

        if (book != null) {
            books.remove(book);
            message.success(book.getTitle() + " has been removed successfully!");
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        message.success("Sorry! No book with title '" + title + "' has been found!");
        return null;
    }

    public void displayBooks() {
        // Check wether library has some books or not
        // If it's empty, notify the user
        if (books.isEmpty()) {
            message.success("Sorry! The library is empty");
        }

        int index = 1;

        for (Book book : books) {
            message.success(index + ". ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            index++;
        }
    }

    public void borrowBook(String title) {
        Book book = findBook(title);

        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailability(false);
                message.success("Thank you, please ensure the book is returned undamaged.");
                return;
            }
            message.success("Sorry! The book is already borrowed.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);

        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailability(true);
                message.success("Thank you for taking good care of the book.");
                return;
            }
            message.success("Sorry! The book is already in the library, please make sure the title is correct.");
        }
    }
}
