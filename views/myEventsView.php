<?php
class MyEventsView {
    
    // Display the HTML table for My Events
    public function display() {
        // Output the <head> section with the link to the CSS file
        echo '<!DOCTYPE html>';
        echo '<html lang="en">';
        echo '<head>';
        echo '<meta charset="UTF-8">';
        echo '<meta name="viewport" content="width=device-width, initial-scale=1.0">';
        echo '<title>My Events</title>';
        
        // Link to the external CSS file
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the CSS file
        
        echo '</head>';
        
        // Output the body content
        echo '<body>';
        
        echo '<h2>My Events</h2>';
        
        // Table for displaying event data
        echo '<table>';
        echo '<tr><th>Event ID</th><th>Event Name</th><th>Date</th><th>Actions</th></tr>';
        
        // Example static row (replace with dynamic data in real usage)
        echo '<tr><td>1</td><td>Sample Event</td><td>2024-01-01</td><td>
            <button onclick="editEvent(1)">Edit</button>
            <button onclick="deleteEvent(1)">Delete</button>
        </td></tr>';
        
        // Example static row (another event)
        echo '<tr><td>2</td><td>Community Gathering</td><td>2024-02-14</td><td>
            <button onclick="editEvent(2)">Edit</button>
            <button onclick="deleteEvent(2)">Delete</button>
        </td></tr>';
        
        echo '</table>';
        
        // "Add Event" button to simulate adding a new event
        echo '<button onclick="addEvent()">Add Event</button>';
        
        echo '</body>';
        echo '</html>';
    }

    // Placeholder for adding a new event
    public function add() {
        echo "Displaying add event form.";
    }

    // Placeholder for creating an event
    public function create($name, $date) {
        echo "Event '$name' created with date $date.";
    }

    // Placeholder for editing an event
    public function edit($eventId) {
        echo "Displaying edit form for Event ID: $eventId";
    }

    // Placeholder for deleting an event
    public function delete($eventId) {
        echo "Event ID $eventId deleted.";
    }
}

// Example usage
$view = new MyEventsView();
$view->display();
?>
