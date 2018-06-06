package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Reltype extends Parameter{
    @Override
    public void validate(){
        //TODO:  This parameter can be specified on properties with a CAL-ADDRESS value type
        super.validate();
        if(!this.getValue().equals("PARENT") &&
                !this.getValue().equals("CHILD") &&
                !this.getValue().equals("SIBLING")){
            throw new Validation("RELTYPE value is different from acceptable value range: " + this.getValue());
        }
    }
}
