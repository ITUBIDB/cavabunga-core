package edu.itu.cavabunga.lib.entity.parameter;

import edu.itu.cavabunga.lib.entity.Parameter;

import javax.persistence.Entity;

@Entity
public class Cn extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type
        super.validate();
    }
}
