package com.windy.javacode.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String label = "1";
}
