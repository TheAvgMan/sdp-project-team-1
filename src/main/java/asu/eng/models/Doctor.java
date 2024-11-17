package asu.eng.models;

public class Doctor extends User{
    private MedicalVisit particularVisit;
    private MedicalVisit[] allVisits;
    private static databaseObject dbObject;

    public Doctor(int id) {
        super(dbObject = getDBObject(id));


//        this.medicalVisit = // use dbObject to get the data of medicalVisit field


    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch Doctor
//        return object of databaseObject type;
    }


    public boolean makeMedicalVisit(String date, String time. int elderId) {

    }

    public MedicalVisit getMedicalVisit(int visitId) {

    }

    public MedicalVisit[] getAllVisits() {

    }

    public boolean updateMedicalVisit(int visitId, String date, String time. int elderId) {

    }

    public boolean cancelMedicalVisit(int visitId) {

    }


    public static boolean create(String name, int age) {

    }

    public static boolean update(int id, String name, int age) {

    }

    public static boolean delete(int id) {

    }
}
