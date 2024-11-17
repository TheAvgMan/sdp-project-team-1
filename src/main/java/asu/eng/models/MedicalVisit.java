package asu.eng.models;

public class MedicalVisit extends Visit{

    public MedicalVisit(int id) {
        super(getDBObject(id));
    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch MedicalVisit
//        return object of databaseObject type;
    }

    public static boolean create(String date, String time, int doctorId, int elderId) {

    }

    public static MedicalVisit[] getAll(int doctorId) {

    }

    public static boolean update(int id, String date, String time, int doctorId, int elderId) {

    }

    public static boolean delete(int id) {

    }
}
