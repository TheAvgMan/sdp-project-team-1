<?php
class AdminElderView {

    // Display the admin page with a table for managing elders
    public function display() {
        // Output the <head> section with the link to the CSS file
        echo '<!DOCTYPE html>';
        echo '<html lang="en">';
        echo '<head>';
        echo '<meta charset="UTF-8">';
        echo '<meta name="viewport" content="width=device-width, initial-scale=1.0">';
        echo '<title>Manage Elders</title>';
        
        // Link to the external CSS file
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the CSS file
        
        echo '</head>';
        
        // Output the body content
        echo '<body>';
        
        echo '<h2>Manage Elders</h2>';
        
        // Flex container to align the table (no form on the right)
        echo '<div class="table-container">';
        
        // Table for displaying elder data
        echo '<table>';
        echo '<tr><th>Elder ID</th><th>Name</th><th>Age</th><th>Room Number</th><th>Actions</th></tr>';
        
        // Example static rows (replace these with dynamic data in real usage)
        echo '<tr><td>1</td><td>John Doe</td><td>80</td><td>101</td><td>
            <button onclick="openModal(1, \'John Doe\', 80, 101)">Edit</button>
            <button onclick="deleteElder(1)">Delete</button>
        </td></tr>';
        
        echo '<tr><td>2</td><td>Jane Smith</td><td>75</td><td>102</td><td>
            <button onclick="openModal(2, \'Jane Smith\', 75, 102)">Edit</button>
            <button onclick="deleteElder(2)">Delete</button>
        </td></tr>';
        
        echo '</table>';
        echo '</div>';  // Close the table container
        
        // Elder Modal Form (Hidden by default)
        echo '<div id="elderModal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <h3>Elder Form</h3>
                <form onsubmit="event.preventDefault(); saveElder();">
                    <input type="hidden" id="elderId" name="elderId">
                    <label for="elderName">Name:</label>
                    <input type="text" id="elderName" name="elderName" required><br>
                    <label for="elderAge">Age:</label>
                    <input type="number" id="elderAge" name="elderAge" required><br>
                    <label for="elderRoom">Room Number:</label>
                    <input type="text" id="elderRoom" name="elderRoom" required><br>
                    <button type="submit">Done</button>
                </form>
            </div>
        </div>';
        
        echo '</body>';
        echo '</html>';
    }

    // Methods for managing elders (to be implemented with actual logic)
    public function addElder() {
        echo "Displaying add elder form.";
    }

    public function createElder($name, $age, $room) {
        echo "Elder '$name' aged $age, room number $room created.";
    }

    public function editElder($elderId) {
        echo "Displaying edit form for Elder ID: $elderId";
    }

    public function updateElder($elderId, $name, $age, $room) {
        echo "Elder ID $elderId updated to name '$name', age $age, room $room.";
    }

    public function deleteElder($elderId) {
        echo "Elder ID $elderId deleted.";
    }
}

// Example usage
$adminElder = new AdminElderView();
$adminElder->display();
?>
