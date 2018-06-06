package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Fbtype extends Parameter {
    @Override
    public void validate(){
        super.validate();
        if(!this.getValue().equals("FREE") &&
                !this.getValue().equals("BUSY") &&
                !this.getValue().equals("BUSY-UNAVAILABLE") &&
                !this.getValue().equals("BUSY-TENTATIVE")){
            throw new Validation("FBTYPE value is different from acceptable value range: " + this.getValue());
        }
    }
}
