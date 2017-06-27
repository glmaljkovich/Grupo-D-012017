package grupod.desapp.unq.edu.ar.model.user;

import grupod.desapp.unq.edu.ar.model.Threshold;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private String name;
    private String lastName;
    private Float latitude;
    private Float longitude;
    @Column
    @ElementCollection(targetClass=Threshold.class)
    private List<Threshold> thresholds;

    public Profile() {
        this.thresholds = new ArrayList<>();
    }

    public Profile(String name, String lastName, String address) {
        this.address    = address;
        this.name       = name;
        this.lastName   = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
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
