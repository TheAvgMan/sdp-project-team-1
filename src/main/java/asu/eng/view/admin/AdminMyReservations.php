<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Reservations</title>
    <link rel="stylesheet" href="styles.css"> <!-- External CSS file -->
</head>
<body>

<h2>Manage Reservations</h2>

<!-- Flex container to align the table on the left and the form on the right -->
<div class="table-form-container">

    <!-- Table for displaying reservation data -->
    <div class="table-container">
        <table>
            <tr><th>Reservation ID</th><th>Reservation Name</th><th>Reservation Date</th><th>Status</th><th>Actions</th></tr>
            <tr>
                <td>1</td>
                <td>Sample Event</td>
                <td>2024-01-10</td>
                <td>Confirmed</td>
                <td>
                    <button onclick="openModal(1, 'Sample Event', '2024-01-10', 'Confirmed')">Edit</button>
                    <button onclick="deleteReservation(1)">Delete</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Another Event</td>
                <td>2024-01-12</td>
                <td>Pending</td>
                <td>
                    <button onclick="openModal(2, 'Another Event', '2024-01-12', 'Pending')">Edit</button>
                    <button onclick="deleteReservation(2)">Delete</button>
                </td>
            </tr>
        </table>
    </div>

    <!-- Form for adding/editing reservations (on the right side) -->
    <div class="form-container">
        <h3>Add/Edit Reservation</h3>
        <form id="reservationForm" onsubmit="event.preventDefault(); saveReservation();">
            <input type="hidden" id="reservationId" name="reservationId">
            <label for="reservationName">Reservation Name:</label>
            <input type="text" id="reservationName" name="reservationName" required><br>
            <label for="reservationDate">Reservation Date:</label>
            <input type="date" id="reservationDate" name="reservationDate" required><br>
            <label for="reservationStatus">Status:</label>
            <select id="reservationStatus" name="reservationStatus" required>
                <option value="Confirmed">Confirmed</option>
                <option value="Pending">Pending</option>
            </select><br>
            <button type="submit">Save Reservation</button>
        </form>
    </div>

</div>

<script>
    // Function to open the modal and populate it with reservation data
    function openModal(reservationId = '', reservationName = '', reservationDate = '', reservationStatus = '') {
        document.getElementById('reservationModal').style.display = 'block';
        document.getElementById('reservationId').value = reservationId;
        document.getElementById('reservationName').value = reservationName;
        document.getElementById('reservationDate').value = reservationDate;
        document.getElementById('reservationStatus').value = reservationStatus;
    }

    // Function to close the modal
    function closeModal() {
        document.getElementById('reservationModal').style.display = 'none';
    }

    // Function to save the reservation (this can send an AJAX request to save the data)
    function saveReservation() {
        var reservationId = document.getElementById('reservationId').value;
        var reservationName = document.getElementById('reservationName').value;
        var reservationDate = document.getElementById('reservationDate').value;
        var reservationStatus = document.getElementById('reservationStatus').value;
        
        console.log('Saving Reservation:', reservationId, reservationName, reservationDate, reservationStatus);
        
        // Close the modal after saving
        closeModal();
    }

    // Function to delete a reservation (can be connected to a backend deletion logic)
    function deleteReservation(reservationId) {
        console.log('Deleting Reservation ID:', reservationId);
        // Implement backend delete logic here (AJAX request, etc.)
    }
</script>

</body>
</html>
