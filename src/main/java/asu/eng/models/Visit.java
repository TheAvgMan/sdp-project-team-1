package asu.eng.models;

public abstract class Visit {
    protected String date;
    protected String time;
    protected int elderId;

    public abstract void visit(Elder elder);

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getElderId() {
        return elderId;
    }

    public void setElderId(int elderId) {
        this.elderId = elderId;
    }
}
