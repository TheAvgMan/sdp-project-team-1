package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class VolunteerReservation {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "volunteerReservations";
    private static MongoCollection<Document> collection;

    static {
        // Establish MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        // Create collection if it doesn't exist
        if (!database.listCollectionNames().into(new java.util.ArrayList<>()).contains(COLLECTION_NAME)) {
            database.createCollection(COLLECTION_NAME);
            System.out.println("Collection 'volunteerReservations' created successfully.");
        }

        // Get the volunteerReservations collection
        collection = database.getCollection(COLLECTION_NAME);
    }

    private int id;
    private int volunteerId;
    private int eventId;

    // Constructor
    public VolunteerReservation(int id, int volunteerId, int eventId) {
        this.id = id;
        this.volunteerId = volunteerId;
        this.eventId = eventId;
    }

    // Create a new volunteer reservation
    public static boolean create(int volunteerId, int eventId) {
        try {
            Document document = new Document("volunteerId", volunteerId)
                    .append("eventId", eventId);
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a volunteer reservation by id
    public static VolunteerReservation get(int id) {
        try {
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc != null) {
                return new VolunteerReservation(doc.getInteger("id"),
                        doc.getInteger("volunteerId"),
                        doc.getInteger("eventId"));
            } else {
                return null; // Not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Remove a volunteer reservation by id
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
        return "VolunteerReservation{" +
                "id=" + id +
                ", volunteerId=" + volunteerId +
                ", eventId=" + eventId +
                '}';
    }

    public static void main(String[] args) {
        // Test the functionality
        // Create a new volunteer reservation
        boolean created = VolunteerReservation.create(101, 202);
        System.out.println("Created VolunteerReservation: " + created);

        // Retrieve a volunteer reservation by ID
        VolunteerReservation reservation = VolunteerReservation.get(1);
        if (reservation != null) {
            System.out.println("Retrieved VolunteerReservation: " + reservation);
        } else {
            System.out.println("VolunteerReservation not found");
        }

        // Remove a volunteer reservation by ID
        boolean removed = VolunteerReservation.remove(1);
        System.out.println("Removed VolunteerReservation: " + removed);
    }
}

