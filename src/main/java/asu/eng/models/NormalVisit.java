package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class NormalVisit {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "normalVisits";
    private static MongoCollection<Document> collection;
    private static MongoClient mongoClient;
    private MongoCollection<Document> NormalVisitCollection;


    {
        // Establish MongoDB connection
        MongoDatabase database = Singleton.getInstance().getDatabase(); // Get the database using Singleton
        this.NormalVisitCollection = database.getCollection("normalVisits"); // Collection name for medical visits
    }

    private String NormalVisitId;  // Change to String
    private String date;
    private String time;
    private int visitorId;
    private int elderId;
    private String status; // New field for status

    // Constructor
    public NormalVisit(String id, String date, String time, int visitorId, int elderId, String status) {
        this.NormalVisitId = id;
        this.date = date;
        this.time = time;
        this.visitorId = visitorId;
        this.elderId = elderId;
        this.status = status; // Initialize status
    }

    public String getVisitId() {
        return NormalVisitId;  // Returns the visit ID
    }

    // Create a new NormalVisit
    public static boolean create(String date, String time, int visitorId, int elderId, String status) {
        try {
            // Generate a unique ObjectId and convert it to String
            ObjectId objectId = new ObjectId();
            String id = objectId.toString();

            Document visit = new Document("_id", objectId)  // Using Mongo's ObjectId for _id
                    .append("date", date)
                    .append("time", time)
                    .append("visitorId", visitorId)
                    .append("elderId", elderId)
                    .append("status", status);  // Include status field

            collection.insertOne(visit);
            System.out.println("NormalVisit created successfully.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a NormalVisit by ID (String type)
    public static NormalVisit getId(String id) {
        try {
            Document result = collection.find(new Document("_id", new ObjectId(id))).first();

            if (result != null) {
                return new NormalVisit(
                        result.getObjectId("_id").toString(), // Convert ObjectId to String
                        result.getString("date"),
                        result.getString("time"),
                        result.getInteger("visitorId"),
                        result.getInteger("elderId"),
                        result.getString("status") // Retrieve status
                );
            } else {
                System.out.println("NormalVisit not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a NormalVisit by ID (String type)
    public static boolean update(String id, String date, String time, int visitorId, int elderId, String status) {
        try {
            Document updatedFields = new Document("date", date)
                    .append("time", time)
                    .append("visitorId", visitorId)
                    .append("elderId", elderId)
                    .append("status", status); // Update status field

            Document result = collection.findOneAndUpdate(
                    new Document("_id", new ObjectId(id)),
                    new Document("$set", updatedFields)
            );

            if (result != null) {
                System.out.println("NormalVisit updated successfully.");
                return true;
            } else {
                System.out.println("NormalVisit not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Remove a NormalVisit by ID (String type)
    public static boolean remove(String id) {
        try {
            Document result = collection.findOneAndDelete(new Document("_id", new ObjectId(id)));

            if (result != null) {
                System.out.println("NormalVisit removed successfully.");
                return true;
            } else {
                System.out.println("NormalVisit not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String toString() {
        return "NormalVisit{" +
                "id='" + NormalVisitId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", visitorId=" + visitorId +
                ", elderId=" + elderId +
                ", status='" + status + '\'' +  // Include status in toString
                '}';
    }

}