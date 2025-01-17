package asu.eng.controllers;

import asu.eng.models.*;

public class MedicineDonationUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        // Input data for the medicine donation
        String date = "2025-01-20";
        double amount = 50; // Quantity of medicine units
        int elderId = 201; // Elder ID receiving the donation
        int donatorId = 301; // Donator ID
        String type = "Medicine";

        // Using Template Method Pattern
        System.out.println("Testing Medicine Donation with Template Method Pattern:");
        DonationTemplate medicineTemplate = new MedicineCreate();
        Donation donationUsingTemplate = medicineTemplate.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingTemplate != null) {
            System.out.println("Medicine Donation created successfully using Template Method: " + donationUsingTemplate);
        } else {
            System.out.println("Failed to create Medicine Donation using Template Method.");
        }

        // Using Strategy Pattern
        System.out.println("\nTesting Medicine Donation with Strategy Pattern:");
        DonationBehavior medicineStrategy = new MedicineDonation();
        Donation donationUsingStrategy = medicineStrategy.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingStrategy != null) {
            System.out.println("Medicine Donation created successfully using Strategy Pattern: " + donationUsingStrategy);
        } else {
            System.out.println("Failed to create Medicine Donation using Strategy Pattern.");
        }
    }
}
