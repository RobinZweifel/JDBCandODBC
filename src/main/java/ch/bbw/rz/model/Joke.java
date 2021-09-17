package ch.bbw.rz.model;

import java.sql.Date;

public class Joke {
    private int id;
    private String text;
    private Date date;
    private int rating;

    public Joke(){
        super();
    }

    public void setupJoke(int id, String text, Date date, int rating) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.rating = rating;
    }

    public void print(){
        System.out.println("Joke id: " + id + " Date: " + date + " Text: " + text);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
