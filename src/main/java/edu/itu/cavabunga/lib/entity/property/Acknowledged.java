package edu.itu.cavabunga.lib.entity.property;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Acknowledged extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim().equals("")){
            throw new Validation("ACKNOWLEDGED property cannot be empty");
        }

           if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("ACKNOWLEDGED parameter validation failed: " + pr.getValue());
                }
            }
        }
    }
}
