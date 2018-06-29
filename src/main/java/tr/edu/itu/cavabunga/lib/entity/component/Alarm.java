package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alarm extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Event) && !(this.getParent() instanceof Todo)){
            throw new Validation("Alarm component can only be child of Event and Todo, not: " + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> requireOneList = new ArrayList<>();
        requireOneList.add(PropertyType.Action);
        requireOneList.add(PropertyType.Trigger);
        super.validateRequiredOneProperties(requireOneList);

        List<PropertyType> optionalOneList = new ArrayList<>();
        optionalOneList.add(PropertyType.Due);
        optionalOneList.add(PropertyType.Repeat);
        super.validateOptionalOneProperties(optionalOneList);
    }
}
