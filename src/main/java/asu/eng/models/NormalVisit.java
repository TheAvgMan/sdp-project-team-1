package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;

public class NormalVisit {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "normalVisits";
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
    private int visitorId;
    private int elderId;

    // Constructor
    public NormalVisit(int id, String date, String time, int visitorId, int elderId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.visitorId = visitorId;
        this.elderId = elderId;
    }

    // Create a new NormalVisit
    public static boolean create(String date, String time, int visitorId, int elderId) {
        try {
            MongoCollection<Document> collection = getCollection();

            // Generate a unique ID (you may use another mechanism if needed)
            long count = collection.countDocuments();
            int id = (int) count + 1;

            Document visit = new Document("id", id)
                    .append("date", date)
                    .append("time", time)
                    .append("visitorId", visitorId)
                    .append("elderId", elderId);

            collection.insertOne(visit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a NormalVisit by ID
    public static NormalVisit getId(int id) {
        try {
            MongoCollection<Document> collection = getCollection();
            Document result = collection.find(new Document("id", id)).first();

            if (result != null) {
                return new NormalVisit(
                        result.getInteger("id"),
                        result.getString("date"),
                        result.getString("time"),
                        result.getInteger("visitorId"),
                        result.getInteger("elderId")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a NormalVisit by ID
    public static boolean update(int id, String date, String time, int visitorId, int elderId) {
        try {
            MongoCollection<Document> collection = getCollection();

            Document updatedFields = new Document("date", date)
                    .append("time", time)
                    .append("visitorId", visitorId)
                    .append("elderId", elderId);

            Document result = collection.findOneAndUpdate(
                    new Document("id", id),
                    new Document("$set", updatedFields)
            );

            return result != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove a NormalVisit by ID
    public static boolean remove(int id) {
        try {
            MongoCollection<Document> collection = getCollection();
            Document result = collection.findOneAndDelete(new Document("id", id));
            return result != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "NormalVisit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", visitorId=" + visitorId +
                ", elderId=" + elderId +
                '}';
    }

    public static void main(String[] args) {
        // Ensure the collection is created (if needed)
        createCollection();

        // Create a new NormalVisit
        boolean created = NormalVisit.create("2024-11-17", "10:00 AM", 301, 202);
        System.out.println("Created Visit: " + created);

        // Retrieve a NormalVisit by ID
        NormalVisit visit = NormalVisit.getId(1);
        if (visit != null) {
            System.out.println("Retrieved Visit: " + visit);
        } else {
            System.out.println("Visit not found");
        }

        // Update a NormalVisit by ID
        boolean updated = NormalVisit.update(1, "2024-11-17", "11:00 AM", 301, 203);
        System.out.println("Updated Visit: " + updated);

        // Remove a NormalVisit by ID
        boolean removed = NormalVisit.remove(1);
        System.out.println("Removed Visit: " + removed);
    }

    private static MongoCollection<Document> getCollection() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("retirementHome");
        return database.getCollection("normalVisits");
    }

    // Method to create the collection explicitly (if you need to initialize it)
    public static void createCollection() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("retirementHome");

            // Create collection explicitly if it doesn't exist
            database.createCollection("normalVisits");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
