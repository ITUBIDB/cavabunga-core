package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;

@Entity
public class Lastmod extends Property {
    //TODO: LAST-MODIFIED Class name change
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.DATETIME);
    }
}
