package asu.eng.models;

public class Visitor extends User{
    private NormalVisit normalVisit;
    private static databaseObject dbObject;

    public Visitor(int id) {
        super(dbObject = getDBObject(id));
        // make a database request here to fetch Visitor
//        this.normalVisit = // use dbObject to get the data of normalVisit field


    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch Visitor
//        return object of databaseObject type;
    }

    public NormalVisit makeNormalVisit(String date, String time. int elderId) {

    }

    public NormalVisit getNormalVisit(int visitId) {

    }

    public NormalVisit updateNormalVisit(int visitId, String date, String time. int elderId) {

    }

    public boolean cancelNormalVisit(int visitId) {

    }
}
