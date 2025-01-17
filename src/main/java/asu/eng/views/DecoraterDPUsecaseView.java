package asu.eng.views;

import asu.eng.models.*;

public class DecoraterDPUsecaseView {

    public void displayBaseReceipt(Donation donation, IReceiptGenerator baseReceipt) {
        System.out.println(baseReceipt.generateReceipt(donation));
    }

    public void displayReceiptWithVAT(Donation donation, IReceiptGenerator receiptWithVAT) {
        System.out.println(receiptWithVAT.generateReceipt(donation));
    }

    public void displayReceiptWithTax(Donation donation, IReceiptGenerator receiptWithTax) {
        System.out.println(receiptWithTax.generateReceipt(donation));
    }

    public void displayReceiptWithBoth(Donation donation, IReceiptGenerator receiptWithBoth) {
        System.out.println(receiptWithBoth.generateReceipt(donation));
    }
}


