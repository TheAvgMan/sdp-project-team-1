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
        echo '<link rel="stylesheet" href="styles.css">';  // Link to the CSS file

        echo '</head>';
        // Output the body content
        echo '<body>';
        
        echo '<h2>Manage Donations</h2>';
        
        // Table container to apply scroll if the table exceeds the fixed height
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
        
        // "Add Donation" button placed at the bottom
        echo '<div style="text-align: center; margin-top: 10px;">
                <button onclick="openModal(\'\', \'\', \'\')">Add Donation</button>
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
