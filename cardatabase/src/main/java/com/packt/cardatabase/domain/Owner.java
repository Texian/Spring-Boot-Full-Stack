package com.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    public Owner() {}

    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getOwnerid(){ return ownerid;}
    public void setOwnerid(long ownerid){ this.ownerid = ownerid; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname;}

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
//    private List<Car> cars;
//
//    public List<Car> getcars(){ return cars;}
//    public void setcars(List<Car> cars){ this.cars = cars; }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "car_owner", joinColumns = {
            @JoinColumn(name = "ownerid") },
            inverseJoinColumns = {
            @JoinColumn(name = "id") })
    private Set<Car> cars = new HashSet<Car>(0);

    public Set<Car> getCars(){ return cars; }
    public void setCars(Set<Car> cars){ this.cars = cars; }
}
