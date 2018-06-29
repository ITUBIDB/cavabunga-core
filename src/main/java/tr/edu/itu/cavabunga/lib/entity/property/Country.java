package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;

@Entity
public class Country extends Property {
    //TODO: check rfc5545 to confirm if it exists
    @Override
    public void validate(){

    }
}
