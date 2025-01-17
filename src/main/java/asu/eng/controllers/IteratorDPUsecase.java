package asu.eng.controllers;

import asu.eng.models.*;

public class IteratorDPUsecase implements IUsecaseContoller{

    @Override
    public void main() {
//        Elder.create(1, "John Doe");
//        Elder.create(2, "Jane Smith");

        Elder elder1 = Elder.get(1);
        Elder elder2 = Elder.get(2);

        ElderCollection elderCollection = new ElderCollection();
        elderCollection.addElder(elder1);
        elderCollection.addElder(elder2);

//        NormalVisit.create("2025-01-01", "10:00", 1, 1, "Pending");
        Visit normalVisit = NormalVisit.getId("678a9426edc24c309d45ea20");

        for (Elder elder : elderCollection) {
            elder.accept(normalVisit);
        }
    }
}
