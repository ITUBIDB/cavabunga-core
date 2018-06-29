package tr.edu.itu.cavabunga.lib.factory;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.component.ComponentType;

/**
 * Factory for all property types
 * @see ComponentType
 * @see Component
 */
public interface ComponentFactory {

    /**
     * creates component in desired type
     *
     * @param componentType type of the component
     * @return created component object
     */
    Component createComponent(ComponentType componentType);
}
