package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Standard extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Timezone)){
            throw new Validation("Standard component cannot be child of :" + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> requireOneList = new ArrayList<>();
        requireOneList.add(PropertyType.Dtstart);
        requireOneList.add(PropertyType.Tzname);
        requireOneList.add(PropertyType.Tzoffsetfrom);
        super.validateShouldHaveOneProperties(requireOneList);
    }
}
