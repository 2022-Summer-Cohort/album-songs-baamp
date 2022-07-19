package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RecordLabel {
    @Id
    @GeneratedValue
    private Long id;


    public RecordLabel() {
    }
}
