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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
