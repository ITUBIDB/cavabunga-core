package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Action extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.TEXT);

        if(!this.getValue().equals("AUDIO") &&
                !this.getValue().equals("DISPLAY") &&
                !this.getValue().equals("EMAIL")){
            throw new Validation("ACTION value is different from acceptable value range: " + this.getValue());
        }
    }
}
