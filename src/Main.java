import java.util.Scanner;

/*
 * Library Management System
 * This program demonstrates a simple library management system.
 * Users can perform various actions such as adding, removing, borrowing, and returning books.
 * @author Mohamed Abdillahi
 * @since 1.0
 */

public class Main {
    // User input scanner for the main menu
    private static Scanner scanner = new Scanner(System.in);
    // Library instance to manage books
    final private static Library library = new Library();
    // Message instance to display formatted messages
    final private static Message message = new Message();
    // Flag to determine whether the system is running or not
    private static boolean isRunning = true;
    // Variable to store the title of the book being processed
    private static String title;

    public static void main(String[] args) {
        // Display Welcome message when program runs for the first time
        System.out.println("=== Library Management System ===");

        // Show the main menu repeately until user exits
        while(isRunning) {
            // Display the main menu options
            displayMainMenu();

            // Process user input
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> searchBook();
                case 6 -> library.displayBooks();
                case 7 -> exitSystem();
                default -> System.out.println("Invalid choice, please enter a valid option.");
            }
        }
        // Close the scanner when the program ends
        scanner.close();
    }

    //Display the main menu options
    private static void displayMainMenu() {
        System.out.println("\nMain menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book");
        System.out.println("6. Display Available Books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new book to the library
    private static void addBook() {
        // Prompt user to enter book information
        System.out.print("Enter title and author of the book. (Separate them with ','): ");
        scanner = new Scanner(System.in);
        String author;
        String bookInformation = scanner.nextLine();
        String[] bookInfoArray = bookInformation.split(",");

        // Validate input format
        if (bookInfoArray.length != 2) {
            // Display error message for invalid input format
            message.error("Invalid input format. Please enter title and author separated by ','.");
            return;
        }

        // Create a new book instance and add it to the library
        title = bookInfoArray[0].trim();
        author = bookInfoArray[1].trim();

        // New instance of the Book class
        Book book = new Book(title, author);
        library.addBook(book);
    }

    // Method to remove a book from the library
    private static void removeBook() {
        // Prompt user to enter the title of the book to be removed
        System.out.print("Enter the name of the book you want to remove: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();

        // Remove the specified book from the library
        library.removeBook(title);
    }

    // Method to borrow a book from the library
    private static void borrowBook() {
        // Prompt user to enter the title of the book to be borrowed
        System.out.print("Enter the title of the book you want to borrow: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();

        // Borrow the specified book from the library
        library.borrowBook(title);
    }

    // Method to return a book to the library
    private static void returnBook() {
        // Prompt user to enter the title of the book to be returned
        System.out.print("Enter the title of the book you want to return: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();

        // Return the specified book to the library
        library.returnBook(title);
    }

    // Method to search for a book in the library
    private static void searchBook() {
        System.out.print("Enter the title of the book you want to search: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();

        // Search for the specified book in the library
        Book foundBook = library.findBook(title);

        // Display book information if found
        if (foundBook == null) return;
        message.success("ID: " + foundBook.getId() + ", Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor());
    }

    // Method to exit the system
    private static void exitSystem() {
        isRunning = false;
        System.out.println("\nExiting...");
    }
}