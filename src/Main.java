import java.util.Scanner;

public class Main {
    // User input for the main menu
    private static Scanner scanner = new Scanner(System.in);
    // Make instance object of the library class
    final private static Library library = new Library();
    // For showing colorized messages
    final private static Message message = new Message();
    // Determining wether the system is running or not
    private static boolean isRunning = true;
    private static String title;

    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");

        // Show the Main menu every time users completes an action
        while(isRunning) {
            // Show main menu options
            mainMenu();

            // Initiate neccessary variables
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
        scanner.close();
    }

    private static void mainMenu() {
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

    private static void addBook() {
        System.out.print("Enter title and author of the book. (Separate them with ','): ");
        scanner = new Scanner(System.in);
        String author;
        String bookInformation = scanner.nextLine();
        String[] bookInfoArray = bookInformation.split(",");

        if (bookInfoArray.length != 2) {
            // Notify the user if input format is incorrect
            message.error("Invalid input format. Please enter title and author separated by ','.");
            return; // Exit the case to allow the user to enter valid data
        }
        // Book title will be the first part of the split string
        title = bookInfoArray[0].trim(); // Update title here
        // Book author will be the second part of the split string
        author = bookInfoArray[1].trim();
        // New instance of the Book class
        Book book = new Book(title, author);
        library.addBook(book);
    }

    private static void removeBook() {
        System.out.print("Enter the name of the book you want to remove: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();
        library.removeBook(title);
    }

    private static void borrowBook() {
        System.out.print("Enter the title of the book you want to borrow: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();
        library.borrowBook(title);
    }

    private static void returnBook() {
        System.out.print("Enter the title of the book you want to return: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();
        library.returnBook(title);
    }

    private static void searchBook() {
        System.out.print("Enter the title of the book you want to search: ");
        scanner = new Scanner(System.in);
        title = scanner.nextLine();
        Book foundBook = library.findBook(title);

        if (foundBook == null) return;
        message.success("ID: " + foundBook.getId() + ", Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor());
    }

    private static void exitSystem() {
        isRunning = false;
        System.out.println("\nExiting...");
    }
}