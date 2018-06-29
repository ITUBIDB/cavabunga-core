package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Related extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties that specify an alarm trigger with a "DURATION" value type.
        super.validate();
        if(!this.getValue().equals("START") && !this.getValue().equals("END")){
            throw new Validation("RELATED value is different from acceptable value range: " + this.getValue());
        }
    }
}
