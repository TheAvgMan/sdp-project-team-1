package asu.eng.views;

import asu.eng.models.*;

public class DecoraterDPUsecaseView {

    public void displayReceipts(Donation donation, IReceiptGenerator baseReceipt,
                                IReceiptGenerator receiptWithVAT, IReceiptGenerator receiptWithTax,
                                IReceiptGenerator receiptWithBoth) {

        System.out.println("Base Receipt:");
        System.out.println(baseReceipt.generateReceipt(donation));

        System.out.println("\nReceipt with VAT:");
        System.out.println(receiptWithVAT.generateReceipt(donation));

        System.out.println("\nReceipt with Tax:");
        System.out.println(receiptWithTax.generateReceipt(donation));

        System.out.println("\nReceipt with Both VAT and Tax:");
        System.out.println(receiptWithBoth.generateReceipt(donation));
    }
}
