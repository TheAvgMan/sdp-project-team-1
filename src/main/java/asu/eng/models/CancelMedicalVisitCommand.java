package asu.eng.models;

public class CancelMedicalVisitCommand implements ICommand {
    private Doctor doctor;
    private String visitId;

    public CancelMedicalVisitCommand(Doctor doctor, String visitId) {
        this.doctor = doctor;
        this.visitId = visitId;
    }

    @Override
    public void execute() {
        doctor.cancelMedicalVisit(visitId);
    }
}
