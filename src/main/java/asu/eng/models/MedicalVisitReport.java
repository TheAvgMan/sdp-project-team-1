package asu.eng.models;
import java.util.List;
import java.util.ArrayList;

public class MedicalVisitReport implements IReport {
    @Override
    public void generateReport() {
        System.out.println("Generating Medical Visit Report...");
        List<MedicalVisit> visits = MedicalVisit.getAllMedicalVisits();

        if (visits.isEmpty()) {
            System.out.println("No medical visits found.");
        } else {
            for (MedicalVisit visit : visits) {
                System.out.println(visit); // Use the toString() method for formatting
            }
        }
    }
}
