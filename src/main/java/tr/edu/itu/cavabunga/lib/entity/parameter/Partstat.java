package tr.edu.itu.cavabunga.lib.entity.parameter;

import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.component.Event;
import tr.edu.itu.cavabunga.lib.entity.component.Journal;
import tr.edu.itu.cavabunga.lib.entity.component.Todo;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Partstat extends Parameter {
    @Override
    public void validate(){
        //TODO: This parameter can be specified on properties with a CAL-ADDRESS value type
        super.validate();

        if(this.getProperty().getComponent() instanceof Event){
            if(!this.getValue().equals("NEEDS-ACTION") &&
                    !this.getValue().equals("ACCEPTED") &&
                    !this.getValue().equals("DECLINED") &&
                    !this.getValue().equals("TENTATIVE") &&
                    !this.getValue().equals("DELEGATED")){
                throw new Validation("PARTSTAT value is different from acceptable value range in an Event component: " + this.getValue());
            }
        }

        if(this.getProperty().getComponent() instanceof Todo){
            if(!this.getValue().equals("NEEDS-ACTION") &&
                    !this.getValue().equals("ACCEPTED") &&
                    !this.getValue().equals("DECLINED") &&
                    !this.getValue().equals("TENTATIVE") &&
                    !this.getValue().equals("DELEGATED") &&
                    !this.getValue().equals("COMPLETED") &&
                    !this.getValue().equals("IN-PROCESS")){
                throw new Validation("PARTSTAT value is different from acceptable value range in a Todo component: " + this.getValue());
            }
        }

        if(this.getProperty().getComponent() instanceof Journal){
            if(!this.getValue().equals("NEEDS-ACTION") &&
                    !this.getValue().equals("ACCEPTED") &&
                    !this.getValue().equals("DECLINED")){
                throw new Validation("PARTSTAT value is different from acceptable value range in a Journal component " + this.getValue());
            }
        }
    }
}
