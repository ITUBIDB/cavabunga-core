package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Rsvp extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type.
        super.validate();
        if(!this.getValue().equals("TRUE") &&
                !this.getValue().equals("FALSE")){
            throw new Validation("RSVP value is different from acceptable value range: " + this.getValue());
        }
    }
}
