public class Message {
    // ANSI escape codes for color formatting.
    final private String reset = "\u001B[0m";

    public void error(String message) {
        String red = "\u001B[31m";
        System.out.println(red + message + reset);
    }

    public void success(String message) {
        String green = "\u001B[32m";
        System.out.println(green + message + reset);
    }
}
