package tr.edu.itu.cavabunga.lib.factory;

import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import org.springframework.stereotype.Component;

/**
 * Factory for all property types
 * @see PropertyType
 * @see Property
 */
@Component
public class PropertyFactoryImpl implements PropertyFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Property createProperty(PropertyType propertyType) {
        return propertyType.create();
    }
}
