package tr.edu.itu.cavabunga.lib.entity.component;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Journal extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Calendar)){
            throw new Validation("Journal component parent should be a Calendar");
        }

        super.validate();

        List<PropertyType> optionalOnceList = new ArrayList<>();
        optionalOnceList.add(PropertyType.Class);
        optionalOnceList.add(PropertyType.Created);
        optionalOnceList.add(PropertyType.Description);
        optionalOnceList.add(PropertyType.Dtstamp);
        optionalOnceList.add(PropertyType.Dtstart);
        optionalOnceList.add(PropertyType.Lastmod);
        optionalOnceList.add(PropertyType.Organizer);
        optionalOnceList.add(PropertyType.Recurid);
        optionalOnceList.add(PropertyType.Seq);
        optionalOnceList.add(PropertyType.Status);
        optionalOnceList.add(PropertyType.Summary);
        optionalOnceList.add(PropertyType.Uid);
        optionalOnceList.add(PropertyType.Url);
        this.validateAtLeastHaveOneProperties(optionalOnceList);
    }
}
