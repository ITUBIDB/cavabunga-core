package edu.itu.cavabunga.lib.entity.component;

import edu.itu.cavabunga.lib.entity.Component;
import edu.itu.cavabunga.lib.entity.property.PropertyType;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Journal extends Component {
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Component)){
            throw new Validation("Journal component cannot be child of: " + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> optionalOneList = new ArrayList<>();
        optionalOneList.add(PropertyType.Class);
        optionalOneList.add(PropertyType.Created);
        optionalOneList.add(PropertyType.Description);
        optionalOneList.add(PropertyType.Dtstamp);
        optionalOneList.add(PropertyType.Dtstart);
        optionalOneList.add(PropertyType.Lastmod);
        optionalOneList.add(PropertyType.Organizer);
        optionalOneList.add(PropertyType.Recurid);
        optionalOneList.add(PropertyType.Seq);
        optionalOneList.add(PropertyType.Status);
        optionalOneList.add(PropertyType.Summary);
        optionalOneList.add(PropertyType.Uid);
        optionalOneList.add(PropertyType.Url);
        super.validateOptionalOneProperties(optionalOneList);
    }
}
