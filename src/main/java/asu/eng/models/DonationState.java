package asu.eng.models;

public interface DonationState {
    void nextState(DonationContext context);
    void previousState(DonationContext context);
    void printCurrentState();
}
