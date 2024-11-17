package asu.eng.models;

import java.util.ArrayList;

public class Event implements Subject{
    private int id;
    private String name;
    private String date;
    private String description;
    private ArrayList<Observer> observers;

    public Event(int id) {

        // database fetch object

        this.id = id;
//        this.observers =
//        this.name =
//        this.date =
//        and so on ...
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update();
        }
    }

    public void setDate(String date) {
        this.date = date;
        // modify date of object in database in this line
        notifyAllObservers();
    }
}
