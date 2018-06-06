package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;
import java.util.concurrent.ExecutionException;

@Entity
public class Description extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.TEXT);
    }
}
