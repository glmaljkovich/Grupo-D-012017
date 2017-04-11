package model.user;

import model.Threshold;

import java.util.List;

public class Profile {
    private String address;
    private String name;
    private String lastName;
    private List<Threshold> thresholds;

    public Profile() {

    }

    public Profile(String name, String lastName, String address) {
        this.address    = address;
        this.name       = name;
        this.lastName   = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Threshold> getThresholds() {
        return thresholds;
    }

    public void setThresholds(List<Threshold> thresholds) {
        this.thresholds = thresholds;
    }

   /* public void addTreshold(Threshold treshold){
        this.thresholds.add(treshold);
    }*/
}
