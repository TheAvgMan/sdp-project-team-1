<?php
class AdminEventView {

    // Function to format the date to dd-mm-yyyy
    private function formatDate($date) {
        return date('d-m-Y', strtotime($date));
    }

    // Display the admin page with a table for managing events
    public function display() {
        // Output the <head> section with the link to the CSS file
        echo '<!DOCTYPE html>';
        echo '<html lang="en">';
        echo '<head>';
        echo '<meta charset="UTF-8">';
        echo '<meta name="viewport" content="width=device-width, initial-scale=1.0">';
        echo '<title>Manage Events</title>';
        
        // Link to the external CSS file
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the CSS file
        
        echo '</head>';
        
        // Output the body content
        echo '<body>';
        
        echo '<h2>Manage Events</h2>';
        
        // Flex container to align the table (no form on the right)
        echo '<div class="table-container">';
        
        // Table for displaying event data (added columns for Time and Notes)
        echo '<table>';
        echo '<tr><th>Event ID</th><th>Name</th><th>Date</th><th>Time</th><th>Notes</th><th>Actions</th></tr>';
        
        // Example static rows with formatted date
        echo '<tr><td>1</td><td>Community Gathering</td><td>' . $this->formatDate('2024-12-01') . '</td><td>10:00 AM</td><td>Networking event</td>
            <td>
                <button onclick="openModal(1, \'Community Gathering\', \'2024-12-01\', \'10:00 AM\', \'Networking event\')">Edit</button>
                <button onclick="deleteEvent(1)">Delete</button>
            </td></tr>';
        
        echo '<tr><td>2</td><td>Health Check-up</td><td>' . $this->formatDate('2024-12-05') . '</td><td>2:00 PM</td><td>Free health checks</td>
            <td>
                <button onclick="openModal(2, \'Health Check-up\', \'2024-12-05\', \'2:00 PM\', \'Free health checks\')">Edit</button>
                <button onclick="deleteEvent(2)">Delete</button>
            </td></tr>';
        
        echo '</table>';
        echo '</div>';  // Close the table container
        
        // Event Modal Form (Hidden by default)
        echo '<div id="eventModal">
            <div class="modal-content" style="width: 80%; max-width: 600px; padding: 20px;">
                <span class="close" onclick="closeModal()">&times;</span>
                <h3>Event Form</h3>
                <form onsubmit="event.preventDefault(); saveEvent();">
                    <input type="hidden" id="eventId" name="eventId">
                    
                    <label for="eventName">Name:</label>
                    <input type="text" id="eventName" name="eventName" style="width: 100%;" required><br>
                    
                    <label for="eventDate">Date:</label>
                    <input type="date" id="eventDate" name="eventDate" style="width: 100%;" value="2024-12-01" required><br> <!-- This will still use yyyy-mm-dd format for input -->
                    
                    <label for="eventTime">Time:</label>
                    <input type="time" id="eventTime" name="eventTime" style="width: 100%;" required><br>
                    
                    <label for="eventNotes">Notes:</label><br>
                    <textarea id="eventNotes" name="eventNotes" rows="4" style="width: 100%;" required></textarea><br>
                    
                    <button type="submit">Done</button>
                </form>
            </div>
        </div>';
        
        echo '</body>';
        echo '</html>';
    }

    // Methods for managing events (to be implemented with actual logic)
    public function addEvent() {
        echo "Displaying add event form.";
    }

    public function createEvent($name, $date) {
        echo "Event '$name' on date $date created.";
    }

    public function editEvent($eventId) {
        echo "Displaying edit form for Event ID: $eventId";
    }

    public function updateEvent($eventId, $name, $date) {
        echo "Event ID $eventId updated to name '$name',  date $date.";
    }

    public function deleteEvent($eventId) {
        echo "Event ID $eventId deleted.";
    }
}

// Example usage
$adminEvent = new AdminEventView();
$adminEvent->display();
?>
