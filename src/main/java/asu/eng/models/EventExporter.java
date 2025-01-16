package asu.eng.models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EventExporter {

    // Fetch all events from the database
    public static List<Event> getAllEvents() {
        MongoCollection<Document> eventCollection = Singleton.getInstance().getDatabase().getCollection("events");
        MongoCursor<Document> cursor = eventCollection.find().iterator();

        List<Event> events = new ArrayList<>();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            events.add(new Event(
                    doc.getInteger("id"),
                    doc.getString("name"),
                    doc.getString("date"),
                    doc.getString("description")
            ));
        }
        return events;
    }

    // Count volunteer reservations for a specific event
    public static int getVolunteerCountForEvent(int eventId) {
        MongoCollection<Document> reservationCollection = Singleton.getInstance().getDatabase().getCollection("volunteerReservations");
        return (int) reservationCollection.countDocuments(new Document("eventId", eventId));
    }
}
