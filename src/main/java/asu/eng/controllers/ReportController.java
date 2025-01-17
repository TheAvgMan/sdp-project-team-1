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
            IReport report = ReportFactory.createReport(reportType); // Use Factory to create the report
            String reportContent = fetchReportContent(report); // Generate the report content
            reportView.displayReport(reportContent); // Use View to display the report
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private String fetchReportContent(IReport report) {
        StringBuilder contentBuilder = new StringBuilder();
        report.generateReport(); 
        contentBuilder.append("Report generated successfully.");
        return contentBuilder.toString();
    }
}
