package asu.eng.controllers;

import asu.eng.views.*;
import asu.eng.models.*;

public class Main {
    public static void main(String[] args) {


        // Decorater Pattern
//        DecoratorDPUsecase decoraterDPUseCase = new DecoratorDPUsecase();
//        decoraterDPUseCase.main();
//
//        try {
//            // Step 1: Initialize MongoDB Users
//            System.out.println("Initializing Users...");
//
//            // Clean existing users to avoid duplicates (Optional)
////            User.deleteUser(1);
////            User.deleteUser(2);
//
//            // Create new users
//            User.createUser(1, "Dr. Alice");
//            User.createUser(2, "Bob");
//
//            // Step 2: Initialize Donation Behaviors
//            DonationBehavior medicineDonationBehavior = new MedicineDonation();
//            DonationBehavior moneyDonationBehavior = new MoneyDonation();
//
//            // Step 3: Initialize Receipt Generators
//            IReceiptGenerator medicineReceiptGenerator = new MedicineDonationReceiptAdapter();
//            IReceiptGenerator moneyReceiptGenerator = new MoneyDonationReceiptAdapter();
//
//            // Step 4: Create Donations
//            System.out.println("Creating Donations...");
//            Donation medDonation1 = medicineDonationBehavior.createDonation("2025-01-15", 50.0, 101, 1001, "Pain Killers");
//            Donation moneyDonation1 = moneyDonationBehavior.createDonation("2025-01-16", 200.0, 102, 1002, "Sterling Pound");
//
//
//            if (medDonation1 != null && moneyDonation1 != null) {
//                System.out.println("\nGenerating Receipts...");
//                System.out.println(medicineReceiptGenerator.generateReceipt(medDonation1));
//                System.out.println(moneyReceiptGenerator.generateReceipt(moneyDonation1));
//
//                // Step 5: Update Donations
//                System.out.println("\nUpdating Donations...");
//                Donation updatedMedDonation = medicineDonationBehavior.updateDonation(
//                        medDonation1.getDonationId(), "2025-01-20", 75.0, 101, "Updated Pain Killers"
//                );
//                Donation updatedMoneyDonation = moneyDonationBehavior.updateDonation(
//                        moneyDonation1.getDonationId(), "2025-01-21", 250.0, 102, "Updated Sterling Pound"
//                );
//
//                if (updatedMedDonation != null && updatedMoneyDonation != null) {
//                    System.out.println("\nGenerating Updated Receipts...");
//                    System.out.println(medicineReceiptGenerator.generateReceipt(updatedMedDonation));
//                    System.out.println(moneyReceiptGenerator.generateReceipt(updatedMoneyDonation));
//                }
//            } else {
//                System.err.println("Failed to create initial donations.");
//            }
//
//            // Step 6: Cancel Donations
//            System.out.println("\nCancelling Donations...");
//            System.out.println("Medicine Donation Cancelled: " +
//                    medicineDonationBehavior.cancelDonation(medDonation1 != null ? medDonation1.getDonationId() : null));
//            System.out.println("Money Donation Cancelled: " +
//                    moneyDonationBehavior.cancelDonation(moneyDonation1 != null ? moneyDonation1.getDonationId() : null));
//
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }












        // Factory pattern
        ReportController reportController = new ReportController();
        Printer factoryprint = new Printer();
        // Test Normal Visit
        factoryprint.printMessage("Displaying Report:");
        reportController.generateAndDisplayReportNormalVisit();
        // Test Medical Visit Report

        factoryprint.printMessage("Displaying Report:");
        reportController.generateAndDisplayReportMedicalVisit();



//        // Create a Doctor object with ID 1 and name
//        Doctor doctor = new Doctor(1, "Dr. John Doe");
//
//        // Create a new medical visit for the doctor
//        String medicalVisitDate = "2024-11-16";
//        String medicalVisitTime = "10:00 AM";
//        int elderId = 123; // Example Elder ID
//        String medicalVisitStatus = "Scheduled";
//
//        MedicalVisit newMedicalVisit = doctor.makeMedicalVisit(medicalVisitDate, medicalVisitTime, elderId, medicalVisitStatus);
//        System.out.println("New medical visit created with ID: " + newMedicalVisit.getId());
//
//        // Retrieve and update the medical visit
//        int visitId = newMedicalVisit.getId();
//        MedicalVisit retrievedVisit = doctor.getMedicalVisit(visitId);
//        System.out.println("Retrieved Medical Visit: " + retrievedVisit);
//
//        // Update the medical visit status
//        String updatedStatus = "Completed";
//        MedicalVisit updatedVisit = doctor.updateMedicalVisit(visitId, medicalVisitDate, medicalVisitTime, elderId, updatedStatus);
//        System.out.println("Updated Medical Visit: " + updatedVisit);
//
//        // Create a Visitor object with ID 101
//        Visitor visitor = new Visitor(101);
//
//        // Create a normal visit for the visitor
//        String normalVisitDate = "2024-11-17";
//        String normalVisitTime = "2:00 PM";
//        int elderVisitId1 = 124; // First Elder ID for normal visit
//        String visitStatus = "Pending";
//
//        // Create the first normal visit for Elder 124
//        NormalVisit newNormalVisit1 = Visitor.create(normalVisitDate, normalVisitTime, elderVisitId1, visitStatus);
//        System.out.println("New normal visit created with ID: " + newNormalVisit1.getId());
//
//        // Retrieve and update the first normal visit
//        int normalVisitId1 = newNormalVisit1.getId();
//        NormalVisit retrievedNormalVisit1 = visitor.getNormalVisit(normalVisitId1);
//        System.out.println("Retrieved Normal Visit 1: " + retrievedNormalVisit1);
//
//        // Update the first normal visit status
//        String updatedNormalVisitStatus1 = "Completed";
//        NormalVisit updatedNormalVisit1 = visitor.updateNormalVisit(normalVisitId1, normalVisitDate, normalVisitTime, elderVisitId1, updatedNormalVisitStatus1);
//        System.out.println("Updated Normal Visit 1: " + updatedNormalVisit1);
//
//        // Create a second normal visit for another elder (Elder 125)
//        int elderVisitId2 = 125; // Second Elder ID for normal visit
//
//        // Create the second normal visit for Elder 125
//        NormalVisit newNormalVisit2 = visitor.create(normalVisitDate, normalVisitTime, elderVisitId2, visitStatus);
//        System.out.println("New normal visit created with ID: " + newNormalVisit2.getId());
//
//        // Retrieve and update the second normal visit
//        int normalVisitId2 = newNormalVisit2.getId();
//        NormalVisit retrievedNormalVisit2 = visitor.getNormalVisit(normalVisitId2);
//        System.out.println("Retrieved Normal Visit 2: " + retrievedNormalVisit2);
//
//        // Update the second normal visit status
//        String updatedNormalVisitStatus2 = "Completed";
//        NormalVisit updatedNormalVisit2 = visitor.updateNormalVisit(normalVisitId2, normalVisitDate, normalVisitTime, elderVisitId2, updatedNormalVisitStatus2);
//        System.out.println("Updated Normal Visit 2: " + updatedNormalVisit2);
    }
}