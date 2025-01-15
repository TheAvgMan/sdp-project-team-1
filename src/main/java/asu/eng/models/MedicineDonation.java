package asu.eng.models;
public class MedicineDonation implements DonationBehavior {

    // Constructor to initialize the medicine type
    public MedicineDonation() {
    }

    // Create a new donation by delegating to the Donation class
    @Override
    public Donation createDonation(String date, double amount, int elderId, int donatorId, String type) {
        // The 'type' parameter can be overridden by medicineType if needed
        return Donation.createDonation(date, amount, elderId, donatorId, type);
    }

    // Update an existing donation by delegating to the Donation class
    @Override
    public Donation updateDonation(String donationId, String date, double amount, int elderId, String type) {
        // The 'type' parameter can be overridden by medicineType if needed
        return Donation.updateDonation(donationId, date, amount, elderId, type);
    }

    // Cancel a donation by delegating to the Donation class
    @Override
    public boolean cancelDonation(String donationId) {
        return Donation.cancelDonation(donationId);
    }
}
