import java.util.Random;

/**
 * Represents a book in the library.
 */
public class Book {
    // Unique identifier for the book
    private long id = 0;
    // Title of the book
    private String title;
    // Author of the book
    private String author;
    // Availability status of the book
    private boolean availability = true;

    /**
     * Constructor to create a new Book instance with the given title and author.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters

    /**
     * Retrieves the unique identifier of the book.
     * @return The unique identifier of the book.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Retrieves the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Retrieves the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Checks if the book is available for borrowing.
     * @return True if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return this.availability;
    }

    // Setters

    /**
     * Generates and sets a unique identifier for the book.
     * The identifier is a random long value within a specified range.
     */
    public void setId() {
        Random random = new Random();
        // Minimum value for the unique identifier
        long min = 1000000000L;
        // Maximum value for the unique identifier
        long max = 9999999999L;
        this.id = min + ((long) (random.nextDouble() * (max - min + 1)));
    }

    /**
     * Sets the title of the book.
     * @param title The title of the book to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     * @param author The author of the book to be set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the availability status of the book.
     * @param availability True if the book is available, false otherwise.
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}