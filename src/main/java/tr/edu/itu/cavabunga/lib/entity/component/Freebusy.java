package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Freebusy extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Calendar)){
            throw new Validation("Freebusy component parent should be a Calendar");
        }

        super.validate();

        List<PropertyType> optionalOnceList = new ArrayList<>();
        optionalOnceList.add(PropertyType.Contact);
        optionalOnceList.add(PropertyType.Dtend);
        optionalOnceList.add(PropertyType.Dtstamp);
        optionalOnceList.add(PropertyType.Dtstart);
        optionalOnceList.add(PropertyType.Duration);
        optionalOnceList.add(PropertyType.Organizer);
        optionalOnceList.add(PropertyType.Uid);
        optionalOnceList.add(PropertyType.Url);
        super.validateAtMostHaveOneProperties(optionalOnceList);
    }
}
