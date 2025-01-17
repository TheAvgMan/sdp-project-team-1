package asu.eng.models;

import java.util.List;

public class NormalVisitReport implements IReport {
    @Override
    public void generateReport() {
        System.out.println("Generating Normal Visit Report...");
        List<NormalVisit> visits = NormalVisit.getAllNormalVisits();

        if (visits.isEmpty()) {
            System.out.println("No normal visits found.");
        } else {
            for (NormalVisit visit : visits) {
                System.out.println(visit); // Use the toString() method for formatting
            }
        }
    }
}
