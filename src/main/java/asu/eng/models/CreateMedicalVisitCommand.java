package asu.eng.models;

public class CreateMedicalVisitCommand implements ICommand {
    private Doctor doctor;
    private String date, time, status;
    private int elderId;

    public CreateMedicalVisitCommand(Doctor doctor, String date, String time, String status, int elderId) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;
        this.elderId = elderId;
    }

    @Override
    public void execute() {
        doctor.makeMedicalVisit(date, time, elderId, status);
    }
}
