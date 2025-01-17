package asu.eng.controllers;

import asu.eng.models.IReport;
import asu.eng.models.NormalVisitReport;
import asu.eng.models.MedicalVisitReport;

public class ReportFactory {
    public static IReport createReport(String reportType) {
        if ("NormalVisit".equalsIgnoreCase(reportType)) {
            return new NormalVisitReport();
        } else if ("MedicalVisit".equalsIgnoreCase(reportType)) {
            return new MedicalVisitReport();
        }
        throw new IllegalArgumentException("Invalid report type: " + reportType);
    }
}
