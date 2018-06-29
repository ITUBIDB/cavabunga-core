package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Fmttype extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties that are used to reference an object
        super.validate();
        if(this.getValue().matches("(\\w+)/(\\w+)")){
            throw new Validation("FMTYPE must have valid mime type: " + this.getValue());
        }
    }
}
