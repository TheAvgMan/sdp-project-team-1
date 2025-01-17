package asu.eng.controllers;

import asu.eng.models.*;

public class CommandDPUsecase implements IUsecaseContoller{

    @Override
    public void main() {
        Doctor doctor = new Doctor(1, "Dr. Smith");
        Scheduler scheduler = new Scheduler();

        // Create a medical visit
        ICommand createVisit = new CreateMedicalVisitCommand(doctor, "2025-01-01", "10:00", "Pending", 101);
        scheduler.takeCommand(createVisit);

        // Cancel a medical visit
        ICommand cancelVisit = new CancelMedicalVisitCommand(doctor, "678a8c4a6d80101fb4efc5b0");
        scheduler.takeCommand(cancelVisit);

        // Execute all commands
        scheduler.executeCommands();
    }
}
