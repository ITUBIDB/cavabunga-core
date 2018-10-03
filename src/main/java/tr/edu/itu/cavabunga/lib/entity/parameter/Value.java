package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyValueType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Value extends Parameter {
    @Override
    public void validate(){
        super.validate();
        if(!isValueValid()){
            throw new Validation("VALUE value is different from acceptable value range: " + this.getValue());
        }
    }

    private boolean isValueValid() {
        for (PropertyValueType p : PropertyValueType.values()) {
            if (p.name().equals(this.getValue())) {
                return true;
            }
        }
        return false;
    }
}
