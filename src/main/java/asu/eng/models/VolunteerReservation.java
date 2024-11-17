package asu.eng.models;

public class VolunteerReservation {
    private int id;
    private int volunteerId;
    private int eventId;

    public VolunteerReservation(int id) {
        // database fetch object

        this.id = id;
//        this.volunteerId =
//        this.eventId =
    }

    public static boolean create(int volunteerId, int eventId) {

    }

    public static VolunteerReservation[] getAll(int volunteerId) {

    }

    public static boolean delete(int id) {

    }
}
