package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Range extends Parameter {
    @Override
    public void validate(){
        //TODO:  This parameter can be specified on a property that specifies a recurrence identifier.
        super.validate();

        if(this.getValue().equals("THISANDFUTURE")){
            throw new Validation("RANGE parameter can only have THISANDFUTURE value: " + this.getValue());
        }
    }
}
