package asu.eng.controllers;

import asu.eng.views.*;
import asu.eng.models.*;

public class Main {
    public static void main(String[] args) {

        // MoneyDonationUsecase Test
//        MoneyDonationUsecase moneyDonationUsecase=new MoneyDonationUsecase();
//        moneyDonationUsecase.main();

        // State Pattern Test ********************************
//        StateDPUsecase stateTest = new StateDPUsecase();
//        stateTest.main();



        // Iterator Test ***********************
//        IteratorDPUsecase usecase = new IteratorDPUsecase();
//        // Create Elder objects
//        Elder elder1 = new Elder(1, "John Doe");
//        Elder elder2 = new Elder(2, "Jane Smith");
//        // Add elders to the collection
//        usecase.addElders(elder1, elder2);
//
//        // Example visit ID (replace with an actual ID from your system)
//        String visitId = "678a459c998293d8be6a3e90";
//
//        // Send the NormalVisit by visit ID
//        usecase.sendNormalVisit(visitId);



        // Facade Export to excel ********************************
//        Printer facadeprint = new Printer();
//        EventsExportUseCase facadetest= new EventsExportUseCase(facadeprint);
//        facadetest.exportEventsToExcel();

       // Command Pattern Test ***********************************
//        Doctor doctor = new Doctor(1, "Dr. Smith");
//        Scheduler scheduler = new Scheduler();
//
//        // Create a medical visit
//        ICommand createVisit = new CreateMedicalVisitCommand(doctor, "2025-01-01", "10:00", "Pending", 101);
//        scheduler.takeCommand(createVisit);
//
//        // Cancel a medical visit
//        ICommand cancelVisit = new CancelMedicalVisitCommand(doctor, "678a8c4a6d80101fb4efc5b0");
//        scheduler.takeCommand(cancelVisit);
//
//        // Execute all commands
//        scheduler.executeCommands();




        // Adapter Pattern ***********************
//        AdapterDPUsecase adapterDPUsecasetest=new AdapterDPUsecase();
//        adapterDPUsecasetest.main();


        // Factory pattern  ***********************************************
//        ReportController reportController = new ReportController();
//        Printer factoryprint = new Printer();
//        // Test Normal Visit
//        factoryprint.printMessage("Displaying Report:");
//        reportController.generateAndDisplayReportNormalVisit();
//        // Test Medical Visit Report
//
//        factoryprint.printMessage("Displaying Report:");
//        reportController.generateAndDisplayReportMedicalVisit();



        // Decorater Pattern ***********************************************
//        DecoratorDPUsecase decoraterDPUseCase = new DecoratorDPUsecase();
//        decoraterDPUseCase.main();
//







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