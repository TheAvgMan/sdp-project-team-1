package asu.eng.controllers;

import asu.eng.models.*;
import asu.eng.views.Printer;

public class MoneyDonationUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        // Input data for the money donation
        String date = "2025-01-21";
        double amount = 1000; // Amount in USD
        int elderId = 202; // Elder ID receiving the donation
        int donatorId = 302; // Donator ID
        String type = "USD"; // Currency type

        Printer MoneyDonationPrint = new Printer();

        // Using Template Method Pattern
        MoneyDonationPrint.printMessage("Testing Money Donation with Template Method Pattern:");
        DonationTemplate moneyTemplate = new MoneyCreate();
        Donation donationUsingTemplate = moneyTemplate.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingTemplate != null) {
            MoneyDonationPrint.printMessage("Money Donation created successfully using Template Method: " + donationUsingTemplate);
        } else {
            MoneyDonationPrint.printMessage("Failed to create Money Donation using Template Method.");
        }

        // Using Strategy Pattern
        MoneyDonationPrint.printMessage("\nTesting Money Donation with Strategy Pattern:");
        DonationBehavior moneyStrategy = new MoneyDonation();
        Donation donationUsingStrategy = moneyStrategy.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingStrategy != null) {
            MoneyDonationPrint.printMessage("Money Donation created successfully using Strategy Pattern: " + donationUsingStrategy);
        } else {
            MoneyDonationPrint.printMessage("Failed to create Money Donation using Strategy Pattern.");
        }
    }
}
