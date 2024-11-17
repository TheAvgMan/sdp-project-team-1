package asu.eng.models;

public class NormalVisit extends Visit{

    public NormalVisit(int id) {
        super(getDBObject(id));
    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch NormalVisit
//        return object of databaseObject type;
    }

    public static boolean create(String date, String time, int visitorId, int elderId) {

    }

    public static NormalVisit[] getAll(int visitorId) {

    }

    public static boolean update(int id, String date, String time, int visitorId, int elderId) {

    }

    public static boolean delete(int id) {

    }
}
