package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Daylight extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Timezone)){
            throw new Validation("Daylight component cannot be child of :" + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> requireOnceList = new ArrayList<>();
        requireOnceList.add(PropertyType.Dtstart);
        requireOnceList.add(PropertyType.Tzname);
        requireOnceList.add(PropertyType.Tzoffsetfrom);
        super.validateShouldHaveOneProperties(requireOnceList);
    }
}
