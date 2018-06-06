package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Value extends Parameter{
    @Override
    public void validate(){
        super.validate();
        if(!this.getValue().equals("BINARY")  &&
                !this.getValue().equals("BOOLEAN")  &&
                !this.getValue().equals("CAL-ADDRESS") &&
                !this.getValue().equals("DATE-TIME") &&
                !this.getValue().equals("DATE") &&
                !this.getValue().equals("DURATION") &&
                !this.getValue().equals("FLOAT") &&
                !this.getValue().equals("INTEGER") &&
                !this.getValue().equals("PERIOD") &&
                !this.getValue().equals("RECUR") &&
                !this.getValue().equals("TEXT") &&
                !this.getValue().equals("TIME") &&
                !this.getValue().equals("URI") &&
                !this.getValue().equals("UTC-OFFSET")){
            throw new Validation("VALUE value is different from acceptable value range: " + this.getValue());
        }
    }
}
