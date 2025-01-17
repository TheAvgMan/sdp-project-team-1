package asu.eng.controllers;

import asu.eng.models.*;
import asu.eng.views.DecoraterDPUsecaseView;

public class DecoratorDPUsecase implements IUsecaseContoller {

    @Override
    public void main() {
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

        // Create an instance of the view
        DecoraterDPUsecaseView view = new DecoraterDPUsecaseView();
        view.displayReceipts(donation, baseReceipt, receiptWithVAT, receiptWithTax, receiptWithBoth);
    }
}
