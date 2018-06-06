package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class DelegatedTo extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type
        super.validate();
        if(!this.getValue().substring(0,1).equals("\"") || !this.getValue().substring(this.getValue().length() -1).equals("\"")){
            throw new Validation("DELEGATED-TO parameter must start and end with DQUOTE char.");
        }

    }
}
