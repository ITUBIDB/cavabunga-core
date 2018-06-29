package tr.edu.itu.cavabunga.lib.entity.property;

import tr.edu.itu.cavabunga.lib.entity.Property;

import javax.persistence.Entity;

@Entity
public class Seq extends Property {
//TODO: implement SEQUENCE
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.INTEGER);
    }
}
