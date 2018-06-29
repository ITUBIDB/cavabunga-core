package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.exception.Validation;
import tr.edu.itu.cavabunga.lib.entity.property.*;

import javax.persistence.Entity;

@Entity
public class Tzid extends Parameter {
    @Override
    public void validate(){
        super.validate();
        if(!(this.getProperty() instanceof Dtstart) &&
                !(this.getProperty() instanceof Dtend) &&
                !(this.getProperty() instanceof Due) &&
                !(this.getProperty() instanceof Exdate) &&
                !(this.getProperty() instanceof Rdate)){
            throw new Validation("TZID parameter can only be use in Dtstart, Dtend, Due, Exdate and Rdate properties: " + this.getProperty().getClass().getName());
        }

        //TODO: Validate TZID string matches with the Calendar's VTIMEZONE component's TZID identifier


    }
}
