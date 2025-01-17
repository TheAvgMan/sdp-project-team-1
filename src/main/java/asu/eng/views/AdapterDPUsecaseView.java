package asu.eng.views;

import asu.eng.models.*;
import asu.eng.controllers.*;

public class AdapterDPUsecaseView {

    // Function to generate and display receipt for medicine donation
    public void displayMedicineDonationReceipt(IReceiptGenerator medicineReceiptGenerator, Donation medDonation) {
        if (medDonation != null) {
            String receipt = medicineReceiptGenerator.generateReceipt(medDonation);
            System.out.println("Medicine Donation Receipt:");
            System.out.println(receipt);
        } else {
            System.out.println("No medicine donation available to generate receipt.");
        }
    }

    // Function to generate and display receipt for money donation
    public void displayMoneyDonationReceipt(IReceiptGenerator moneyReceiptGenerator, Donation moneyDonation) {
        if (moneyDonation != null) {
            String receipt = moneyReceiptGenerator.generateReceipt(moneyDonation);
            System.out.println("Money Donation Receipt:");
            System.out.println(receipt);
        } else {
            System.out.println("No money donation available to generate receipt.");
        }
    }

    // Function to generate and display updated receipt for medicine donation
    public void displayUpdatedMedicineDonationReceipt(IReceiptGenerator medicineReceiptGenerator, Donation updatedMedDonation) {
        if (updatedMedDonation != null) {
            String receipt = medicineReceiptGenerator.generateReceipt(updatedMedDonation);
            System.out.println("Updated Medicine Donation Receipt:");
            System.out.println(receipt);
        } else {
            System.out.println("No updated medicine donation available to generate receipt.");
        }
    }

    // Function to generate and display updated receipt for money donation
    public void displayUpdatedMoneyDonationReceipt(IReceiptGenerator moneyReceiptGenerator, Donation updatedMoneyDonation) {
        if (updatedMoneyDonation != null) {
            String receipt = moneyReceiptGenerator.generateReceipt(updatedMoneyDonation);
            System.out.println("Updated Money Donation Receipt:");
            System.out.println(receipt);
        } else {
            System.out.println("No updated money donation available to generate receipt.");
        }
    }
}
