package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Altrep extends Parameter {
    @Override
    public void validate(){
        super.validate();
        if(!this.getValue().substring(0,1).equals("\"") || !this.getValue().substring(this.getValue().length() -1).equals("\"")){
            throw new Validation("ALTREP parameter must start and end with DQUOTE char.");
        }

    }
}
