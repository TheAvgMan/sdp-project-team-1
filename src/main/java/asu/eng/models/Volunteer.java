package asu.eng.models;

public class Volunteer {
    private VolunteerReservation reservation;
    private VolunteerReservation[] allReservations;
    private boolean eventDateModified;
    private Event event;
    private static databaseObject dbObject;


    public Volunteer(int id) {
        super(dbObject = getDBObject(id));


//        this.reservation = // use dbObject to get the data of normalVisit field


    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch Volunteer
//        return object of databaseObject type;
    }

    public boolean makeReservation(int eventId) {

    }

    public VolunteerReservation getReservation(int reservationId) {

    }

    public VolunteerReservation[] getAllReservations() {

    }

    public boolean cancelReservation(int reservationId) {

    }


    public static boolean create(String name, int age) {

    }

    public static boolean update(int id, String name, int age) {

    }

    public static boolean delete(int id) {

    }
}
