package com.wedding.datamanager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pipe on 8/5/17.
 */

@Data
@Document(collection="wedding")
public class Wedding {
    private Owner owner;
    @Id
    private String email;
    private ArrayList<Guest> guests = new ArrayList<>();
    private Location location;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean addGuest(Guest guest) {
        return this.guests.add(guest);
    }

}
