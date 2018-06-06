package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Rdate extends Property {
    @Override
    public void validate(){
        super.validate();
        try {
            super.validateValueType(PropertyValueType.DATETIME);
        }catch (Validation e){
            super.validateValueType(PropertyValueType.DATE);
        }
    }
}
