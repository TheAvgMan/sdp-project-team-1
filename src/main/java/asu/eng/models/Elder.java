package asu.eng.models;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class Elder {

    private static final String DATABASE_NAME = "retirementHome";
    private static final String COLLECTION_NAME = "elders";
    private static MongoCollection<Document> collection;

    static {
        // Establish MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    private int id;
    private String name;

    // Constructor
    public Elder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Create a new Elder
    public static boolean create(String name) {
        try {
            Document document = new Document("name", name);
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get an Elder by ID
    public static Elder get(int id) {
        try {
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc != null) {
                return new Elder(doc.getInteger("id"), doc.getString("name"));
            } else {
                return null; // Not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update an Elder's name
    public static boolean update(int id, String name) {
        try {
            Document updatedDoc = new Document("name", name);
            collection.updateOne(Filters.eq("id", id), new Document("$set", updatedDoc));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an Elder by ID
    public static boolean delete(int id) {
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
        return "Elder{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
