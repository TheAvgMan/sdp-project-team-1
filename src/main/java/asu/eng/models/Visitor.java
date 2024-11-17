package asu.eng.models;

public class Visitor extends User{
    private NormalVisit particularVisit;
    private NormalVisit[] allVisits;
    private static databaseObject dbObject;

    public Visitor(int id) {
        super(dbObject = getDBObject(id));


//        this.normalVisit = // use dbObject to get the data of normalVisit field


    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch Visitor
//        return object of databaseObject type;
    }


    public boolean makeNormalVisit(String date, String time. int elderId) {

    }

    public NormalVisit getNormalVisit(int visitId) {

    }

    public NormalVisit[] getAllVisits() {

    }

    public boolean updateNormalVisit(int visitId, String date, String time. int elderId) {

    }

    public boolean cancelNormalVisit(int visitId) {

    }


    public static boolean create(String name, int age) {

    }

    public static boolean update(int id, String name, int age) {

    }

    public static boolean delete(int id) {

    }
}
