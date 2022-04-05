package com.donkeycar.HZServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_cases")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    private String preConditions;
    private String postConditions;

    public TestCase(String description, String preConditions, String postConditions) {
        this.description = description;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
    }

    public TestCase() {
        this("Failed Entry", "None", "None");
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreConditions() {
        return this.preConditions;
    }

    public void setPreConditions(String preConditions) {
        this.preConditions = preConditions;
    }

    public String getPostConditions() {
        return this.postConditions;
    }

    public void setPostConditions(String postConditions) {
        this.postConditions = postConditions;
    }

    
    @Override
    public String toString() {
        String output = id + ";" + description + ";" + preConditions + ";" + postConditions;
        return output;
    }
}
