package asu.eng.models;

public abstract class ReceiptDecorator implements IReceiptGenerator {
    protected IReceiptGenerator decoratedReceipt;

    public ReceiptDecorator(IReceiptGenerator receipt) {
        this.decoratedReceipt = receipt;
    }

    public void generateReceipt() {}
}
