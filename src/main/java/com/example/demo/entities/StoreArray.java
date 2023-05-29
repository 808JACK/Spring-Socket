package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Arrays;
import java.util.List;

@Entity
public class StoreArray {

    @Id
    private int id;



    public StoreArray() {
    }

    public StoreArray(int id, List<Integer> values) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "StoreArray{" +
                "id=" + id +
                '}';
    }
}
