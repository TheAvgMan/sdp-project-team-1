package asu.eng.controllers;

import asu.eng.models.*;
import asu.eng.views.Printer;

public class IteratorDPUsecase implements IUsecaseContoller {

    private ElderCollection elderCollection = new ElderCollection();

    // Function to add one or multiple elders
    public void addElders(Elder... elders) {
        for (Elder elder : elders) {
            if (elder != null) {
                elderCollection.addElder(elder);
            }
        }
    }

    // Function to send a NormalVisit by visit ID to all elders
    public void sendNormalVisit(String visitId) {
        Visit normalVisit = NormalVisit.getId(visitId); // Fetch the visit by ID

        if (normalVisit != null) {
            for (Elder elder : elderCollection) {
                elder.accept(normalVisit); // Each elder accepts the visit
            }
        } else {
            String adapterVisit;
            Printer adapterPrint = new Printer();
            adapterVisit = visitId;
            adapterPrint.printMessage("Visit retrieval failed for ID: "+adapterVisit);

        }
    }

    @Override
    public void main() {
        // Test functionality here if needed (optional)
    }
}
