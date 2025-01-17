package asu.eng.controllers;

import asu.eng.models.*;
import asu.eng.views.Printer;

public class AdapterDPUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        Printer adapterprint = new Printer();
        adapterprint.printMessage("");

        try {
            // Step 1: Initialize MongoDB Users
            System.out.println("Initializing Users...");
            adapterprint.printMessage("Initializing Users...");
            // Clean existing users to avoid duplicates (Optional)
//            User.deleteUser(1);
//            User.deleteUser(2);

            // Create new users
            User.createUser(1, "Dr. Alice");
            User.createUser(2, "Bob");

            // Step 2: Initialize Donation Behaviors
            DonationBehavior medicineDonationBehavior = new MedicineDonation();
            DonationBehavior moneyDonationBehavior = new MoneyDonation();

            // Step 3: Initialize Receipt Generators
            IReceiptGenerator medicineReceiptGenerator = new MedicineDonationReceiptAdapter();
            IReceiptGenerator moneyReceiptGenerator = new MoneyDonationReceiptAdapter();

            // Step 4: Create Donations
            System.out.println("Creating Donations...");
            adapterprint.printMessage("Creating Donations...");
            Donation medDonation1 = medicineDonationBehavior.createDonation("2025-01-15", 50.0, 101, 1001, "Pain Killers");
            Donation moneyDonation1 = moneyDonationBehavior.createDonation("2025-01-16", 200.0, 102, 1002, "Sterling Pound");


            if (medDonation1 != null && moneyDonation1 != null) {
                adapterprint.printMessage("\nGenerating Receipts...");
                System.out.println("\nGenerating Receipts...");
                System.out.println(medicineReceiptGenerator.generateReceipt(medDonation1));
                System.out.println(moneyReceiptGenerator.generateReceipt(moneyDonation1));

                // Step 5: Update Donations
                System.out.println("\nUpdating Donations...");
                adapterprint.printMessage("\nUpdating Donations...");
                Donation updatedMedDonation = medicineDonationBehavior.updateDonation(
                        medDonation1.getDonationId(), "2025-01-20", 75.0, 101, "Updated Pain Killers"
                );
                Donation updatedMoneyDonation = moneyDonationBehavior.updateDonation(
                        moneyDonation1.getDonationId(), "2025-01-21", 250.0, 102, "Updated Sterling Pound"
                );

                if (updatedMedDonation != null && updatedMoneyDonation != null) {
                    System.out.println("\nGenerating Updated Receipts...");
                    adapterprint.printMessage("\nGenerating Updated Receipts...");
                    System.out.println(medicineReceiptGenerator.generateReceipt(updatedMedDonation));
                    System.out.println(moneyReceiptGenerator.generateReceipt(updatedMoneyDonation));
                }
            } else {
                System.err.println("Failed to create initial donations.");
                adapterprint.printMessage("Failed to create initial donations.");
            }

            // Step 6: Cancel Donations

            adapterprint.printMessage("\nCancelling Donations...");

            adapterprint.printMessage("Medicine Donation Cancelled: \"");
            boolean s1 = medicineDonationBehavior.cancelDonation(medDonation1 != null ? medDonation1.getDonationId() : null);
            // print object
            String string1;
            if(s1==true){
                adapterprint.printMessage("True");
            }else {
                adapterprint.printMessage("False");
            }

            adapterprint.printMessage("Money Donation Cancelled: ");
            boolean s2 = moneyDonationBehavior.cancelDonation(moneyDonation1 != null ? moneyDonation1.getDonationId() : null);
            if(s1==true){
                adapterprint.printMessage("True");
            }else {
                adapterprint.printMessage("False");
            }
            // print object

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
