package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;


    public Comment() {
    }
}