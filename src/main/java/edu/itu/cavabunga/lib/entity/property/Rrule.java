package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;

@Entity
public class Rrule extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.RECUR);
    }
}