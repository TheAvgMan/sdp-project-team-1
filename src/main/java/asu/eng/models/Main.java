package asu.eng.models;

public class Main {
    public static void main(String[] args) {
        DonationBehavior moneyDonationBehavior = new MoneyDonation();

        Donation donation = moneyDonationBehavior.createDonation("2025-01-15", 50.0, 101, 1001, "USD");

        // Base receipt generator
        IReceiptGenerator baseReceipt = new MoneyDonationReceiptAdapter();

        // Decorate with VAT
        IReceiptGenerator receiptWithVAT = new WithVAT(baseReceipt, 0.20); // Adding 20% VAT

        // Decorate with Tax
        IReceiptGenerator receiptWithTax = new WithTax(baseReceipt, 0.10); // Adding 10% Tax

        // Decorate with both VAT and Tax
        IReceiptGenerator receiptWithBoth = new WithVAT(new WithTax(baseReceipt, 0.10), 0.20);

        System.out.println("Receipt with VAT:");
        System.out.println(receiptWithVAT.generateReceipt(donation));

        System.out.println("\nReceipt with Tax:");
        System.out.println(receiptWithTax.generateReceipt(donation));

        System.out.println("\nReceipt with Both VAT and Tax:");
        System.out.println(receiptWithBoth.generateReceipt(donation));

//        ------------------------------------------

//        Command Pattern test

//        User.createUser("Dr. Smith");
//        Doctor doctor = new Doctor(1);
//        doctor.appendDoctorToDatabase();
//        Elder.create(1, "Abby Gail");
//        Elder elder = Elder.get(1);
//        Scheduler scheduler = new Scheduler();
//
//// Create a medical visit
//        ICommand createVisit = new CreateMedicalVisitCommand(doctor, "2025-01-01", "10:00", "Scheduled", elder.getId());
//        scheduler.takeCommand(createVisit);
//
//// Cancel a medical visit
//        ICommand cancelVisit = new CancelMedicalVisitCommand(doctor, "visit123");
//        scheduler.takeCommand(cancelVisit);
//
//// Execute all commands
//        scheduler.executeCommands();

    }
}

