package asu.eng.models;

import java.util.List;

public class NormalVisitReport implements IReport {
    @Override
    public String generateReport() {
        StringBuilder reportContent = new StringBuilder();
        List<NormalVisit> visits = NormalVisit.getAllNormalVisits();

        if (visits.isEmpty()) {
            reportContent.append("No normal visits found.");
        } else {
            for (NormalVisit visit : visits) {
                reportContent.append(visit.toString()).append("\n");
            }
        }
        return reportContent.toString();
    }
}
