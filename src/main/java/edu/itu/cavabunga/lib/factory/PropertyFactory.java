package edu.itu.cavabunga.lib.factory;

import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.entity.property.PropertyType;

/**
 * Factory interface for all property types
 * @see PropertyType
 * @see Property
 */
public interface PropertyFactory {

    /**
     * creates property in desired type
     *
     * @param propertyType type of the property
     * @return created property object
     */
    Property createProperty(PropertyType propertyType);
}
