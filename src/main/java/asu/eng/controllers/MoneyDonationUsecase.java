package asu.eng.controllers;

import asu.eng.models.*;

public class MoneyDonationUsecase {

    public void testDonation() {
        // Input data for the money donation
        String date = "2025-01-21";
        double amount = 1000; // Amount in USD
        int elderId = 202; // Elder ID receiving the donation
        int donatorId = 302; // Donator ID
        String type = "USD"; // Currency type

        // Using Template Method Pattern
        System.out.println("Testing Money Donation with Template Method Pattern:");
        DonationTemplate moneyTemplate = new MoneyCreate();
        Donation donationUsingTemplate = moneyTemplate.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingTemplate != null) {
            System.out.println("Money Donation created successfully using Template Method: " + donationUsingTemplate);
        } else {
            System.out.println("Failed to create Money Donation using Template Method.");
        }

        // Using Strategy Pattern
        System.out.println("\nTesting Money Donation with Strategy Pattern:");
        DonationBehavior moneyStrategy = new MoneyDonation();
        Donation donationUsingStrategy = moneyStrategy.createDonation(date, amount, elderId, donatorId, type);

        if (donationUsingStrategy != null) {
            System.out.println("Money Donation created successfully using Strategy Pattern: " + donationUsingStrategy);
        } else {
            System.out.println("Failed to create Money Donation using Strategy Pattern.");
        }
    }
}
