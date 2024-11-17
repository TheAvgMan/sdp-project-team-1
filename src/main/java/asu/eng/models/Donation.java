package asu.eng.models;

public class Donation {
    private int id;
    private String date;
    private double amount;
    private int donatorId;
    private int elderId;

    public Donation(int id) {
        // database fetch object

        this.id = id;
//        this.date =
//        this.amount =
//        and so on ...
    }

    public static boolean create(String date, double amount, int donatorId, int elderId) {

    }

    public static Donation[] getAll(int donatorId) {

    }

    public static boolean update(int id, String date, double amount, int donatorId, int elderId) {

    }

    public static boolean delete(int id) {

    }
}
