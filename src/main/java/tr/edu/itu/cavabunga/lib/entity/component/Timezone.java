package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Timezone extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Calendar)){
            throw new Validation("Timezone component cannot be child of:" + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> optionalOneList = new ArrayList<>();
        optionalOneList.add(PropertyType.Lastmod);
        optionalOneList.add(PropertyType.Tzurl);
        super.validateAtMostHaveOneProperties(optionalOneList);

        List<PropertyType> requiredOneList = new ArrayList<>();
        requiredOneList.add(PropertyType.Tzid);
        super.validateShouldHaveOneProperties(requiredOneList);
    }
}
