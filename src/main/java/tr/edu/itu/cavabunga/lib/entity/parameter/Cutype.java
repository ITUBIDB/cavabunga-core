package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Cutype extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type
        super.validate();
        if(!this.getValue().equals("INDIVIDUAL") &&
                !this.getValue().equals("GROUP") &&
                !this.getValue().equals("RESOURCE") &&
                !this.getValue().equals("ROOM") &&
                !this.getValue().equals("UNKNOWN")){
            throw new Validation("CUTYPE value is different from acceptable value range: " + this.getValue());
        }
    }
}
