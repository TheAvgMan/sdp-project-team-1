package asu.eng.controllers;

import asu.eng.models.Singleton;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventsExportUseCase {
    // Export event data to an Excel file
    public void exportEventsToExcel(String filePath) {
        // Step 1: Fetch all events from MongoDB
        MongoCollection<Document> eventCollection = Singleton.getInstance().getDatabase().getCollection("events");
        MongoCursor<Document> cursor = eventCollection.find().iterator();

        // Step 2: Prepare Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Events");

        // Step 3: Add header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Name", "Date", "Description", "Volunteers", "Status"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Step 4: Populate rows with event data
        int rowNum = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (cursor.hasNext()) {
            Document eventDoc = cursor.next();

            // Parse event data
            int id = eventDoc.getInteger("id");
            String name = eventDoc.getString("name");
            String date = eventDoc.getString("date");
            String description = eventDoc.getString("description");

            // Create a new row in the sheet
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(date);
            row.createCell(3).setCellValue(description);

            // Fetch volunteer reservations for this event
            int volunteerCount = (int) Singleton.getInstance()
                    .getDatabase()
                    .getCollection("volunteerReservations")
                    .countDocuments(new Document("eventId", id));
            row.createCell(4).setCellValue(volunteerCount);

            // Calculate status
            String status = calculateStatus(date, formatter);
            row.createCell(5).setCellValue(status);
        }

        // Step 5: Save the Excel file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Events exported successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.err.println("Error closing workbook: " + e.getMessage());
            }
        }
    }

    // Helper method to calculate event status
    private String calculateStatus(String eventDate, DateTimeFormatter formatter) {
        LocalDate date = LocalDate.parse(eventDate, formatter);
        LocalDate today = LocalDate.now();

        if (date.isAfter(today)) {
            return "Scheduled";
        } else if (date.isEqual(today)) {
            return "Ongoing";
        } else {
            return "Completed";
        }
    }
}
