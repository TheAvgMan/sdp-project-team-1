package asu.eng.controllers;

import asu.eng.models.Event;
import asu.eng.models.EventExporter;
import asu.eng.views.EventExporterView;
import asu.eng.views.Printer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.nio.file.Paths;

public class EventsExportUseCase {
    private Printer view;

    public EventsExportUseCase(Printer view) {
        this.view = view;
    }

    public void exportEventsToExcel() {
        try {
            // Dynamically determine the user's downloads directory
            String userHome = System.getProperty("user.home");
            String downloadsPath = Paths.get(userHome, "Downloads", "events_export.xlsx").toString();

            // Fetch events from the model
            List<Event> events = EventExporter.getAllEvents();

            if (events.isEmpty()) {
                view.printMessage("No events to export.");
                return;
            }

            // Create Excel workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Events");

            // Add header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Name", "Date", "Description", "Volunteers", "Status"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Add data rows
            int rowNum = 1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (Event event : events) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(event.getId());
                row.createCell(1).setCellValue(event.getName());
                row.createCell(2).setCellValue(event.getDate());
                row.createCell(3).setCellValue(event.getDescription());

                // Get volunteer count from the model
                int volunteerCount = EventExporter.getVolunteerCountForEvent(event.getId());
                row.createCell(4).setCellValue(volunteerCount);

                // Calculate event status
                String status = calculateStatus(event.getDate(), formatter);
                row.createCell(5).setCellValue(status);
            }

            // Save the Excel file
            try (FileOutputStream fileOut = new FileOutputStream(downloadsPath)) {
                workbook.write(fileOut);
                view.printMessage("Events exported successfully to: " + downloadsPath);
            } finally {
                workbook.close();
            }
        } catch (IOException e) {
            view.printMessage("Error saving Excel file: " + e.getMessage());
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
