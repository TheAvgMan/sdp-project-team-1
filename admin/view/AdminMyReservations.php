<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Reservations</title>
    <link rel="stylesheet" href="styles.css"> <!-- External CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: space-between;
            padding: 20px;
            margin: 0;
        }

        .table-container {
            width: 60%;
            height: 65vh; /* 65% of the viewport height */
            overflow-y: auto; /* Make the table scrollable if the content overflows */
            border: 1px solid #ddd;
        }

        .form-container {
            width: 35%;
            height: 65vh;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 10px;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        button {
            padding: 6px 12px;
            margin: 4px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Modal Form Styles */
        #reservationModal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: white;
            padding: 20px;
            margin: 10% auto;
            width: 50%;
            border-radius: 5px;
        }

        .close {
            color: #aaa;
            font-size: 28px;
            font-weight: bold;
            position: absolute;
            top: 10px;
            right: 25px;
            padding: 5px;
            cursor: pointer;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

    </style>
</head>
<body>

<h2>Manage Reservations</h2>

<!-- Flex container to align the table on the left and the form on the right -->
<div style="display: flex; justify-content: space-between; width: 100%;">

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

<!-- Reservation Modal Form (Hidden by default) -->
<div id="reservationModal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h3>Reservation Form</h3>
        <form onsubmit="event.preventDefault(); saveReservation();">
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
            <button type="submit">Save</button>
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
