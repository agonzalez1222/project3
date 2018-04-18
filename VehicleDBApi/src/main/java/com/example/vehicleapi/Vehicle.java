package com.example.vehicleapi;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")

public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String makeModel;
    private int year;
    private double retailPrice;

    public Vehicle() {
        this.id = 1;
        this.makeModel = "VW Jetta";
        this.year = 2005;
        this.retailPrice = 5000.00;
    }

    public Vehicle(int id, String makeModel, int year, double retailPrice) {
        this.id = id;
        this.makeModel = makeModel;
        this.year = year;
        this.retailPrice = retailPrice;
    }

    public Vehicle(String makeModel, int year, double retailPrice)
    {

        this.id = id;
        this.makeModel = makeModel;
        this.year = year;
        this.retailPrice = retailPrice;
    }

    public String toString() {
        return this.getID() + ", " + this.makeModel + ", Year:" + this.year + ", Price:" + this.retailPrice;
    }

    public int getID() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakeModel() {
        return this.makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
