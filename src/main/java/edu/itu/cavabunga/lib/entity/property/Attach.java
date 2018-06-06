package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;

@Entity
public class Attach extends Property {
    @Override
    public void validate(){
        super.validate();
        try {
            super.validateValueType(PropertyValueType.URI);
        }catch (Exception e){
            super.validateValueType(PropertyValueType.BINARY);
        }
    }
}
