package asu.eng.models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    private ArrayList<MedicalVisit> allVisits;

    public Doctor(int id) {
        super(id);
        this.allVisits = getAllVisitsFromDB(id);
    }

    private ArrayList<MedicalVisit> getAllVisitsFromDB(int doctorId) {
        ArrayList<MedicalVisit> visits = new ArrayList<>();
        MongoDatabase db = org.example.Singleton.getInstance().getDatabase();
        MongoCollection<Document> visitsCollection = db.getCollection("visits");
        for (Document doc : visitsCollection.find(Filters.eq("doctorId", doctorId))) {
            visits.add(new MedicalVisit(doc.getInteger("visitId"),
                    doc.getString("date"),
                    doc.getString("time"),
                    doc.getInteger("elderId")));
        }
        return visits;
    }

    public boolean makeMedicalVisit(String date, String time, int elderId) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> visitsCollection = db.getCollection("visits");
        Document newVisit = new Document("doctorId", this.getId())
                .append("date", date)
                .append("time", time)
                .append("elderId", elderId);
        visitsCollection.insertOne(newVisit);
        return true;
    }

    public MedicalVisit getMedicalVisit(int visitId) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> visitsCollection = db.getCollection("visits");
        Document doc = visitsCollection.find(Filters.eq("visitId", visitId)).first();
        if (doc != null) {
            return new MedicalVisit(doc.getInteger("visitId"),
                    doc.getString("date"),
                    doc.getString("time"),
                    doc.getInteger("elderId"));
        }
        return null; // Or handle this with an exception or optional
    }

    public boolean updateMedicalVisit(int visitId, String date, String time, int elderId) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> visitsCollection = db.getCollection("visits");
        visitsCollection.updateOne(Filters.eq("visitId", visitId),
                Updates.combine(
                        Updates.set("date", date),
                        Updates.set("time", time),
                        Updates.set("elderId", elderId)
                ));
        return true;
    }

    public boolean cancelMedicalVisit(int visitId) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> visitsCollection = db.getCollection("visits");
        visitsCollection.deleteOne(Filters.eq("visitId", visitId));
        return true;
    }

    public static boolean create(String name, int age) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> usersCollection = db.getCollection("doctors");
        Document newUser = new Document("name", name)
                .append("age", age);
        usersCollection.insertOne(newUser);
        return true;
    }

    public static boolean update(int id, String name, int age) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> usersCollection = db.getCollection("doctors");
        usersCollection.updateOne(Filters.eq("id", id),
                Updates.combine(
                        Updates.set("name", name),
                        Updates.set("age", age)
                ));
        return true;
    }

    public static boolean delete(int id) {
        MongoDatabase db = Singleton.getInstance().getDatabase();
        MongoCollection<Document> usersCollection = db.getCollection("doctors");
        usersCollection.deleteOne(Filters.eq("id", id));
        return true;
    }
}

