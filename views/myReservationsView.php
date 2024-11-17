<?php
class MyReservationsView {

    // Display the HTML table for My Reservations
    public function display() {
        // Output the <head> section with the link to the CSS file
        echo '<!DOCTYPE html>';
        echo '<html lang="en">';
        echo '<head>';
        echo '<meta charset="UTF-8">';
        echo '<meta name="viewport" content="width=device-width, initial-scale=1.0">';
        echo '<title>My Reservations</title>';
        
        // Link to the external CSS file
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the CSS file
        
        echo '</head>';
        
        // Output the body content
        echo '<body>';
        
        echo '<h2>My Reservations</h2>';
        
        // Table for displaying reservation data
        echo '<table>';
        echo '<tr><th>Reservation ID</th><th>Reservation Date</th><th>Status</th><th>Actions</th></tr>';
        
        // Example static row (replace with dynamic data in real usage)
        echo '<tr><td>1</td><td>2024-01-10</td><td>Confirmed</td><td>
            <button onclick="editReservation(1)">Edit</button>
            <button onclick="deleteReservation(1)">Delete</button>
        </td></tr>';
        
        // Example static row (another reservation)
        echo '<tr><td>2</td><td>2024-01-20</td><td>Pending</td><td>
            <button onclick="editReservation(2)">Edit</button>
            <button onclick="deleteReservation(2)">Delete</button>
        </td></tr>';
        
        echo '</table>';
        
        // "Add Reservation" button to simulate adding a new reservation
        echo '<button onclick="addReservation()">Add Reservation</button>';
        
        echo '</body>';
        echo '</html>';
    }

    // Placeholder for adding a new reservation
    public function add() {
        echo "Displaying add reservation form.";
    }

    // Placeholder for creating a reservation
    public function create($date, $status) {
        echo "Reservation created for date $date with status $status.";
    }

    // Placeholder for editing a reservation
    public function edit($reservationId) {
        echo "Displaying edit form for Reservation ID: $reservationId";
    }

    // Placeholder for deleting a reservation
    public function delete($reservationId) {
        echo "Reservation ID $reservationId deleted.";
    }
}

// Example usage
$view = new MyReservationsView();
$view->display();
?>
