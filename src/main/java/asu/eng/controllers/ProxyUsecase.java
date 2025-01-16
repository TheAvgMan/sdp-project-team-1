package asu.eng.controllers;

import asu.eng.models.Event;
import asu.eng.models.EventManager;

public class ProxyUsecase {
    public void testProxyPattern() {
        System.out.println("=== Proxy Design Pattern Test ===");

        // Initialize the EventManager (uses EventProxy internally)
        EventManager eventManager = new EventManager();

        // Create an event
        System.out.println("\nCreating an event...");
        boolean created = eventManager.createEvent(1, "Annual Meeting", "2025-02-15", "An important yearly meeting.");
        if (created) {
            System.out.println("Event created successfully.");
        } else {
            System.out.println("Failed to create the event.");
        }

        // Fetch the event (first time, from the database)
        System.out.println("\nFetching the event (should hit the database)...");
        Event event = eventManager.getEventById(1);
        if (event != null) {
            System.out.println("Fetched event: " + event);
        } else {
            System.out.println("Event not found.");
        }

        // Fetch the event again (this time, from the cache)
        System.out.println("\nFetching the event again (should hit the cache)...");
        event = eventManager.getEventById(1);
        if (event != null) {
            System.out.println("Fetched event: " + event);
        } else {
            System.out.println("Event not found.");
        }

        // Update the event
        System.out.println("\nUpdating the event...");
        boolean updated = eventManager.updateEvent(1, "Annual Meeting Updated", "2025-03-01", "Updated yearly meeting.");
        if (updated) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Failed to update the event.");
        }

        // Fetch the updated event (from cache, should reflect the update)
        System.out.println("\nFetching the updated event (should hit the cache)...");
        event = eventManager.getEventById(1);
        if (event != null) {
            System.out.println("Fetched updated event: " + event);
        } else {
            System.out.println("Event not found.");
        }

        // Delete the event
        System.out.println("\nDeleting the event...");
        boolean deleted = eventManager.deleteEvent(1);
        if (deleted) {
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Failed to delete the event.");
        }

        // Try fetching the deleted event (should not be found in cache or database)
        System.out.println("\nFetching the deleted event...");
        event = eventManager.getEventById(1);
        if (event != null) {
            System.out.println("Fetched event: " + event);
        } else {
            System.out.println("Event not found (as expected).");
        }
    }
}