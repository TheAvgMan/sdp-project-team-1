package asu.eng.views;

public class EventExporterView {

    // Display success message
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Display error message
    public void showError(String error) {
        System.err.println(error);
    }
}
