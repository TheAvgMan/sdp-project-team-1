package org.example;

public class Main {

    public static void main(String[] args) {
        // Test the functionality of the Elder and Event classes

        // 1. Create a new Elder
        boolean elderCreated = Elder.create("John Doe");
        System.out.println("Elder Created: " + elderCreated);

        // 2. Retrieve Elder by ID
        Elder elder = Elder.get(1);
        if (elder != null) {
            System.out.println("Retrieved Elder: " + elder);
        } else {
            System.out.println("Elder not found");
        }

        // 3. Update Elder's name
        boolean elderUpdated = Elder.update(1, "John Smith");
        System.out.println("Elder Updated: " + elderUpdated);

        // 4. Delete Elder by ID
        boolean elderDeleted = Elder.delete(1);
        System.out.println("Elder Deleted: " + elderDeleted);

        // 5. Create a new Event
        boolean eventCreated = Event.create("Community Gathering", "2024-12-01", "A community gathering for all volunteers and elders.");
        System.out.println("Event Created: " + eventCreated);

        // 6. Retrieve Event by ID
        Event event = Event.get(1);
        if (event != null) {
            System.out.println("Retrieved Event: " + event);
        } else {
            System.out.println("Event not found");
        }

        // 7. Update Event details
        boolean eventUpdated = Event.update(1, "Annual Community Gathering", "2024-12-05", "An annual event with activities for everyone.");
        System.out.println("Event Updated: " + eventUpdated);

        // 8. Delete Event by ID
        boolean eventDeleted = Event.delete(1);
        System.out.println("Event Deleted: " + eventDeleted);
    }
}
