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
            throw new Validation("Alaram component parent should be a Event or Todo");
        }

        super.validate();

        List<PropertyType> requireOnceList = new ArrayList<>();
        requireOnceList.add(PropertyType.Action);
        requireOnceList.add(PropertyType.Trigger);
        super.validateShouldHaveOneProperties(requireOnceList);

        List<PropertyType> optionalOnceList = new ArrayList<>();
        optionalOnceList.add(PropertyType.Due);
        optionalOnceList.add(PropertyType.Repeat);
        super.validateAtMostHaveOneProperties(optionalOnceList);
    }
}
