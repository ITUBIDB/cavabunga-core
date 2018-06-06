package edu.itu.cavabunga.lib.entity.component;

import edu.itu.cavabunga.lib.entity.Component;
import edu.itu.cavabunga.lib.entity.property.PropertyType;
import edu.itu.cavabunga.lib.exception.Validation;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Todo extends Component{
    @Override
    public void validate(){
        if(!(this.getParent() instanceof Calendar)){
            throw new Validation("Todo component cannot be child of:" + this.getParent().getClass().getName());
        }

        super.validate();

        List<PropertyType> optionalOneList = new ArrayList<>();
        optionalOneList.add(PropertyType.Class);
        optionalOneList.add(PropertyType.Completed);
        optionalOneList.add(PropertyType.Created);
        optionalOneList.add(PropertyType.Description);
        optionalOneList.add(PropertyType.Dtstamp);
        optionalOneList.add(PropertyType.Dtstart);
        optionalOneList.add(PropertyType.Geo);
        optionalOneList.add(PropertyType.Lastmod);
        optionalOneList.add(PropertyType.Location);
        optionalOneList.add(PropertyType.Organizer);
        optionalOneList.add(PropertyType.Percent);
        optionalOneList.add(PropertyType.Priority);
        optionalOneList.add(PropertyType.Recurid);
        optionalOneList.add(PropertyType.Seq);
        optionalOneList.add(PropertyType.Status);
        optionalOneList.add(PropertyType.Summary);
        optionalOneList.add(PropertyType.Uid);
        optionalOneList.add(PropertyType.Url);
        super.validateOptionalOneProperties(optionalOneList);

        List<PropertyType> requireOneList = new ArrayList<>();
        requireOneList.add(PropertyType.Due);
        requireOneList.add(PropertyType.Duration);
        super.validateRequiredOneProperties(requireOneList);
    }
}