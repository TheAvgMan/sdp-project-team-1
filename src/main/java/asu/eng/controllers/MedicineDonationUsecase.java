package asu.eng.controllers;

import asu.eng.models.*;
import asu.eng.views.Printer;

public class MedicineDonationUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        // Input data for the medicine donation
        String date = "2025-01-20";
        double amount = 50; // Quantity of medicine units
        int elderId = 201; // Elder ID receiving the donation
        int donatorId = 301; // Donator ID
        String type = "Medicine";
        Printer MedicineDonationPrint = new Printer();

        // Using Template Method Pattern
        MedicineDonationPrint.printMessage("Testing Medicine Donation with Template Method Pattern:");
        DonationTemplate medicineTemplate = new MedicineCreate();
        Donation donationUsingTemplate = medicineTemplate.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingTemplate != null) {
            MedicineDonationPrint.printMessage("Medicine Donation created successfully using Template Method: " + donationUsingTemplate);
        } else {
            MedicineDonationPrint.printMessage("Failed to create Medicine Donation using Template Method.");
        }

        // Using Strategy Pattern
        MedicineDonationPrint.printMessage("\nTesting Medicine Donation with Strategy Pattern:");
        DonationBehavior medicineStrategy = new MedicineDonation();
        Donation donationUsingStrategy = medicineStrategy.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingStrategy != null) {
            MedicineDonationPrint.printMessage("Medicine Donation created successfully using Strategy Pattern: " + donationUsingStrategy);
        } else {
            MedicineDonationPrint.printMessage("Failed to create Medicine Donation using Strategy Pattern.");
        }
    }
}
