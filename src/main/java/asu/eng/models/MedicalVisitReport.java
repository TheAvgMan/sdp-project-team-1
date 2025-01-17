package asu.eng.models;

import java.util.List;

public class MedicalVisitReport implements IReport {
    @Override
    public String generateReport() {
        StringBuilder reportContent = new StringBuilder();
        List<MedicalVisit> visits = MedicalVisit.getAllMedicalVisits();

        if (visits.isEmpty()) {
            reportContent.append("No medical visits found.");
        } else {
            for (MedicalVisit visit : visits) {
                reportContent.append(visit.toString()).append("\n");
            }
        }
        return reportContent.toString();
    }
}
