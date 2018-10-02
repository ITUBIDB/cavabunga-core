package tr.edu.itu.cavabunga.lib.entity;

import com.fasterxml.jackson.annotation.*;
import tr.edu.itu.cavabunga.lib.entity.property.*;
import tr.edu.itu.cavabunga.lib.entity.property.Class;
import tr.edu.itu.cavabunga.lib.entity.property.Version;
import tr.edu.itu.cavabunga.lib.exception.Validation;
import lombok.Data;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force=true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Acknowledged.class, name = "Acknowledged"),
        @JsonSubTypes.Type(value = Action.class, name = "Action"),
        @JsonSubTypes.Type(value = Attach.class, name = "Attach"),
        @JsonSubTypes.Type(value = Calscale.class, name = "Calscale"),
        @JsonSubTypes.Type(value = Attendee.class, name = "Attendee"),
        @JsonSubTypes.Type(value = Catagories.class, name = "Catagories"),
        @JsonSubTypes.Type(value = Class.class, name = "Class"),
        @JsonSubTypes.Type(value = Comment.class, name = "Comment"),
        @JsonSubTypes.Type(value = Completed.class, name = "Completed"),
        @JsonSubTypes.Type(value = Contact.class, name = "Contact"),
        @JsonSubTypes.Type(value = Country.class, name = "Country"),
        @JsonSubTypes.Type(value = Created.class, name = "Created"),
        @JsonSubTypes.Type(value = Description.class, name = "Description"),
        @JsonSubTypes.Type(value = Dtend.class, name = "Dtend"),
        @JsonSubTypes.Type(value = Dtstamp.class, name = "Dtstamp"),
        @JsonSubTypes.Type(value = Dtstart.class, name = "Dtstart"),
        @JsonSubTypes.Type(value = Due.class, name = "Due"),
        @JsonSubTypes.Type(value = Duration.class, name = "Duration"),
        @JsonSubTypes.Type(value = Exdate.class, name = "Exdate"),
        @JsonSubTypes.Type(value = Exrule.class, name = "Exrule"),
        @JsonSubTypes.Type(value = Freebusy.class, name = "Freebusy"),
        @JsonSubTypes.Type(value = Geo.class, name = "Geo"),
        @JsonSubTypes.Type(value = Lastmod.class, name = "Lastmod"),
        @JsonSubTypes.Type(value = Location.class, name = "Location"),
        @JsonSubTypes.Type(value = Method.class, name = "Method"),
        @JsonSubTypes.Type(value = Organizer.class, name = "Organizer"),
        @JsonSubTypes.Type(value = Percent.class, name = "Percent"),
        @JsonSubTypes.Type(value = Priority.class, name = "Priority"),
        @JsonSubTypes.Type(value = Prodid.class, name = "Prodid"),
        @JsonSubTypes.Type(value = Rdate.class, name = "Rdate"),
        @JsonSubTypes.Type(value = Recurid.class, name = "Recurid"),
        @JsonSubTypes.Type(value = Related.class, name = "Related"),
        @JsonSubTypes.Type(value = Repeat.class, name = "Repeat"),
        @JsonSubTypes.Type(value = Resources.class, name = "Resources"),
        @JsonSubTypes.Type(value = Rrule.class, name = "Rrule"),
        @JsonSubTypes.Type(value = Rstatus.class, name = "Rstatus"),
        @JsonSubTypes.Type(value = Seq.class, name = "Seq"),
        @JsonSubTypes.Type(value = Status.class, name = "Status"),
        @JsonSubTypes.Type(value = Summary.class, name = "Summary"),
        @JsonSubTypes.Type(value = Transp.class, name = "Transp"),
        @JsonSubTypes.Type(value = Trigger.class, name = "Trigger"),
        @JsonSubTypes.Type(value = Tzid.class, name = "Tzid"),
        @JsonSubTypes.Type(value = Tzname.class, name = "Tzname"),
        @JsonSubTypes.Type(value = Tzoffsetfrom.class, name = "Tzoffsetfrom"),
        @JsonSubTypes.Type(value = Tzoffsetto.class, name = "Tzoffsetto"),
        @JsonSubTypes.Type(value = Tzurl.class, name = "Tzurl"),
        @JsonSubTypes.Type(value = Uid.class, name = "Uid"),
        @JsonSubTypes.Type(value = Url.class, name = "Url"),
        @JsonSubTypes.Type(value = Version.class, name = "Version")
})

@Data
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id")
    @JsonBackReference
    private Component component;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Parameter> parameters = new ArrayList<>();

    public void addParameter(Parameter parameter){
        parameter.setProperty(this);
        parameters.add(parameter);
    }

    public void validate() {
        if(!this.parameters.isEmpty()) {
            for(Parameter pr : this.parameters) {
                try {
                    pr.validate();
                } catch (Exception e){
                    throw new Validation(this.getClass().getName() + " property class validation failed: " + e.getMessage());
                }
            }
        }
    }

    public void validateValueType(PropertyValueType propertyValueType){
		if (propertyValueType == PropertyValueType.BINARY) {
			if (!value.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$")) {
				throw new Validation(this.getClass().getName() + " value is not valid BINARY type");
			}
		} else if (propertyValueType == PropertyValueType.BOOLEAN) {
			if (!value.equals("TRUE") && !value.equals("FALSE")) {
				throw new Validation(this.getClass().getName() + " value is not valid BOOLEAN type " + value);
			}
		} else if (propertyValueType == PropertyValueType.CALADDRESS) {
			//TODO: there is a full rfc about it: rfc3986
		} else if (propertyValueType == PropertyValueType.DATE) {
			String[] parts = value.split(",");
			for (String part : parts) {
				if (!part.matches("^[0-9]{8}$")) {
					throw new Validation(this.getClass().getName() + " value is not valid DATE type " + value);
				}
			}
		} else if (propertyValueType == PropertyValueType.DATETIME) {
			String[] parts = value.split(",");
			for (String part : parts) {
				if (!part.matches("^[0-9]{8}T[0-9]{6}|[0-9]{8}T[0-9]{6}Z")) {
					throw new Validation(this.getClass().getName() + " value is not valid DATE-TIME type " + value);
				}
			}
		} else if (propertyValueType == PropertyValueType.DURATION) {
			//TODO: rfc5545 pg 35
		} else if (propertyValueType == PropertyValueType.FLOAT) {
			try {
				Float.parseFloat(value);
			} catch (NumberFormatException e) {
				//TODO: GEO property has a value type in 'float;float' format !!
				throw new Validation(this.getClass().getName() + " value is not valid FLOAT type " + value);
			}
		} else if (propertyValueType == PropertyValueType.INTEGER) {
			try {
				Integer.parseInt(value);
			} catch (NumberFormatException e) {
				throw new Validation(this.getClass().getName() + " value is not valid INTEGER type" + value);
			}
		} else if (propertyValueType == PropertyValueType.PERIOD) {
			//TODO: rfc5545 pg 36
		} else if (propertyValueType == PropertyValueType.RECUR) {
			//TODO: rfc5545 pg 37-45
		} else if (propertyValueType == PropertyValueType.TEXT) {
			//TODO: rfc5545 pg 45
		} else if (propertyValueType == PropertyValueType.TIME) {
			String[] parts = value.split(",");
			for (String part : parts) {
				if (!part.matches("^[0-9]{6}$|^[0-9]{6}Z$")) {
					throw new Validation(this.getClass().getName() + " value is not valid TIME type " + value);
				}
			}
		} else if (propertyValueType == PropertyValueType.URI) {
			//TODO: there is a full rfc about it: rfc3986
		} else if (propertyValueType == PropertyValueType.UTCOFFSET) {
			String[] parts = value.split(",");
			for (String part : parts) {
				if (!part.matches("^[-+][0-9]{4}$|^[-+][0-9]{4}Z$")) {
					throw new Validation(this.getClass().getName() + " value is not valid TIME type " + value);
				}
			}
		} else {
			throw new Validation(this.getClass().getName() + " unknown value type " + value);
		}
    }
}
