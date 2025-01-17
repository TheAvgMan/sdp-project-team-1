package asu.eng.controllers;

import asu.eng.models.IReport;
import asu.eng.views.ReportView;

public class ReportController {
    private final ReportView reportView;

    public ReportController() {
        this.reportView = new ReportView();
    }

    public void generateAndDisplayReport(String reportType) {
        try {
            IReport report = ReportFactory.createReport(reportType);
            String reportContent = report.generateReport(); // Fetch report content as a string
            reportView.displayReport(reportContent); // Display the report using ReportView
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void generateAndDisplayReportNormalVisit() {
        generateAndDisplayReport("NormalVisit");
    }

    public void generateAndDisplayReportMedicalVisit() {
        generateAndDisplayReport("MedicalVisit");
    }
}
