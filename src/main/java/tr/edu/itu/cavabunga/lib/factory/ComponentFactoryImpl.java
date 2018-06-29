package tr.edu.itu.cavabunga.lib.factory;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.component.ComponentType;

/**
 * Factory for all property types
 * @see ComponentType
 * @see Component
 */
@org.springframework.stereotype.Component
public class ComponentFactoryImpl implements ComponentFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Component createComponent(ComponentType componentType){ return componentType.create(); }
}
