package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.CreateCollectionOptions;

public class Donation {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "donations";
    private static MongoCollection<Document> collection;

    static {
        // Establish MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        // Create collection if it doesn't exist
        if (!database.listCollectionNames().into(new java.util.ArrayList<>()).contains(COLLECTION_NAME)) {
            database.createCollection(COLLECTION_NAME, new CreateCollectionOptions());
            System.out.println("Collection 'donations' created successfully.");
        }

        // Get the donations collection
        collection = database.getCollection(COLLECTION_NAME);
    }

    private int id;
    private String date;
    private double amount;
    private int donatorId;
    private int elderId;

    // Constructor
    public Donation(int id, String date, double amount, int donatorId, int elderId) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.donatorId = donatorId;
        this.elderId = elderId;
    }

    // Create a new donation
    public static boolean create(String date, double amount, int donatorId, int elderId) {
        try {
            Document document = new Document("date", date)
                    .append("amount", amount)
                    .append("donatorId", donatorId)
                    .append("elderId", elderId);
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a donation by id
    public static Donation get(int id) {
        try {
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc != null) {
                return new Donation(doc.getInteger("id"),
                        doc.getString("date"),
                        doc.getDouble("amount"),
                        doc.getInteger("donatorId"),
                        doc.getInteger("elderId"));
            } else {
                return null; // Not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update a donation by id
    public static boolean update(int id, String date, double amount, int donatorId, int elderId) {
        try {
            Document updatedDoc = new Document("date", date)
                    .append("amount", amount)
                    .append("donatorId", donatorId)
                    .append("elderId", elderId);
            collection.updateOne(Filters.eq("id", id), new Document("$set", updatedDoc));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove a donation by id
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
        return "Donation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", donatorId=" + donatorId +
                ", elderId=" + elderId +
                '}';
    }

    public static void main(String[] args) {
        // Test the functionality
        // Create a new donation
        boolean created = Donation.create("2024-11-17", 100.50, 101, 202);
        System.out.println("Created Donation: " + created);

        // Retrieve a donation by ID
        Donation donation = Donation.get(1);
        if (donation != null) {
            System.out.println("Retrieved Donation: " + donation);
        } else {
            System.out.println("Donation not found");
        }

        // Update a donation by ID
        boolean updated = Donation.update(1, "2024-11-18", 150.00, 101, 203);
        System.out.println("Updated Donation: " + updated);

        // Remove a donation by ID
        boolean removed = Donation.remove(1);
        System.out.println("Removed Donation: " + removed);
    }
}
