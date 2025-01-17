package asu.eng.controllers;

import asu.eng.models.*;

import java.util.List;

public class ObserverDPUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        // Create the EventManager (Subject)
        EventManager eventManager = new EventManager();

        // Create Observers (Doctor and Volunteer)
        Doctor doctor = new Doctor(1, "Dr. Alice");
        Volunteer volunteer = new Volunteer(new User(2));

        // Register Observers to the EventManager
        eventManager.registerObserver(doctor);
        eventManager.registerObserver(volunteer);

        // Create new events and notify observers
        System.out.println("Creating events...");
        eventManager.createEvent(101, "Health Checkup", "2025-01-15", "Free health checkup for seniors.");
        eventManager.createEvent(102, "Blood Donation Camp", "2025-02-10", "Community blood donation drive.");

        // Retrieve and display all events
        System.out.println("\nAll events in the system:");
        List<Event> allEvents = eventManager.getAllEvents();
        for (Event event : allEvents) {
            System.out.println(event);
        }

        // Retrieve a specific event by ID
        System.out.println("\nRetrieving event with ID 101:");
        Event event = eventManager.getEventById(101);
        if (event != null) {
            System.out.println(event);
        } else {
            System.out.println("Event not found.");
        }

        // Update an event and notify observers
        System.out.println("\nUpdating event with ID 101...");
        boolean updateStatus = eventManager.updateEvent(101, "Health Checkup", "2025-01-20", "Updated details for the health checkup.");
        if (updateStatus) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Failed to update event.");
        }

        // Delete an event and notify observers
        System.out.println("\nDeleting event with ID 102...");
        boolean deleteStatus = eventManager.deleteEvent(102);
        if (deleteStatus) {
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Failed to delete event.");
        }

        // Retrieve all events after deletion
        System.out.println("\nAll events after deletion:");
        allEvents = eventManager.getAllEvents();
        for (Event e : allEvents) {
            System.out.println(e);
        }

        // Remove an observer and notify remaining observers
        System.out.println("\nRemoving volunteer observer...");
        eventManager.removeObserver(volunteer);

        System.out.println("Creating a new event to test observer notifications...");
        eventManager.createEvent(103, "Yoga Workshop", "2025-03-05", "Yoga workshop for community wellness.");

        // End of test
        System.out.println("\nTest completed.");
    }
}
