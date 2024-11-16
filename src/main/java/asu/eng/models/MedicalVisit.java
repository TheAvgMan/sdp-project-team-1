package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class MedicalVisit {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "medicalVisits";
    private static MongoCollection<Document> collection;

    static {
        // Establish MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    private int id;
    private String date;
    private String time;
    private int doctorId;
    private int elderId;

    // Constructor
    public MedicalVisit(int id, String date, String time, int doctorId, int elderId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.elderId = elderId;
    }

    // Create a new medical visit
    public static boolean create(String date, String time, int doctorId, int elderId) {
        try {
            Document document = new Document("date", date)
                    .append("time", time)
                    .append("doctorId", doctorId)
                    .append("elderId", elderId);
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a medical visit by id
    public static MedicalVisit get(int id) {
        try {
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc != null) {
                return new MedicalVisit(doc.getInteger("id"),
                        doc.getString("date"),
                        doc.getString("time"),
                        doc.getInteger("doctorId"),
                        doc.getInteger("elderId"));
            } else {
                return null; // Not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update a medical visit by id
    public static boolean update(int id, String date, String time, int doctorId, int elderId) {
        try {
            Document updatedDoc = new Document("date", date)
                    .append("time", time)
                    .append("doctorId", doctorId)
                    .append("elderId", elderId);
            collection.updateOne(Filters.eq("id", id), new Document("$set", updatedDoc));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove a medical visit by id
    public static boolean remove(int id) {
        try {
            collection.deleteOne(Filters.eq("id", id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "MedicalVisit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorId=" + doctorId +
                ", elderId=" + elderId +
                '}';
    }

    public static void main(String[] args) {
        // Test the functionality
        // Create a new medical visit
        boolean created = MedicalVisit.create("2024-11-17", "10:00 AM", 101, 202);
        System.out.println("Created Visit: " + created);

        // Retrieve a medical visit by ID
        MedicalVisit visit = MedicalVisit.get(1);
        if (visit != null) {
            System.out.println("Retrieved Visit: " + visit);
        } else {
            System.out.println("Visit not found");
        }

        // Update a medical visit by ID
        boolean updated = MedicalVisit.update(1, "2024-11-17", "11:00 AM", 101, 203);
        System.out.println("Updated Visit: " + updated);

        // Remove a medical visit by ID
        boolean removed = MedicalVisit.remove(1);
        System.out.println("Removed Visit: " + removed);
    }
}
