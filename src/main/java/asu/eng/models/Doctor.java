package asu.eng.models;

public class Doctor {
    private MedicalVisit medicalVisit;
    private User previousUserAddOn;

    public Doctor(User previousUserAddOn) {
        // make a database request here to fetch Visitor

        this.previousUserAddOn = previousUserAddOn;
    }

    public MedicalVisit makeMedicalVisit(String date, String time. int elderId) {

    }

    public MedicalVisit getMedicalVisit(int visitId) {

    }

    public MedicalVisit updateMedicalVisit(int visitId, String date, String time. int elderId) {

    }

    public boolean cancelMedicalVisit(int visitId) {

    }
}
