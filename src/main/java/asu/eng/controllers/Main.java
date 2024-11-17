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
    }
}