package asu.eng.models;

public abstract class User {
    private int id;
    private String name;
    private int age;


    public User(/* type of object returning from database */) {
//        this.id = // the id field coming from the database object ;
//        this.name = // the id field coming from the database object;
//        this.age = // the id field coming from the database object;
    }

    protected static boolean create(String name, int age) {
        // code here to create user in database



        return false;
    }

    protected static boolean update(int id, String name, int age) {
        // code here to update user in database



        return false;
    }

    protected static boolean delete(int id) {
        // code here to delete user in database



        return false;
    }
}
