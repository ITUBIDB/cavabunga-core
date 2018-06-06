package edu.itu.cavabunga.lib.factory;

import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.entity.parameter.ParameterType;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component
public class ParameterFactoryImpl implements ParameterFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Parameter createParameter(ParameterType parameterType) {
        return parameterType.create();
    }
}