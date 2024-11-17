package asu.eng.models;

public class Donator {
    private Donation particularDonation;
    private Donation[] allDonations;
    private DonationBehaviour donationBehaviour;
    private static databaseObject dbObject;

    public Donator(int id) {
        super(dbObject = getDBObject(id));


//        this.donation = // use dbObject to get the data of normalVisit field

        DonationBehaviour donationBehaviour = new MoneyDonation(); // default implementation

    }

    private static databaseObject getDBObject(int id) {
        // make a database request here to fetch Donator
//        return object of databaseObject type;
    }

    public boolean makeDonation(String date, double amount. int elderId) {
        donationBehaviour.donate();
        // rest of the donation logic here
    }

    public Donation getDonation(int donationId) {

    }

    public Donation[] getAllDonations() {

    }

    public boolean updateDonation(int donationId, String date, double amount. int elderId) {

    }

    public boolean cancelDonation(int donationId) {

    }


    public static boolean create(String name, int age) {

    }

    public static boolean update(int id, String name, int age) {

    }

    public static boolean delete(int id) {

    }
}
