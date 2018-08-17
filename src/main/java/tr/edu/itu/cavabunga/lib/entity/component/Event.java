package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Calendar)){
           throw new Validation("Event component parent should be a Calendar");
        }

        super.validate();

        List<PropertyType> optionalOnceList = new ArrayList<>();

        optionalOnceList.add(PropertyType.Created);
        optionalOnceList.add(PropertyType.Description);
        optionalOnceList.add(PropertyType.Dtstamp);
        optionalOnceList.add(PropertyType.Dtstart);
        optionalOnceList.add(PropertyType.Geo);
        optionalOnceList.add(PropertyType.Lastmod);
        optionalOnceList.add(PropertyType.Location);
        optionalOnceList.add(PropertyType.Organizer);
        optionalOnceList.add(PropertyType.Priority);
        optionalOnceList.add(PropertyType.Recurid);
        optionalOnceList.add(PropertyType.Seq);
        optionalOnceList.add(PropertyType.Status);
        optionalOnceList.add(PropertyType.Summary);
        optionalOnceList.add(PropertyType.Transp);
        optionalOnceList.add(PropertyType.Uid);
        optionalOnceList.add(PropertyType.Url);
        super.validateAtMostHaveOneProperties(optionalOnceList);

        List<PropertyType> requiredOnceList = new ArrayList<>();
        requiredOnceList.add(PropertyType.Dtend);
        requiredOnceList.add(PropertyType.Duration);
        super.validateAtLeastHaveOneProperties(requiredOnceList);
    }
}
