package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Class extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.TEXT);

        if(!this.getValue().equals("PUBLIC") &&
                !this.getValue().equals("PRIVATE") &&
                !this.getValue().equals("CONFIDENTIAL")){
            throw new Validation("CLASS value is different from acceptable value range: " + this.getValue());
        }
    }
}
