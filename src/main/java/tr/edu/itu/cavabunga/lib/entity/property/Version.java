package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Version extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.TEXT);

        //cavabunga will not support ical version other then 2.0
        if(!this.getValue().equals("2.0")){
            throw new Validation("Version cannot be other then 2.0");
        }
    }
}
