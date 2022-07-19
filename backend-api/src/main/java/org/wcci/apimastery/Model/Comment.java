package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private double rating;
    @Lob
    private String body;

    public Comment(String username, double rating, String body) {
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Comment() {
    }

    public double getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBody() {
        return body;
    }
}