package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Calendar extends Component {
    @Override
    public void validate() {
        if(this.getParent() != null) {
            throw new Validation("Calendar component cannot have parent component");
        }

        super.validate();

        List<PropertyType> optionalOnceList = new ArrayList<>();
        optionalOnceList.add(PropertyType.Calscale);
        optionalOnceList.add(PropertyType.Method);
        super.validateAtMostHaveOneProperties(optionalOnceList);

        List<PropertyType> requiredOnceList = new ArrayList<>();
        requiredOnceList.add(PropertyType.Prodid);
        requiredOnceList.add(PropertyType.Version);
        super.validateShouldHaveOneProperties(requiredOnceList);
    }
}
