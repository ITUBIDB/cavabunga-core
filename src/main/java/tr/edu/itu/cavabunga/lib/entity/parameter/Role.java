package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Role extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type.
        super.validate();
        if(!this.getValue().equals("CHAIR") &&
                !this.getValue().equals("REQ-PARTICIPANT") &&
                !this.getValue().equals("OPT-PARTICIPANT") &&
                !this.getValue().equals("NON-PARTICIPANT")){
            throw new Validation("ROLE value is different from acceptable value range: " + this.getValue());
        }
    }
}
