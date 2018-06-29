package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Encoding extends Parameter {
    @Override
    public void validate(){
        super.validate();

        if(!this.getValue().equals("BASE64") && !this.getValue().equals("8BIT")){
            throw new Validation("ENCODING value is different from acceptable value range: " + this.getValue());
        }

        for(Parameter pr : this.getProperty().getParameters()){
            if( (pr instanceof Value) && pr.getValue().equals("BINARY") && !this.getValue().equals("BASE64")){
                throw new Validation("While VALUE parameter described as BINARY, ENCODING parameter MUST set as BASE64");
            }
        }
    }
}
