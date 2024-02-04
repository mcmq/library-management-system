/**
 * This class provides methods for displaying colorized messages in the console.
 * It uses ANSI escape codes for color formatting.
 * */
public class Message {
    // ANSI escape codes for color formatting.
    final private String reset = "\u001B[0m";

    /**
     * Displays an error message in red color.
     * @param message The error message to be displayed.
     */
    public void error(String message) {
        // ANSI escape code for red color
        String red = "\u001B[31m";
        // Print message in red color
        System.out.println(red + message + reset);
    }

    /**
     * Displays a success message in green color.
     * @param message The success message to be displayed.
     */
    public void success(String message) {
        // ANSI escape code for green color
        String green = "\u001B[32m";
        // Print message in green color
        System.out.println(green + message + reset);
    }
}
