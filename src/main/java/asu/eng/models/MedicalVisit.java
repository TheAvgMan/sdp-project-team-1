package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

// for factory pattern getting all medical visits
import java.util.List;
import java.util.ArrayList;


public class MedicalVisit {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "medicalVisits";
    private static MongoCollection<Document> collection;
    private MongoCollection<Document> medicalVisitCollection;


    {
        // Establish MongoDB connection
        MongoDatabase database = Singleton.getInstance().getDatabase(); // Get the database using Singleton
        this.medicalVisitCollection = database.getCollection("medicalVisits"); // Collection name for medical visits
    }

    private String medicalVisitId;  // Changed to String for ObjectId compatibility
    private String date;
    private String time;
    private int doctorId;
    private int elderId;
    private String status;  // New field for status

    // Constructor
    public MedicalVisit(String medicalVisitId, String date, String time, int doctorId, int elderId, String status) {
        this.medicalVisitId = medicalVisitId;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.elderId = elderId;
        this.status = status;  // Initialize status
    }

    // Getter for medicalVisitId
    public String getVisitId() {
        return medicalVisitId;  // Returns the visit ID
    }

    // Create a new medical visit
    public static boolean create(String date, String time, int doctorId, int elderId, String status) {
        try {
            Document document = new Document("date", date)
                    .append("time", time)
                    .append("doctorId", doctorId)
                    .append("elderId", elderId)
                    .append("status", status);  // Add status to document
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            System.err.println("Error creating medical visit: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Get a medical visit by ID
    public static MedicalVisit get(String medicalVisitId) {
        try {
            Document doc = collection.find(Filters.eq("_id", new ObjectId(medicalVisitId))).first();
            if (doc != null) {
                return new MedicalVisit(
                        doc.getObjectId("_id").toString(),
                        doc.getString("date"),
                        doc.getString("time"),
                        doc.getInteger("doctorId"),
                        doc.getInteger("elderId"),
                        doc.getString("status") // Retrieve status
                );
            } else {
                System.out.println("Medical visit not found.");
                return null;  // Not found
            }
        } catch (Exception e) {
            System.err.println("Error retrieving medical visit: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Update a medical visit by ID
    public static boolean update(String medicalVisitId, String date, String time, int doctorId, int elderId, String status) {
        try {
            Document updatedDoc = new Document("date", date)
                    .append("time", time)
                    .append("doctorId", doctorId)
                    .append("elderId", elderId)
                    .append("status", status);  // Update status as well
            collection.updateOne(Filters.eq("_id", new ObjectId(medicalVisitId)), new Document("$set", updatedDoc));
            return true;
        } catch (Exception e) {
            System.err.println("Error updating medical visit: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Remove a medical visit by ID
    public static boolean remove(String medicalVisitId) {
        try {
            collection.deleteOne(Filters.eq("_id", new ObjectId(medicalVisitId)));
            return true;
        } catch (Exception e) {
            System.err.println("Error removing medical visit: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to return a string representation of the MedicalVisit object
    @Override
    public String toString() {
        return "MedicalVisit{" +
                "medicalVisitId='" + medicalVisitId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorId=" + doctorId +
                ", elderId=" + elderId +
                ", status='" + status + '\'' + // Include status in toString
                '}';
    }


    // Get all medical visits
    public static List<MedicalVisit> getAllMedicalVisits() {
        List<MedicalVisit> visits = new ArrayList<>(); // To store all medical visits
        try {
            // Ensure the collection is initialized
            if (collection == null) {
                MongoDatabase database = Singleton.getInstance().getDatabase();
                collection = database.getCollection(COLLECTION_NAME);
            }
            // Fetch all documents
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                visits.add(new MedicalVisit(
                        doc.getObjectId("_id").toString(),
                        doc.getString("date"),
                        doc.getString("time"),
                        doc.getInteger("doctorId"),
                        doc.getInteger("elderId"),
                        doc.getString("status")
                ));
            }
        } catch (Exception e) {
            System.err.println("Error retrieving all medical visits: " + e.getMessage());
            e.printStackTrace();
        }
        return visits; // Return the list of visits
    }



}
