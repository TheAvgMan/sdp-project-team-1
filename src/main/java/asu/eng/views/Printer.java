package asu.eng.views;

public class Printer {

    public static void printMessage(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("No message to display.");
        } else {
            System.out.println(message);
        }
    }
}