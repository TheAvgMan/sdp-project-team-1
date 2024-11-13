<?php
class AdminDonations {

    // Display the admin page with a table for managing donations
    public function display() {
        // Output the <head> section with the link to the CSS file
        echo '<!DOCTYPE html>';
        echo '<html lang="en">';
        echo '<head>';
        echo '<meta charset="UTF-8">';
        echo '<meta name="viewport" content="width=device-width, initial-scale=1.0">';
        echo '<title>Manage Donations</title>';
        
        // Link to the external CSS file
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the external CSS file
        
        echo '</head>';
        
        // Output the body content
        echo '<body>';
        
        echo '<h2>Manage Donations</h2>';
        
        // Flex container to align the table on the left and the form on the right
        echo '<div style="display: flex; justify-content: space-between; width: 100%;">';

        // Table for displaying donation data
        echo '<div class="table-container">';
        echo '<table>';
        echo '<tr><th>Donation ID</th><th>Donation Type</th><th>Amount</th><th>Actions</th></tr>';
        
        // Example static rows (replace these with dynamic data in real usage)
        echo '<tr><td>1</td><td>Medical</td><td>$100</td><td>
            <button onclick="openModal(1, \'Medical\', \'$100\')">Edit</button>
            <button onclick="deleteDonation(1)">Delete</button>
        </td></tr>';
        
        echo '<tr><td>2</td><td>Food</td><td>$50</td><td>
            <button onclick="openModal(2, \'Food\', \'$50\')">Edit</button>
            <button onclick="deleteDonation(2)">Delete</button>
        </td></tr>';
        
        echo '</table>';
        echo '</div>';  // Close the table container
        
        // Form for adding/editing donations (on the right side)
        echo '<div class="form-container">';
        echo '<h3>Add/Edit Donation</h3>';
        echo '<form id="donationForm" onsubmit="event.preventDefault(); saveDonation();">';
        echo '<input type="hidden" id="donationId" name="donationId">';
        echo '<label for="donationType">Donation Type:</label>';
        echo '<input type="text" id="donationType" name="donationType" required><br>';
        echo '<label for="donationAmount">Amount:</label>';
        echo '<input type="text" id="donationAmount" name="donationAmount" required><br>';
        echo '<button type="submit">Done</button>';
        echo '</form>';
        echo '</div>';  // Close the form container
        
        echo '</div>';  // Close the flex container
        
        // Donation Modal Form (Hidden by default)
        echo '<div id="donationModal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <h3>Donation Form</h3>
                <form onsubmit="event.preventDefault(); saveDonation();">
                    <input type="hidden" id="donationId" name="donationId">
                    <label for="donationType">Donation Type:</label>
                    <input type="text" id="donationType" name="donationType" required><br>
                    <label for="donationAmount">Amount:</label>
                    <input type="text" id="donationAmount" name="donationAmount" required><br>
                    <button type="submit">Done</button>
                </form>
            </div>
        </div>';
        
        echo '</body>';
        echo '</html>';
    }

    // Methods for managing donations (to be implemented with actual logic)
    public function addDonation() {
        echo "Displaying add donation form.";
    }

    public function createDonation($type, $amount) {
        echo "Donation of type '$type' and amount $amount created.";
    }

    public function editDonation($donationId) {
        echo "Displaying edit form for Donation ID: $donationId";
    }

    public function updateDonation($donationId, $type, $amount) {
        echo "Donation ID $donationId updated to type '$type' with amount $amount.";
    }

    public function deleteDonation($donationId) {
        echo "Donation ID $donationId deleted.";
    }
}

// Example usage
$adminDonations = new AdminDonations();
$adminDonations->display();
?>
