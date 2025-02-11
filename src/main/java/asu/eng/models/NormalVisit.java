package asu.eng.models;

import asu.eng.views.Printer;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
// for factory pattern getting all Normal visits
import java.util.List;
import java.util.ArrayList;

public class NormalVisit extends Visit {


    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "normalVisits";
    private static MongoDatabase database = Singleton.getInstance().getDatabase(); // Get the database using Singleton
    private static MongoCollection<Document> collection = database.getCollection("normalVisits");
    private static MongoClient mongoClient;
    private MongoCollection<Document> NormalVisitCollection;


    {
        // Establish MongoDB connection
//        MongoDatabase database = Singleton.getInstance().getDatabase(); // Get the database using Singleton
//        this.NormalVisitCollection = database.getCollection("normalVisits"); // Collection name for medical visits
    }

    private String NormalVisitId;  // Change to String
    private int visitorId;
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

    @Override
    public void visit(Elder elder) {
        Printer visitPrint = new Printer();
        String elderName;
        elderName = elder.getName();
        visitPrint.printMessage("Performing a normal visit to "+elderName);

        // Implement visit behavior here
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


    // Get all Normal Visits for Normal Visit Report Factory Pattern
    public static List<NormalVisit> getAllNormalVisits() {
        List<NormalVisit> visits = new ArrayList<>();
        try {
            // Ensure the collection is initialized
            if (collection == null) {
                MongoDatabase database = Singleton.getInstance().getDatabase();
                collection = database.getCollection(COLLECTION_NAME);
            }

            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                visits.add(new NormalVisit(
                        doc.getObjectId("_id").toString(),
                        doc.getString("date"),
                        doc.getString("time"),
                        doc.getInteger("visitorId"),
                        doc.getInteger("elderId"),
                        doc.getString("status")
                ));
            }
        } catch (Exception e) {
            System.err.println("Error retrieving all normal visits: " + e.getMessage());
            e.printStackTrace();
        }
        return visits;
    }

}