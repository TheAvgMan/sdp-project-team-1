package asu.eng.controllers;


import asu.eng.models.Doctor;
import asu.eng.models.MedicalVisit;
import asu.eng.models.NormalVisit;
import asu.eng.models.Visitor;

public class Main {
    public static void main(String[] args) {
        // Create a Doctor object with ID 1 and name
        Doctor doctor = new Doctor(1, "Dr. John Doe");

        // Create a new medical visit for the doctor
        String medicalVisitDate = "2024-11-16";
        String medicalVisitTime = "10:00 AM";
        int elderId = 123; // Example Elder ID
        String medicalVisitStatus = "Scheduled";

        MedicalVisit newMedicalVisit = doctor.makeMedicalVisit(medicalVisitDate, medicalVisitTime, elderId, medicalVisitStatus);
        System.out.println("New medical visit created with ID: " + newMedicalVisit.getId());

        // Retrieve and update the medical visit
        int visitId = newMedicalVisit.getId();
        MedicalVisit retrievedVisit = doctor.getMedicalVisit(visitId);
        System.out.println("Retrieved Medical Visit: " + retrievedVisit);

        // Update the medical visit status
        String updatedStatus = "Completed";
        MedicalVisit updatedVisit = doctor.updateMedicalVisit(visitId, medicalVisitDate, medicalVisitTime, elderId, updatedStatus);
        System.out.println("Updated Medical Visit: " + updatedVisit);

        // Create a Visitor object with ID 101
        Visitor visitor = new Visitor(101);

        // Create a normal visit for the visitor
        String normalVisitDate = "2024-11-17";
        String normalVisitTime = "2:00 PM";
        int elderVisitId1 = 124; // First Elder ID for normal visit
        String visitStatus = "Pending";

        // Create the first normal visit for Elder 124
        NormalVisit newNormalVisit1 = Visitor.create(normalVisitDate, normalVisitTime, elderVisitId1, visitStatus);
        System.out.println("New normal visit created with ID: " + newNormalVisit1.getId());

        // Retrieve and update the first normal visit
        int normalVisitId1 = newNormalVisit1.getId();
        NormalVisit retrievedNormalVisit1 = visitor.getNormalVisit(normalVisitId1);
        System.out.println("Retrieved Normal Visit 1: " + retrievedNormalVisit1);

    }
}