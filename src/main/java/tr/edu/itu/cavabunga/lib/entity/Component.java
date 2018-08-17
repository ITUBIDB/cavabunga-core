package tr.edu.itu.cavabunga.lib.entity;

import com.fasterxml.jackson.annotation.*;
import tr.edu.itu.cavabunga.lib.entity.component.*;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.lib.exception.Validation;
import lombok.Data;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force=true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Alarm.class, name = "Alarm"),
        @JsonSubTypes.Type(value = Calendar.class, name = "Calendar"),
        @JsonSubTypes.Type(value = Daylight.class, name = "Daylight"),
        @JsonSubTypes.Type(value = Event.class, name = "Event"),
        @JsonSubTypes.Type(value = Freebusy.class, name = "Freebusy"),
        @JsonSubTypes.Type(value = Journal.class, name = "Journal"),
        @JsonSubTypes.Type(value = Standard.class, name = "Standard"),
        @JsonSubTypes.Type(value = Timezone.class, name = "Timezone"),
        @JsonSubTypes.Type(value = Todo.class, name = "Todo")
})

@Data
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_uuid")
    @JsonBackReference(value = "participantAndComponent")
    private Participant owner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    @JsonBackReference
    private Component parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Component> components = new ArrayList<>();

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Property> properties = new ArrayList<>();

    @CreatedDate
    private Date creationDate;

    public void addComponent(Component component) {
        component.setParent(this);
        component.setOwner(this.owner);
        components.add(component);
    }

    public void addProperty(Property property) {
        property.setComponent(this);
        properties.add(property);
    }

    public void validate() {
        if(!components.isEmpty()) {
            for (Component c : components){
                try {
                    c.validate();
                } catch (Exception e) {
                    throw new Validation(this.getClass().getName() + " component's sub component validation failed: " + e.getMessage());
                }
            }
        }

        if(!properties.isEmpty()) {
            for(Property p : properties) {
                try {
                    p.validate();
                }catch (Exception e){
                    throw new Validation(this.getClass().getName() + " component property validation failed " + e.getMessage());
                }
            }
        }
    }
    protected void validateAtLeastHaveOneProperties(List<PropertyType> propertyTypeList) {
        for(PropertyType pt : propertyTypeList){
            long propertyCount = containsInstance(pt);

            if(propertyCount < 1){
                throw new Validation("Component validation failed in at least have one properties check: " + pt.create().getClass().getName());
            }
        }
    }

    protected void validateShouldHaveOneProperties(List<PropertyType> propertyTypeList) {
        for(PropertyType pt : propertyTypeList) {
            long propertyCount = containsInstance(pt);
            if(propertyCount != 1){
                throw new Validation("Component validation failed in should have one properties check. Count " + propertyCount + ": " + pt.create().getClass().getName());
            }
        }
    }

    protected void validateAtMostHaveOneProperties(List<PropertyType> propertyTypeList) {
        for(PropertyType pt : propertyTypeList) {
            long propertyCount = containsInstance(pt);

            if(propertyCount > 1) {
                throw new Validation("Component validation failed in at most have one properties check: " + pt.getClass().getName());
            }
        }
    }


    private long containsInstance( PropertyType  propertyType) {
		int count = 0;
		for (Property e : properties) {
			if (e.getName().equals(propertyType.name())) {
				count++;
			}
		}
		return count;
    }
}
