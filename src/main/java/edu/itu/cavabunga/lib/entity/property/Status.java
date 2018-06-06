package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Status extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.TEXT);

        if(!this.getValue().equals("TENTATIVE") &&
                !this.getValue().equals("CONFIRMED") &&
                !this.getValue().equals("CANCELLED") &&
                !this.getValue().equals("NEEDS-ACTION") &&
                !this.getValue().equals("COMPLETED") &&
                !this.getValue().equals("IN-PROCESS") &&
                !this.getValue().equals("COMPLETED") &&
                !this.getValue().equals("DRAFT") &&
                !this.getValue().equals("FINAL")){
            throw new Validation("STATUS property is out of acceptable range: " + this.getValue());
        }
    }
}
