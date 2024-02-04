import java.util.Random;

public class Book {
    private long id = 0;
    private String title;
    private String author;
    private boolean availability = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean isAvailable() {
        return this.availability;
    }

    // Setters
    public void setId() {
        Random random = new Random();
        long min = 1000000000L;
        long max = 9999999999L;
        this.id = min + ((long) (random.nextDouble() * (max - min + 1)));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
